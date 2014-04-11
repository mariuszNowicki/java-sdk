package com.isaacloud.sdk;

import java.util.Map;
import java.util.HashMap;
import net.minidev.json.JSONObject;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

/**
 */
public class Queue extends Connector {

	public Queue(Map<String, String> config) {
		super("https://api.isaacloud.com", "https://oauth.isaacloud.com", "v1",
				config);
		try {
			setupSSL();
		} catch (KeyManagementException | NoSuchAlgorithmException
				| CertificateException | KeyStoreException | IOException e) {
			System.out.println("Cannot initialize SSL connection "
					+ e.getMessage() + "\n");
		}
	}

	/**
	 * Access to url : /queues/notifications/error/{notificationId}. Update
	 * status for an error notification.
	 */
	public Response patchErrorNotification(String notificationId,
			JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("notificationId", notificationId);

		return this.callService("/queues/notifications/error/{notificationId}",
				"patch", array, body);

	}

	/**
	 * Access to url : /queues/notifications/error/{notificationId}. Get error
	 * notification for a client.
	 */
	public Response getErrorNotification(String notificationId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("notificationId", notificationId);

		return this.callService("/queues/notifications/error/{notificationId}",
				"get", array, null);

	}

	/**
	 * Access to url : /queues/notifications/error. Get error notifications for
	 * a client.
	 */
	public Response getErrorNotifications(Long offset, Long limit,
			List<String> fields, Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/queues/notifications/error", "get", array,
				null);

	}

	/**
	 * Access to url : /queues/notifications/{notificationId}. Patch one
	 * notification by id.
	 */
	public Response patchNotification(String notificationId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("notificationId", notificationId);

		return this.callService("/queues/notifications/{notificationId}",
				"patch", array, body);

	}

	/**
	 * Access to url : /queues/notifications/{notificationId}. Get notification
	 * for a client and set its status to IN_PROGRESS.
	 */
	public Response getNotification(String notificationId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("notificationId", notificationId);

		return this.callService("/queues/notifications/{notificationId}",
				"get", array, null);

	}

	/**
	 * Access to url : /queues/notifications. Get notifications for a client.
	 */
	public Response getNotifications(Long offset, Long limit,
			List<String> fields, Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/queues/notifications", "get", array, null);

	}

	/**
	 * Access to url : /queues/events/{eventId}. Get one event by Id for a
	 * client.
	 */
	public Response getEvent(String eventId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("eventId", eventId);

		return this.callService("/queues/events/{eventId}", "get", array, null);

	}

	/**
	 * Access to url : /queues/events/error/{eventId}. Get one error event by id
	 * for a client.
	 */
	public Response getErrorEvent(String eventId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("eventId", eventId);

		return this.callService("/queues/events/error/{eventId}", "get", array,
				null);

	}

	/**
	 * Access to url : /queues/events/error. Get error events for a client.
	 */
	public Response getErrorEvents(Long offset, Long limit,
			List<String> fields, Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/queues/events/error", "get", array, null);

	}

	/**
	 * Access to url : /queues/events. Create a new event.
	 */
	public Response postEvents(JSONObject body) throws Exception {

		return this.callService("/queues/events", "post", null, body);

	}

	/**
	 * Access to url : /queues/events. Get a list of events for a client.
	 */
	public Response getEvents(Long offset, Long limit, List<String> fields,
			Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/queues/events", "get", array, null);

	}

}