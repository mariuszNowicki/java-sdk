package isaacloud;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minidev.json.JSONObject;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicStatusLine;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConnectorTest {

	static String baseApiUrl = "any";
	static String baseOAuthUrl = "any";
	static String version = "v1";
	static HashMap<String, String> config = new HashMap<String, String>();

	static Connector connector = null;
	static CloseableHttpResponse response = mock(CloseableHttpResponse.class);
	static CloseableHttpClient client = mock(CloseableHttpClient.class);

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@BeforeClass
	public static void beforeAll() {

		config.put("clientId", "abc");
		config.put("secret", "abc");
		connector = new Connector(baseApiUrl, baseOAuthUrl, version, config) {
		};

		try {
			when(client.execute(any(HttpUriRequest.class)))
					.thenReturn(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSetupSSL() throws ClientProtocolException, Exception {

		CloseableHttpClient client = connector.setupSSL(null);

		assert (client != null);
		assert (connector.certificate != null);

	}

	@Test
	public void testGetAuthenticationPost() throws Exception {

		HttpPost method = connector.getAuthenticationPost();
		assert (method.containsHeader("Authorization"));

	}

	@Test
	public void testConsumeResponse() throws Exception {

		HttpEntity ent = new StringEntity("{ \"access_token\" : \"aaabbb\"}");
		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));

		String token = connector.consumeResponse(response);

		assert (token != null);
		assert (token.equals("aaabbb"));

		exception.expect(UnauthorizedException.class);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 401, "any"));
		token = connector.consumeResponse(response);

	}

	@Test
	public void testConsumeResponse401() throws Exception {

		HttpEntity ent = new StringEntity("{ \"access_token\" : \"aaabbb\"}");
		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 401, "any"));

		exception.expect(UnauthorizedException.class);

		connector.consumeResponse(response);

	}

	@Test
	public void testConsumeResponse403() throws Exception {

		HttpEntity ent = new StringEntity("{ \"access_token\" : \"aaabbb\"}");
		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 403, "any"));

		exception.expect(ForbiddenException.class);

		connector.consumeResponse(response);

	}

	@Test
	public void testConsumeResponseOther() throws Exception {

		HttpEntity ent = new StringEntity("{ \"access_token\" : \"aaabbb\"}");
		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 221, "any"));

		exception.expect(IsaacloudConnectionException.class);

		connector.consumeResponse(response);

	}

	@Test
	public void testGetAuthentication() throws Exception {

		String token = "aaabbb";
		connector.client = client;

		HttpEntity ent = new StringEntity("{ \"access_token\" : \"" + token
				+ "\"}");
		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));

		String res = connector.getAuthentication();

		assert (res.equals("Bearer " + token));

		res = connector.getAuthentication();

		assert (res.equals("Bearer " + token));
		verify(response, times(1)).getEntity();
	}

	@Test
	public void testPrepareUrl() throws Exception {

		String uri = "/cache/users/{userId}";
		String expected = "/cache/users/1?segments=1,2&groups=1";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", 1);
		
		List<Long> segments = new ArrayList<Long>();
		segments.add(new Long(1));
		segments.add(new Long(2));
		params.put("segments", segments);
		params.put("groups", 1);
		String res = connector.prepareUrl(uri, params);

		assert (res.equals(expected));
	}

	@Test
	public void testMakeRequestSimple() throws Exception {

		String expected = "{\"id\":1}";

		connector.client = client;
		HttpEntity ent = new StringEntity(expected);

		HttpUriRequest method = new HttpGet("/");
		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));
		when(response.getHeaders(anyString())).thenReturn(new Header[0]);

		Response res = connector.makeRequest(method);

		assert (res.getJson().toString().equals(expected));

	}

	@Test
	public void testMakeRequestList() throws Exception {

		String expected = "[{\"id\":1}]";
		int limit = 10;
		int total = 13;
		int offset = 1;

		connector.client = client;
		HttpEntity ent = new StringEntity(expected);

		HttpUriRequest method = new HttpGet("/");
		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));

		Header[] header = new Header[1];
		header[0] = new BasicHeader("Collection-Paginator", "{\"limit\":"
				+ limit + ",\"offset\":" + offset + ",\"total\":" + total + "}");

		when(response.getHeaders(anyString())).thenReturn(header);

		Response res = connector.makeRequest(method);

		assert (res.getJson().toString().equals(expected));
		assert (res.getClass() == ListResponse.class);
		assert( ((ListResponse)res).getLimit() == limit );
		assert( ((ListResponse)res).getOffset() == offset );
		assert( ((ListResponse)res).getTotal() == total );
	}
	
	@Test
	public void testMakeRequestError404() throws Exception {

		String expected = "{}";
		connector.client = client;
		HttpEntity ent = new StringEntity(expected);
		HttpUriRequest method = new HttpGet("/");
		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 404, "any"));

		exception.expect(NotFoundException.class);
		connector.makeRequest(method);

	}
	
	@Test
	public void testMakeRequestError500() throws Exception {

		String expected = "{}";
		connector.client = client;
		HttpEntity ent = new StringEntity(expected);
		HttpUriRequest method = new HttpGet("/");
		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 500, "any"));

		exception.expect(InternalServerException.class);
		connector.makeRequest(method);

	}
	
	@Test
	public void testMakeRequestError400() throws Exception {

		String expected = "{}";
		connector.client = client;
		HttpEntity ent = new StringEntity(expected);
		HttpUriRequest method = new HttpGet("/");
		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 400, "any"));

		exception.expect(BadRequestException.class);
		connector.makeRequest(method);

	}
	
	@Test
	public void testMakeRequestError401() throws Exception {

		String expected = "{}";
		connector.client = client;
		HttpEntity ent = new StringEntity(expected);
		HttpUriRequest method = new HttpGet("/");
		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 401, "any"));

		exception.expect(UnauthorizedException.class);
		connector.makeRequest(method);

	}
	
	@Test
	public void testMakeRequestError402() throws Exception {

		String expected = "{}";
		connector.client = client;
		HttpEntity ent = new StringEntity(expected);
		HttpUriRequest method = new HttpGet("/");
		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 402, "any"));

		exception.expect(PaymentRequiredException.class);
		connector.makeRequest(method);

	}
	
	@Test
	public void testMakeRequestError403() throws Exception {

		String expected = "{}";
		connector.client = client;
		HttpEntity ent = new StringEntity(expected);
		HttpUriRequest method = new HttpGet("/");
		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 403, "any"));

		exception.expect(ForbiddenException.class);
		connector.makeRequest(method);

	}
	
	@Test
	public void testMakeRequestErrorOther() throws Exception {

		String expected = "{}";
		connector.client = client;
		HttpEntity ent = new StringEntity(expected);
		HttpUriRequest method = new HttpGet("/");
		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 413, "any"));

		exception.expect(IsaacloudConnectionException.class);
		connector.makeRequest(method);

	}
	
	@Test
	public void testCallServiceWithoutBody() throws Exception {

		String expected = "{\"id\":1}";

		connector.client = client;
		HttpEntity ent = new StringEntity(expected);

		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));
		when(response.getHeaders(anyString())).thenReturn(new Header[0]);

		Response res = connector.callService("/users", "get", new HashMap<String,Object>(), null);

		assert (res.getJson().toString().equals(expected));

	}
	
	@Test
	public void testCallServiceWithBody() throws Exception {

		String expected = "{\"id\":1}";

		connector.client = client;
		HttpEntity ent = new StringEntity(expected);

		connector.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));
		when(response.getHeaders(anyString())).thenReturn(new Header[0]);

		Response res = connector.callService("/users", "post", new HashMap<String,Object>(), new JSONObject());

		assert (res.getJson().toString().equals(expected));

	}
}
