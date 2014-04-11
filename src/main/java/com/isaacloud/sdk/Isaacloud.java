package com.isaacloud.sdk;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import net.minidev.json.JSONObject;

public class Isaacloud extends Connector {

   class Caller{

       public Caller(String _uri){
           this.uri = _uri;
       }

       private String uri;
       Map<String,Object> parameters = new HashMap<>();

        public Caller withFields(String ... fields)  {
            return this;
        }

       public Caller withGroups(Long ... groups){
            return this;
        }

       public Caller withSegments(Long ... segments) {
            return this;
        }

       public Caller withPaginator(Long limit,Long offset) {
            return this;
        }

       public Caller withOrder(Map<String,String> order){
            return this;
        }

//        def withCreatedAt(from: Option[Long], to: Option[Long]) = {
//            (from, to) match {
//                case (Some(v1), Some(v2)) =>
//                    parameters += ("fromc" -> v1)
//                    parameters += ("toc" -> v2)
//                case (Some(v1), None) => parameters += ("fromc" -> v1)
//                case (None, Some(v2)) => parameters += ("toc" -> v2)
//                case _ =>
//            }
//            this
//        }
//
//        def withUpdatedAt(from: Option[Long], to: Option[Long]) = {
//            (from, to) match {
//                case (Some(v1), Some(v2)) =>
//                    parameters += ("fromu" -> v1)
//                    parameters += ("tou" -> v2)
//                case (Some(v1), None) => parameters += ("fromu" -> v1)
//                case (None, Some(v2)) => parameters += ("tou" -> v2)
//                case _ =>
//            }
//            this
//
//        }

//        def withQueryParameters(params: Map[String, Any]) = {
//            parameters = params ++ parameters
//            this
//        }

        /**
         * Call to api get methods.
         *
         * @return api json response
         */
        public Response get() throws IOException, IsaacloudConnectionException {
            return callService(uri,"get", parameters, null);
        }

        /**
         * Call to api put methods.
         *
         * @return api json response
         */
        public Response put(JSONObject body) throws IOException, IsaacloudConnectionException {
           return callService(uri,"put", parameters, body);
        }

        /**
         * Call to api post methods.
         *
         * @return api json response
         */
        public Response post(JSONObject body) throws IOException, IsaacloudConnectionException {
            return callService(uri, "post", parameters, body);
        }

        /**
         * Call to api delete methods.
         *
         * @return api json response
         */
        public Response delete() throws IOException, IsaacloudConnectionException {
            return callService(uri, "delete", parameters, null);
        }

        /**
         * Call to api patch methods.
         *
         * @return api json response
         */
        public Response patch(JSONObject body) throws IOException, IsaacloudConnectionException {
            return callService(uri, "patch", parameters, body);
        }
    }
	/**
	 * Constructor for default isaacloud.
	 * 
	 * @param config
	 *            - map that contains clientID:clientSecret
	 */
	public Isaacloud(Map<String, String> config) {
		super("https://api.isaacloud.com", "https://oauth.isaacloud.com", "v1",
				config);
		try {
			setupSSL();
		} catch (KeyManagementException | NoSuchAlgorithmException
				| CertificateException
				| KeyStoreException | IOException e) {
			System.out.println("Cannot initialize SSL connection " + e.getMessage() + "\n");
		}
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
    @Deprecated
	public Response api(String uri, String method,
			Map<String, Object> parameters, JSONObject body)
			throws IOException, IsaacloudConnectionException {
		return this.callService(uri, method, parameters, body);
	}

    /**
     *
     * @param uri resource we want to access
     * @return object representing the resource
     */
    public Caller path(String uri){
        return new Caller(uri);
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
