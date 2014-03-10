package isaacloud;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
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

public abstract class Connector {

	// fields for the instance of Connector
	protected String baseUrl;
	protected String version;
	private SSLConnectionSocketFactory sslsf = null;

	// fields for authentication
	protected String oauthUrl;
	protected String clientId = null;
	protected String clientSecret = null;
	protected long currentTokenTime = new Date().getTime() - 1;
	protected String currentToken = "";

	/**
	 * Basic constructor, requires setup.
	 * 
	 * @param baseUrl
	 *            base isaacloud api url
	 * @param oauthUrl
	 *            isaacloud oauth url
	 * @param version
	 *            isaacloud api version
	 * @param config
	 *            configuration with client id and version
	 */
	public Connector(String baseUrl, String oauthUrl, String version,
			Map<String, String> config) {

		this.baseUrl = baseUrl + "/" + version;

		this.oauthUrl = oauthUrl;

		this.version = version;
		
		setupSSL();

		if (config.containsKey("clientId"))
			this.clientId = config.get("clientId");

		if (config.containsKey("secret"))
			this.clientSecret = config.get("secret");

	}

	/**
	 * Creates a HttpPost object to be sent to oauth
	 * 
	 * @return HTTPPost to Oauth
	 * @throws UnsupportedEncodingException
	 */
	private HttpPost getAuthenticationPost() {

		HttpPost method = new HttpPost(this.oauthUrl + "/token");

		method.addHeader(
				"Authorization",
				"Basic "
						+ new String(
								Base64.encodeBase64((this.clientId + ":" + this.clientSecret)
										.getBytes())));

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();

		urlParameters.add(new BasicNameValuePair("grant_type",
				"client_credentials"));
		try {
			method.setEntity(new UrlEncodedFormEntity(urlParameters));
		} catch (UnsupportedEncodingException e) {
			// @TODO listener pattern
			// although this should never throw any exceptions

		}

		return method;
	}

	/**
	 * Analyze response and get the token.
	 * 
	 * @param response
	 *            from call execution.
	 * @return token as String
	 * @throws IOException
	 *             in case the response had an error
	 * @throws IsaacloudConnectionException
	 */
	private String consumeResponse(CloseableHttpResponse response)
			throws IOException, IsaacloudConnectionException {

		StringBuffer result = new StringBuffer();

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
			JSONObject error = (JSONObject) JSONValue.parse(result.toString());

			if (this.clientSecret == null)
				throw new IllegalArgumentException("Client secret not set.");
			else if (this.clientId == null)
				throw new IllegalArgumentException("Client id not set.");
			else if (status == 401)
				throw new UnauthorizedException(error);
			else if (status == 403)
				throw new ForbiddenException(error);
			else
				throw new IsaacloudConnectionException(error);
		}

		JSONObject obj = (JSONObject) JSONValue.parse(result.toString());

		return obj.get("access_token").toString();
	}

	/**
	 * Get the token, if it's outdated then retrieve it from the server.
	 * 
	 * @return token value.
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws IsaacloudConnectionException
	 */
	protected String getAuthentication() throws IOException,
			IsaacloudConnectionException {

		// check current time
		long currentTime = System.currentTimeMillis();

		if (currentTime > this.currentTokenTime) {

			// setup client
			CloseableHttpClient client = HttpClients.custom()
					.setSSLSocketFactory(sslsf).build();

			CloseableHttpResponse response = client
					.execute(getAuthenticationPost());

			this.currentToken = consumeResponse(response);

			this.currentTokenTime = currentTime + 3600 * 1000;
		}
		return "Bearer " + currentToken;
	}

	/**
	 * Used to setup the ssl context. Does not throw exceptions in order to 
	 */
	private void setupSSL() {
		
		try {
			
			// get the certificate from isaacloud.com			
			Certificate ca = SSLCertificateFactory.getCertificate(443, "isaacloud.com"); 			

			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

			keyStore.load(null, null);

			keyStore.setCertificateEntry("ca", ca);

			// trust own CA and all self-signed certs
			SSLContext sslcontext = SSLContexts.custom()
					.loadTrustMaterial(keyStore, new TrustSelfSignedStrategy())
					.build();

			// allow TLSv1 protocol only
			sslsf = new SSLConnectionSocketFactory(
					sslcontext,
					new String[] { "TLSv1" },
					null,
					SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Make a request and write to the string. *
	 * 
	 * @param request
	 *            method with parameters.
	 * @return response object as String
	 * @throws IOException
	 * @throws IllegalStateException
	 * @throws BadRequestException
	 */
	private Response makeRequest(HttpUriRequest method) throws IOException,
			IsaacloudConnectionException {

		CloseableHttpClient client = HttpClients.custom()
				.setSSLSocketFactory(sslsf).build();

		StringBuffer result = new StringBuffer();

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

		Header[] paginator = response.getHeaders("Collection-Paginator");

		response.close();

		if (status != 200 && status != 201) {
			JSONObject error = (JSONObject) JSONValue.parse(result.toString());
			if (status == 404)
				throw new NotFoundException(error);
			else if (status == 500)
				throw new InternalServerException(error);
			else if (status == 400)
				throw new BadRequestException(error);
			else if (status == 401)
				throw new UnauthorizedException(error);
			else if (status == 403)
				throw new ForbiddenException(error);
			else if (status == 402)
				throw new PaymentRequiredException(error);
			else
				throw new IsaacloudConnectionException(
						(JSONObject) JSONValue.parse(result.toString()));
		}

		if (paginator.length > 0) {

			JSONObject paginatorObject = (JSONObject) JSONValue
					.parse(paginator[0].getValue());
			JSONArray obj = (JSONArray) JSONValue.parse(result.toString());
			return new ListResponse(obj, Integer.parseInt(paginatorObject.get(
					"total").toString()), Integer.parseInt(paginatorObject.get(
					"limit").toString()), Integer.parseInt(paginatorObject.get(
					"offset").toString()));
		} else {

			JSONObject obj = (JSONObject) JSONValue.parse(result.toString());

			return new SimpleResponse(obj);
		}

	}

	/**
	 * Prepares the url with parameters.
	 * 
	 * @param wholeUri
	 * @param parameters
	 * @return
	 */
	private String prepareUrl(String wholeUri, Map<String, Object> parameters) {
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

		return wholeUri;
	}

	/**
	 * Constructs a request and send it.
	 * 
	 * @param method
	 *            - method type as lowercase (get,post,patch,put,delete)
	 * @param uri
	 *            - uri of the resource
	 * @param parameters
	 *            - additional parameters
	 * @return response as String
	 * @throws IOException
	 * @throws BadRequestException
	 * @throws IllegalStateException
	 * @throws ClientProtocolException
	 */
	public Response callService(String uri, String methodName,
			Map<String, Object> parameters, JSONObject body)
			throws IsaacloudConnectionException, IOException {

		String wholeUri = prepareUrl(this.baseUrl + uri, parameters);

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
			throw new UnsupportedOperationException(methodName
					+ " is not supported.");

		method.addHeader("Authorization", this.getAuthentication());

		if (body != null) {
			method.addHeader("Content-Type", "application/json charset=utf-8");

			((HttpEntityEnclosingRequestBase) method)
					.setEntity(new StringEntity(body.toJSONString(),
							ContentType.APPLICATION_JSON));
		}

		Response result = this.makeRequest(method);

		return result;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
