package com.isaacloud.sdk;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

public class ConnectorApiTest {
	static String baseApiUrl = "any";
	static String baseOAuthUrl = "any";
	static String version = "v1";
	static HashMap<String, String> config = new HashMap<>();

	static Isaacloud isaac = null;
	static CloseableHttpResponse response = mock(CloseableHttpResponse.class);
	static CloseableHttpClient client = mock(CloseableHttpClient.class);

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@BeforeClass
	public static void beforeAll() {

		config.put("clientId", "abc");
		config.put("secret", "abc");
		isaac = new Isaacloud(config);

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

		isaac.client = client;
		HttpEntity ent = new StringEntity(expected);

		isaac.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));
		when(response.getHeaders(anyString())).thenReturn(new Header[0]);

		Response res = isaac.api("/users", "post", new HashMap<String,Object>(), new JSONObject());

        assertEquals(res.getJson().toString(),expected);

    }

    @Test
    public void testCaller() throws Exception {

        String expected = "{\"id\":1}";

        isaac.client = client;
        HttpEntity ent = new StringEntity(expected);

        isaac.currentTokenTime = System.currentTimeMillis() + 100000;

        when(response.getEntity()).thenReturn(ent);
        when(response.getStatusLine()).thenReturn(
                new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));
        when(response.getHeaders(anyString())).thenReturn(new Header[0]);

        Response res = isaac.path("/cache/users").get();

        assertEquals(res.getJson().toString(),expected);

        Response res2 = isaac.path("/cache/users").put(null);

        assertEquals(res2.getJson().toString(),expected);

        Response res3 = isaac.path("/cache/users").delete();

        assertEquals(res3.getJson().toString(),expected);

        Response res4 = isaac.path("/cache/users").patch(null);

        assertEquals(res4.getJson().toString(),expected);

        Response res5 = isaac.path("/cache/users").post(null);
        assertEquals(res5.getJson().toString(),expected);
    }


	
	@Test
	public void testEvent() throws Exception {

		String expected = "{\"id\":1}";

		isaac.client = client;
		HttpEntity ent = new StringEntity(expected);

		isaac.currentTokenTime = System.currentTimeMillis() + 100000;

		when(response.getEntity()).thenReturn(ent);
		when(response.getStatusLine()).thenReturn(
				new BasicStatusLine(new ProtocolVersion("", 1, 2), 200, "any"));
		when(response.getHeaders(anyString())).thenReturn(new Header[0]);

		Response res = isaac.event(1l,"USER","0",1l,"1",new JSONObject());

        assertEquals(res.getJson().toString(),expected);

	}

    @Test
    public void testCustom(){

        String expected = "/cache/users?custom=true";

        Isaacloud.Caller called = isaac.path("/cache/users").withCustom();

        String res = isaac.prepareUrl(called.path, called.parameters);

        assertEquals(res,expected);
    }

    @Test
    public void testCustoms(){

        String expected = "/cache/users?customs=name,email,age";

        Isaacloud.Caller called = isaac.path("/cache/users").withCustoms("name", "email", "age");

        String res = isaac.prepareUrl(called.path,called.parameters);

        assertEquals(res,expected);
    }

    @Test
    public void testFields(){

        String expected = "/cache/users?fields=name,email,age";

        Isaacloud.Caller called = isaac.path("/cache/users").withFields("name", "email", "age");

        String res = isaac.prepareUrl(called.path,called.parameters);

        assertEquals(res,expected);
    }

    @Test
    public void testOrder(){

        String expected = "/cache/users?order=age:DESC,name:ASC";

        Map<String,String> ord = new HashMap<>();
        ord.put("name","ASC");
        ord.put("age","DESC");

        Isaacloud.Caller called = isaac.path("/cache/users").withOrder(ord);

        String res = isaac.prepareUrl(called.path,called.parameters);

        System.out.println(res);
        assertEquals(res,expected);
    }

    @Test
    public void testGroups(){

        String expected = "/cache/users?groups=1,2,3";

        Isaacloud.Caller called = isaac.path("/cache/users").withGroups(1l,2l,3l);

        String res = isaac.prepareUrl(called.path,called.parameters);

        assertEquals(res,expected);
    }

    @Test
    public void testSegments(){

        String expected = "/cache/users?segments=1,2,3";

        Isaacloud.Caller called = isaac.path("/cache/users").withSegments(1l,2l,3l);

        String res = isaac.prepareUrl(called.path,called.parameters);

        assertEquals(res,expected);
    }

    @Test
    public void testIds(){

        String expected = "/cache/users?ids=1,2,3";

        Isaacloud.Caller called = isaac.path("/cache/users").withIds(1l,2l,3l);

        String res = isaac.prepareUrl(called.path,called.parameters);

        assertEquals(res,expected);
    }

    @Test
    public void testPaginator(){

        Long limit = 10l;
        Long offset = 0l;

        String expected1 = "offset="+offset;
        String expected2 = "limit="+limit;
        Isaacloud.Caller called = isaac.path("/cache/users").withPaginator(limit,offset);

        String res = isaac.prepareUrl(called.path,called.parameters);

        assertTrue(res.contains(expected1));
        assertTrue(res.contains(expected2));
    }

    @Test
    public void testCreatedAt(){

        Long fromc = 98765l;
        Long toc = 12345l;

        String expected1 = "fromc="+fromc;
        String expected2 = "toc="+toc;
        Isaacloud.Caller called = isaac.path("/cache/users").withCreatedAt(fromc,toc);

        String res = isaac.prepareUrl(called.path,called.parameters);

        assertTrue(res.contains(expected1));
        assertTrue(res.contains(expected2));
    }

    @Test
    public void testUpdatedAt(){

        Long fromu = 98765l;
        Long tou = 12345l;

        String expected1 = "fromu="+fromu;
        String expected2 = "tou="+tou;
        Isaacloud.Caller called = isaac.path("/cache/users").withUpdatedAt(fromu,tou);

        String res = isaac.prepareUrl(called.path,called.parameters);

        assertTrue(res.contains(expected1));
        assertTrue(res.contains(expected2));
    }
}
