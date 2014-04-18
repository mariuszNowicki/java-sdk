package com.isaacloud.sdk;

import java.io.IOException;
import java.util.*;

import net.minidev.json.JSONObject;

public class Isaacloud extends Connector {

    public class Caller {

        public Caller(String _path) {
            this.path = _path;
        }

        protected String path;
        protected Map<String, Object> parameters = new HashMap<>();

        public Caller withFields(String... fields) {
            parameters.put("fields", Arrays.asList(fields));
            return this;
        }

        public Caller withCustoms(String... customs) {
            parameters.put("customs", Arrays.asList(customs));
            return this;
        }

        public Caller withGroups(Long... groups) {
            parameters.put("groups", Arrays.asList(groups));
            return this;
        }

        public Caller withSegments(Long... segments) {
            parameters.put("segments", Arrays.asList(segments));
            return this;
        }

        public Caller withPaginator(Long limit, Long offset) {
            parameters.put("limit", limit);
            parameters.put("offset", offset);
            return this;
        }

        public Caller withOrder(Map<String, String> order) {
            parameters.put("order", order);
            return this;
        }

        public Caller withQuery(Map<String, String> order) {
            parameters.put("query", order);
            return this;
        }

        public Caller withCreatedAt(Long from, Long to) {
            if (from != null)
                parameters.put("fromc", from);
            if (to != null)
                parameters.put("toc", to);
            return this;
        }

        public Caller withUpdatedAt(Long from, Long to) {
            if (from != null)
                parameters.put("fromu", from);
            if (to != null)
                parameters.put("tou", to);
            return this;
        }

        public Caller withCustom(){
            parameters.put("custom", true);
            return this;
        }

        public Caller withQueryParameters(Map<String, Object> params) {
            parameters.putAll(params);
            return this;
        }

        /**
         * Call to api get methods.
         *
         * @return api json response
         */
        public Response get() throws IOException, IsaacloudConnectionException {
            return callService(path, "get", parameters, null);
        }

        /**
         * Call to api put methods.
         *
         * @return api json response
         */
        public Response put(JSONObject body) throws IOException, IsaacloudConnectionException {
            return callService(path, "put", parameters, body);
        }

        /**
         * Call to api post methods.
         *
         * @return api json response
         */
        public Response post(JSONObject body) throws IOException, IsaacloudConnectionException {
            return callService(path, "post", parameters, body);
        }

        /**
         * Call to api delete methods.
         *
         * @return api json response
         */
        public Response delete() throws IOException, IsaacloudConnectionException {
            return callService(path, "delete", parameters, null);
        }

        /**
         * Call to api patch methods.
         *
         * @return api json response
         */
        public Response patch(JSONObject body) throws IOException, IsaacloudConnectionException {
            return callService(path, "patch", parameters, body);
        }
    }

    /**
     * Constructor for default com.isaacloud.
     *
     * @param config - map that contains clientID:clientSecret
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
    @Deprecated
    public Response api(String uri, String method,
                        Map<String, Object> parameters, JSONObject body)
            throws IOException, IsaacloudConnectionException {
        return this.callService(uri, method, parameters, body);
    }

    /**
     * @param uri resource we want to access
     * @return object representing the resource
     */
    public Caller path(String uri) {
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
