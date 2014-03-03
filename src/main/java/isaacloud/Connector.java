package isaacloud;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLContext;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public abstract class Connector {

	private String baseUrl;
	private String version;

	private final static Logger logger = Logger.getLogger(Connector.class
			.getName());
	private static String oauthUrl;
	private static String clientId;
	private static String clientSecret;
	private static long currentTokenTime = new Date().getTime() - 1;
	private static String currentToken = "";

	private static SSLConnectionSocketFactory sslsf = null;

	/**
	 * 
	 * @param baseUrl
	 * @param oauthUrl
	 * @param version
	 * @param config
	 */
	public Connector(String baseUrl, String oauthUrl, String version,
			Map<String, String> config) {

		CertificateFactory cf;
		// Setup ssl context
		try {

			// Load trusted IsaaCloud certificate
			cf = CertificateFactory.getInstance("X.509");
			InputStream caInput = new BufferedInputStream(getClass().getClassLoader()
					.getResource("isaacloud.cert").openStream());
			
			Certificate ca = cf.generateCertificate(caInput);
			
			caInput.close();
			
			KeyStore keyStore = KeyStore.getInstance(KeyStore
					.getDefaultType());

			keyStore.load(null, null);

			keyStore.setCertificateEntry("ca", ca);
			
			// Trust own CA and all self-signed certs
			SSLContext sslcontext = SSLContexts
					.custom()
					.loadTrustMaterial(keyStore,
							new TrustSelfSignedStrategy()).build();

			// Allow TLSv1 protocol only
			sslsf = new SSLConnectionSocketFactory(
					sslcontext,
					new String[] { "TLSv1" },
					null,
					SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.baseUrl = baseUrl + "/" + version;

		Connector.oauthUrl = oauthUrl;
		this.setVersion(version);

		if (config.containsKey("clientId")) {
			Connector.clientId = config.get("clientId");

		} else {
			// should be logged
			System.out.println("Did not define clientId");
		}

		if (config.containsKey("secret")) {
			// should be logged
			Connector.clientSecret = config.get("secret");
		} else {
			System.out.println("Did not define secret");
		}

	}

	/**
	 * Get the token, if it's outdated then retrieve it from the server.
	 * 
	 * @return Autroization value.
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	protected static String getAuthentication() {
		// Check the time
		long currentTime = new Date().getTime();

		if (currentTime > Connector.currentTokenTime) {

			Connector.currentTokenTime = currentTime + 3600 * 1000;
			HttpPost method = new HttpPost(Connector.oauthUrl + "/token");
			method.addHeader(
					"Authorization",
					"Basic "
							+ new String(
									Base64.encodeBase64((Connector.clientId
											+ ":" + Connector.clientSecret)
											.getBytes())));

			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("grant_type",
					"client_credentials"));
			try {
				method.setEntity(new UrlEncodedFormEntity(urlParameters));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			CloseableHttpClient client = HttpClients.custom()
					.setSSLSocketFactory(sslsf).build();

			StringBuffer result = new StringBuffer();

			try {

				CloseableHttpResponse response = client.execute(method);

				HttpEntity entity1 = response.getEntity();

				BufferedReader rd = new BufferedReader(new InputStreamReader(
						entity1.getContent()));

				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}

				EntityUtils.consume(entity1);
				response.close();

				int status = response.getStatusLine().getStatusCode();

				if (status != 200) {
					if (result.toString().trim().length() == 0)
						logger.severe("Call was unsuccessful, code returned:\n"
								+ response.getStatusLine());
					else
						logger.severe("Call was unsuccessful, code returned:\n"
								+ response.getStatusLine() + "\nReason: \n"
								+ result);
					return "Bearer " + currentToken;
				}

				JSONObject obj = new JSONObject(result.toString());

				Connector.currentToken = obj.get("access_token").toString();

			} catch (Exception e) {
				logger.severe("Error retrieving access token, reason:\n"
						+ e.getMessage());
			}

		}
		return "Bearer " + currentToken;
	}

	/**
	 * Make a request and write the string
	 * 
	 * @param method
	 * @return
	 */
	private String makeRequest(HttpUriRequest method) {

		CloseableHttpClient client = HttpClients.custom()
				.setSSLSocketFactory(sslsf).build();

		StringBuffer result = new StringBuffer();
		try {

			CloseableHttpResponse response = client.execute(method);

			HttpEntity entity1 = response.getEntity();

			int status = response.getStatusLine().getStatusCode();

			BufferedReader rd = new BufferedReader(new InputStreamReader(
					entity1.getContent()));

			String line = "";

			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			EntityUtils.consume(entity1);

			response.close();

			if (status != 200 && status != 201) {
				if (result.toString().trim().length() == 0)
					logger.warning("Call was unsuccessful, code returned:\n"
							+ response.getStatusLine());
				else
					logger.warning("Call was unsuccessful, code returned:\n"
							+ response.getStatusLine() + "\nReason: \n"
							+ result);
				return "{}";
			}

		} catch (Exception e) {
			logger.severe("Could not retrieve result, reason:\n"
					+ e.getMessage());
		}

		return result.toString();
	}

	/**
	 * 
	 * @param method
	 * @param uri
	 * @param parameters
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public String callService(String uri, String methodName,
			Map<String, Object> parameters, String body) {

		String wholeUri = this.baseUrl + uri;

		String regex = "\\{[a-zA-Z0-9,]+\\}";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(wholeUri);
		while (matcher.find()) {
			String id = matcher.group();
			String tmp = id.replace("{", "");
			tmp = tmp.replace("}", "");
			if (parameters.containsKey(tmp)) {
				String rep = parameters.get(tmp).toString();
				wholeUri = wholeUri.replace(id, rep);
				parameters.remove(tmp);
			}
		}

		String and = "?";
		for (Entry<String, Object> entry : parameters.entrySet()) {
			if (entry.getValue() != null)
				wholeUri = wholeUri + and + entry.getKey() + "="
						+ entry.getValue();
			and = "&";
		}

		HttpUriRequest method = null;
		if ("get".equals(methodName)) {
			method = new HttpGet(wholeUri);
		} else if ("delete".equals(methodName)) {
			method = new HttpDelete(wholeUri);
		} else if ("put".equals(methodName)) {
			method = new HttpPut(wholeUri);
		} else if ("post".equals(methodName)) {
			method = new HttpPost(wholeUri);
		} else if ("patch".equals(methodName)) {
			method = new HttpPatch(wholeUri);
		} else
			return "Method not supported";

		method.addHeader("Authorization", Connector.getAuthentication());

		if (body != null) {
			method.addHeader("Content-Type", "application/json charset=utf-8");

			((HttpEntityEnclosingRequestBase) method)
					.setEntity(new StringEntity(body,
							ContentType.APPLICATION_JSON));
		}

		String result = this.makeRequest(method);

		return result;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
