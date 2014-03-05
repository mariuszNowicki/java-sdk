package isaacloud;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.minidev.json.JSONObject;

public class Isaacloud extends Connector {

	/**
	 * Constructor for default isaacloud.
	 * 
	 * @param config
	 *            - map that contains clientID:clientSecret
	 */
	public Isaacloud(Map<String, String> config) {
		super("https://api.isaacloud.com", "https://oauth.isaacloud.com", "v1",
				config);
	}

	/**
	 * Call to api methods.
	 * 
	 * @param uri
	 * @param method
	 * @param parameters
	 * @param body
	 * @return api json response
	 * @throws IOException
	 * @throws IsaacloudConnectionException
	 */
	public Response api(String uri, String method,
			Map<String, Object> parameters, JSONObject body)
			throws IOException, IsaacloudConnectionException {
		return this.callService(uri, method, parameters, body);
	}

	/**
	 * Push new event into Queue.
	 * 
	 * @param subjectId
	 * @param subjectType
	 * @param priority
	 * @param sourceId
	 * @param type
	 * @param body
	 * @return
	 * @throws IOException
	 * @throws BadRequestException
	 * @throws IllegalStateException
	 */
	public Response event(long subjectId, String subjectType, String priority,
			long sourceId, String type, JSONObject body) throws IOException,
			IsaacloudConnectionException {

		// compose event
		JSONObject obj = new JSONObject();
		if (body != null)
			obj.put("body", body);
		if (priority != null)
			obj.put("priority", priority);

		obj.put("sourceId", sourceId);
		obj.put("subjectId", subjectId);

		if (subjectType != null)
			obj.put("subjectType", subjectType);

		if (type != null)
			obj.put("type", type);

		// Send event into queue
		return callService("/queues/events", "post",
				new HashMap<String, Object>(), obj);

	}

	/**
	 * Get base api url
	 * 
	 * @return url to api
	 */
	public String getApiUrl() {
		return this.baseUrl;
	}

	/**
	 * Get base oauth url
	 * 
	 * @return oauth url
	 */
	public String getOauthUrl() {
		return oauthUrl;
	}

	/**
	 * Get base version
	 * 
	 * @return api version
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * Get token
	 * 
	 * @return type
	 * @throws IOException
	 * @throws IsaacloudConnectionException 
	 */
	public String getToken() throws IOException, IsaacloudConnectionException {
		return getAuthentication();
	}

}
