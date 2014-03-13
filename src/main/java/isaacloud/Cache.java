package isaacloud;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 */
public class Cache extends Connector {

	public Cache(Map<String, String> config) {
		super("https://api.isaacloud.com", "https://oauth.isaacloud.com", "v1",
				config);
		try {
			setupSSL(null);
		} catch (KeyManagementException | NoSuchAlgorithmException
				| CertificateException | KeyStoreException | IOException e) {
			System.out.println("Cannot initialize SSL connection "
					+ e.getMessage() + "\n");
		}
	}

	/**
	 * Access to url : /cache/notifications/{notificationId}. Get one
	 * notification.
	 */
	public Response getNotification(String notificationId, String fields)
			throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("notificationId", notificationId);
		array.put("fields", fields);

		return this.callService("/cache/notifications/{notificationId}", "get",
				array, null);
	}

	/**
	 * Access to url : /cache/notifications. Get notification collection.
	 */
	public Response getNotifications(Long offset, Long limit, String fields,
			String order) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/cache/notifications", "get", array, null);
	}

	/**
	 * Access to url : /cache/leaderboards/{leaderboardId}/groups/{groupId}. Get
	 * user's with a group Id in one of the leaderboards. Returns by default
	 * only the fields of the leaderboard. Use fields query parameter to add
	 * fields for users.
	 */
	public Response getLeaderboardGroup(String groups, Long groupId,
			Long offset, String order, String fields, String segments,
			Long leaderboardId, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groups", groups);
		array.put("groupId", groupId);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("leaderboardId", leaderboardId);
		array.put("limit", limit);

		return this.callService(
				"/cache/leaderboards/{leaderboardId}/groups/{groupId}", "get",
				array, null);
	}

	/**
	 * Access to url :
	 * /cache/leaderboards/{leaderboardId}/users/{userId}/friends. Get user's
	 * friends with one of the leaderboards. Returns by default only the fields
	 * of the leaderboard. Use fields query parameter to add fields for users.
	 */
	public Response getLeaderboardUserFriends(String groups, Long offset,
			String order, String fields, String segments, Long leaderboardId,
			Long userId, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groups", groups);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("leaderboardId", leaderboardId);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService(
				"/cache/leaderboards/{leaderboardId}/users/{userId}/friends",
				"get", array, null);
	}

	/**
	 * Access to url : /cache/leaderboards/{leaderboardId}/segments/{segmentId}.
	 * Get user's with a segment Id in one of the leaderboards. Returns by
	 * default only the fields of the leaderboard. Use fields query parameter to
	 * add fields for users.
	 */
	public Response getLeaderboardSegment(Long segmentId, String groups,
			Long offset, String order, String fields, String segments,
			Long leaderboardId, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("segmentId", segmentId);
		array.put("groups", groups);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("leaderboardId", leaderboardId);
		array.put("limit", limit);

		return this.callService(
				"/cache/leaderboards/{leaderboardId}/segments/{segmentId}",
				"get", array, null);
	}

	/**
	 * Access to url : /cache/leaderboards/{leaderboardId}. Get users with one
	 * of the leaderboards. Returns by default only the fields of the
	 * leaderboard. Use fields query parameter to add fields for users.
	 */
	public Response getLeaderboard(String groups, Long offset, String order,
			String fields, String segments, Long leaderboardId, Long limit)
			throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groups", groups);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("leaderboardId", leaderboardId);
		array.put("limit", limit);

		return this.callService("/cache/leaderboards/{leaderboardId}", "get",
				array, null);
	}

	/**
	 * Access to url : /cache/leaderboards. Get list of possible leaderboards.
	 */
	public Response getLeaderboards(String groups, Long offset, String order,
			String fields, String segments, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groups", groups);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("limit", limit);

		return this.callService("/cache/leaderboards", "get", array, null);
	}

	/**
	 * Access to url : /cache/games/{gameId}. Get one game.
	 */
	public Response getGame(Long gameId, String fields) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("gameId", gameId);
		array.put("fields", fields);

		return this.callService("/cache/games/{gameId}", "get", array, null);
	}

	/**
	 * Access to url : /cache/games. Get a list of games.
	 */
	public Response getGames(Long offset, String order, String fields,
			String segments, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("limit", limit);

		return this.callService("/cache/games", "get", array, null);
	}

	/**
	 * Access to url : /cache/achievements/categories/{categoryId}. Get one
	 * category.
	 */
	public Response getAchievementsCategory(Long categoryId) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("categoryId", categoryId);

		return this.callService("/cache/achievements/categories/{categoryId}",
				"get", array, null);
	}

	/**
	 * Access to url : /cache/achievements/categories. Get list of achievement
	 * categories.
	 */
	public Response getAchievementsCategories(String fields, String order,
			Long offset, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("fields", fields);
		array.put("order", order);
		array.put("offset", offset);
		array.put("limit", limit);

		return this.callService("/cache/achievements/categories", "get", array,
				null);
	}

	/**
	 * Access to url : /cache/achievements/{achievementId}/segments. Get one
	 * achievement's segments.
	 */
	public Response getAchievementSegments(Long offset, String order,
			String fields, Long achievementId, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("achievementId", achievementId);
		array.put("limit", limit);

		return this.callService("/cache/achievements/{achievementId}/segments",
				"get", array, null);
	}

	/**
	 * Access to url : /cache/achievements/{achievementId}. Get one achievement.
	 */
	public Response getAchievement(Long achievementId, String fields)
			throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("achievementId", achievementId);
		array.put("fields", fields);

		return this.callService("/cache/achievements/{achievementId}", "get",
				array, null);
	}

	/**
	 * Access to url : /cache/achievements. Get achievements collection.
	 */
	public Response getAchievements(Long offset, String order, String fields,
			String segments, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("limit", limit);

		return this.callService("/cache/achievements", "get", array, null);
	}

	/**
	 * Access to url : /cache/statistics. Get all the current statistics.
	 */
	public Response getStatistics(Long offset, Long limit, String fields,
			String order) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/cache/statistics", "get", array, null);
	}

	/**
	 * Access to url : /cache/users/groups/{groupId}/games. Get user group's won
	 * games list.
	 */
	public Response getUserGroupGames(Long groupId, Long offset, String order,
			String fields, String segments, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groupId", groupId);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("limit", limit);

		return this.callService("/cache/users/groups/{groupId}/games", "get",
				array, null);
	}

	/**
	 * Access to url : /cache/users/groups/{groupId}/achievements. Get user
	 * group's gained achievements list.
	 */
	public Response getUserGroupAchievements(Long groupId, Long offset,
			String order, String fields, String segments, Long limit)
			throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groupId", groupId);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("limit", limit);

		return this.callService("/cache/users/groups/{groupId}/achievements",
				"get", array, null);
	}

	/**
	 * Access to url : /cache/users/groups/{groupId}/users. Get members of the
	 * user group.
	 */
	public Response getUserGroupMembers(String groups, Long groupId,
			Long offset, String order, String fields, String segments,
			Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groups", groups);
		array.put("groupId", groupId);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("limit", limit);

		return this.callService("/cache/users/groups/{groupId}/users", "get",
				array, null);
	}

	/**
	 * Access to url :
	 * /cache/users/groups/{groupId}/externalids/{externalIdName}/{externalId}.
	 * Get one user group by external id. Usage - name/id
	 */
	public Response getUserGroupByExternalId(Long groupId,
			String externalIdName, String externalId, String fields)
			throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groupId", groupId);
		array.put("externalIdName", externalIdName);
		array.put("externalId", externalId);
		array.put("fields", fields);

		return this
				.callService(
						"/cache/users/groups/{groupId}/externalids/{externalIdName}/{externalId}",
						"get", array, null);
	}

	/**
	 * Access to url : /cache/users/groups/{groupId}/segments. Get the segments
	 * a particular user group belongs to.
	 */
	public Response getUserGroupSegments(Long groupId, Long offset,
			String order, String fields, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groupId", groupId);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("limit", limit);

		return this.callService("/cache/users/groups/{groupId}/segments",
				"get", array, null);
	}

	/**
	 * Access to url : /cache/users/groups/{groupId}. Get one group.
	 */
	public Response getGroup(Long groupId, String fields) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groupId", groupId);
		array.put("fields", fields);

		return this.callService("/cache/users/groups/{groupId}", "get", array,
				null);
	}

	/**
	 * Access to url : /cache/users/groups. Get groups collection.
	 */
	public Response getGroups(Long offset, Long limit, String fields,
			String order) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/cache/users/groups", "get", array, null);
	}

	/**
	 * Access to url : /cache/users/externalids/{externalIdName}/{externalId}.
	 * Get one user by external id. Usage - name/id
	 */
	public Response getUserByExternalId(String externalIdName,
			String externalId, String fields) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("externalIdName", externalIdName);
		array.put("externalId", externalId);
		array.put("fields", fields);

		return this.callService(
				"/cache/users/externalids/{externalIdName}/{externalId}",
				"get", array, null);
	}

	/**
	 * Access to url : /cache/users/{userId}/achievements. Get user's gained
	 * achievements list.
	 */
	public Response getUserAchievements(Long offset, String order,
			String fields, String segments, Long userId, Long limit)
			throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService("/cache/users/{userId}/achievements", "get",
				array, null);
	}

	/**
	 * Access to url : /cache/users/{userId}/games. Get user's won games list.
	 */
	public Response getUserGames(Long offset, String order, String fields,
			String segments, Long userId, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService("/cache/users/{userId}/games", "get", array,
				null);
	}

	/**
	 * Access to url : /cache/users/{userId}/groups. Get the groups a particular
	 * user belongs to.
	 */
	public Response getUserGroups(Long offset, String order, String fields,
			Long userId, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService("/cache/users/{userId}/groups", "get", array,
				null);
	}

	/**
	 * Access to url : /cache/users/{userId}/segments. Get the segments a
	 * particular user belongs to.
	 */
	public Response getUserSegments(Long offset, String order, String fields,
			Long userId, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService("/cache/users/{userId}/segments", "get", array,
				null);
	}

	/**
	 * Access to url : /cache/users/{userId}/friends. Get user's friends.
	 */
	public Response getUserFriends(String groups, Long offset, String order,
			String fields, String segments, Long userId, Long limit)
			throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groups", groups);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService("/cache/users/{userId}/friends", "get", array,
				null);
	}

	/**
	 * Access to url : /cache/users/{userId}/history. Get one user's history.
	 */
	public Response getUserHistory(Long offset, String order, String fields,
			Long userId, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService("/cache/users/{userId}/history", "get", array,
				null);
	}

	/**
	 * Access to url : /cache/users/{userId}. Get one user by id.
	 */
	public Response getUser(Long userId, String fields) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("userId", userId);
		array.put("fields", fields);

		return this.callService("/cache/users/{userId}", "get", array, null);
	}

	/**
	 * Access to url : /cache/users. Get users collection.
	 */
	public Response getUsers(String groups, Long offset, String order,
			String fields, String segments, Long limit) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("groups", groups);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("limit", limit);

		return this.callService("/cache/users", "get", array, null);
	}

	/**
	 * Access to url : /cache/segments/{segmentId}. Get segment by id.
	 */
	public Response getSegment(Long segmentId, String fields) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("segmentId", segmentId);
		array.put("fields", fields);

		return this.callService("/cache/segments/{segmentId}", "get", array,
				null);
	}

	/**
	 * Access to url : /cache/segments. Get segments list.
	 */
	public Response getSegments(Long offset, Long limit, String fields,
			String order) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/cache/segments", "get", array, null);
	}

	/**
	 * Access to url : /cache/events/{eventId}. Get one done event.
	 */
	public Response getEvent(String eventId, String fields) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("eventId", eventId);
		array.put("fields", fields);

		return this.callService("/cache/events/{eventId}", "get", array, null);
	}

	/**
	 * Access to url : /cache/events. Get done events collection.
	 */
	public Response getEvents(Long offset, Long limit, String fields,
			String order) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/cache/events", "get", array, null);
	}

	/**
	 * Access to url : /cache/counters/{counterId}. Get one counter.
	 */
	public Response getCounter(Long counterId, String fields) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("counterId", counterId);
		array.put("fields", fields);

		return this.callService("/cache/counters/{counterId}", "get", array,
				null);
	}

	/**
	 * Access to url : /cache/counters. Get a list of counters.
	 */
	public Response getCounters(Long offset, Long limit, String fields,
			String order) throws Exception {
		Map<String, Object> array = new HashMap<String, Object>();
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/cache/counters", "get", array, null);
	}

}