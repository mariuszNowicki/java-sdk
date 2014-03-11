package isaacloud;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;

import net.minidev.json.JSONObject;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicStatusLine;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConnectorApiTest {
	static String baseApiUrl = "any";
	static String baseOAuthUrl = "any";
	static String version = "v1";
	static HashMap<String, String> config = new HashMap<String, String>();

	static Isaacloud isaacloud = null;
	static CloseableHttpResponse response = mock(CloseableHttpResponse.class);
	static CloseableHttpClient client = mock(CloseableHttpClient.class);

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@BeforeClass
	public static void beforeAll() {

		config.put("clientId", "abc");
		config.put("secret", "abc");
		isaacloud = new Isaacloud(config);

		try {
			when(client.execute(any(HttpUriRequest.class)))
					.thenReturn(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testApi() throws Exception {

		String expected = "{\"id\":1}";

		isaacloud.client = client;
		HttpEntity ent = new StringEntity(expected);

		isaacloud.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));
		when(response.getHeaders(anyString())).thenReturn(new Header[0]);

		Response res = isaacloud.api("/users", "post", new HashMap<String,Object>(), new JSONObject());

		assert (res.getJson().toString().equals(expected));

	}
	
	@Test
	public void testEvent() throws Exception {

		String expected = "{\"id\":1}";

		isaacloud.client = client;
		HttpEntity ent = new StringEntity(expected);

		isaacloud.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));
		when(response.getHeaders(anyString())).thenReturn(new Header[0]);

		Response res = isaacloud.event(1l,"USER","0",1l,"1",new JSONObject());

		assert (res.getJson().toString().equals(expected));

	}
}
