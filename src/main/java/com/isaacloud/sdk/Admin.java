package com.isaacloud.sdk;

import java.util.Map;
import java.util.HashMap;
import net.minidev.json.JSONObject;
import java.util.List;

/**
 */
public class Admin extends Connector {

	public Admin(Map<String, String> config) {
		super("https://api.com.isaacloud.com", "https://oauth.com.isaacloud.com", "v1",
				config);
	}

	/**
	 * Access to url : /admin/functions/doc. Get a pseudo schema showing quickly
	 * how to make a proper json for functions.
	 */
	public Response getFunctionsDoc() throws Exception {

		return this.callService("/admin/functions/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/functions/{functionId}. Delete a function.
	 */
	public Response deleteFunction(Long functionId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("functionId", functionId);

		return this.callService("/admin/functions/{functionId}", "delete",
				array, null);

	}

	/**
	 * Access to url : /admin/functions/{functionId}. Update a function.
	 */
	public Response putFunction(Long functionId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("functionId", functionId);

		return this.callService("/admin/functions/{functionId}", "put", array,
				body);

	}

	/**
	 * Access to url : /admin/functions/{functionId}. Get one function by its
	 * id.
	 */
	public Response getFunction(Long functionId, List<String> fields)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("functionId", functionId);
		array.put("fields", fields);

		return this.callService("/admin/functions/{functionId}", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/functions. Add a new function using this request
	 */
	public Response postFunctions(JSONObject body) throws Exception {

		return this.callService("/admin/functions", "post", null, body);

	}

	/**
	 * Access to url : /admin/functions. Get a list of functions.
	 */
	public Response getFunctions(List<String> fields, Long offset, Long limit,
			Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("order", order);

		return this.callService("/admin/functions", "get", array, null);

	}

	/**
	 * Access to url : /admin/notifications/doc. Get a schema showing how to
	 * make a proper json for notifications.
	 */
	public Response getNotificationsDocs() throws Exception {

		return this.callService("/admin/notifications/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/notifications/types/doc. Get a pseudo schema
	 * showing quickly how to make a proper json for notification types.
	 */
	public Response getNotificationTypesDocs() throws Exception {

		return this.callService("/admin/notifications/types/doc", "get", null,
				null);

	}

	/**
	 * Access to url : /admin/notifications/types/{typeId}. Delete a
	 * notification type.
	 */
	public Response deleteNotificationType(Long typeId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("typeId", typeId);

		return this.callService("/admin/notifications/types/{typeId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/notifications/types/{typeId}. Update a
	 * notification type
	 */
	public Response putNotificationType(Long typeId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("typeId", typeId);

		return this.callService("/admin/notifications/types/{typeId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/notifications/types/{typeId}. Get a notification
	 * type.
	 */
	public Response getNotificationType(Long typeId, List<String> fields)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("typeId", typeId);
		array.put("fields", fields);

		return this.callService("/admin/notifications/types/{typeId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/notifications/types. Add a notification type.
	 */
	public Response postNotificationTypes(JSONObject body) throws Exception {

		return this.callService("/admin/notifications/types", "post", null,
				body);

	}

	/**
	 * Access to url : /admin/notifications/types. Get a list of notification
	 * types.
	 */
	public Response getNotificationTypes(List<String> fields, Long offset,
			Long limit, Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("order", order);

		return this.callService("/admin/notifications/types", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/notifications/{notificationId}. Delete a
	 * notification.
	 */
	public Response deleteNotification(String notificationId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("notificationId", notificationId);

		return this.callService("/admin/notifications/{notificationId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/notifications/{notificationId}. Update a
	 * notification.
	 */
	public Response putNotification(String notificationId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("notificationId", notificationId);

		return this.callService("/admin/notifications/{notificationId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/notifications/{notificationId}. Get one
	 * notification by its id.
	 */
	public Response getNotification(String notificationId, List<String> fields)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("notificationId", notificationId);
		array.put("fields", fields);

		return this.callService("/admin/notifications/{notificationId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/notifications. Add a notification.
	 */
	public Response postNotifications(JSONObject body) throws Exception {

		return this.callService("/admin/notifications", "post", null, body);

	}

	/**
	 * Access to url : /admin/notifications. Get a list of notifications.
	 */
	public Response getNotifications(List<String> fields, Long offset,
			Long limit, Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("order", order);

		return this.callService("/admin/notifications", "get", array, null);

	}

	/**
	 * Access to url : /admin/achievements/doc. Get a schema for an achievement.
	 */
	public Response getAchievementsDoc() throws Exception {

		return this.callService("/admin/achievements/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/achievements/groups/doc. Get a schema for group.
	 * It shows how to create a new group.
	 */
	public Response getAchievementsGroupsDoc() throws Exception {

		return this.callService("/admin/achievements/groups/doc", "get", null,
				null);

	}

	/**
	 * Access to url : /admin/achievements/groups/{achievementGroupId}. Delete
	 * an achievement group.
	 */
	public Response deleteAchievementsGroup(Long achievementGroupId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementGroupId", achievementGroupId);

		return this.callService(
				"/admin/achievements/groups/{achievementGroupId}", "delete",
				array, null);

	}

	/**
	 * Access to url : /admin/achievements/groups/{achievementGroupId}. Update
	 * an achievement group.
	 */
	public Response putAchievementsGroup(Long achievementGroupId,
			JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementGroupId", achievementGroupId);

		return this.callService(
				"/admin/achievements/groups/{achievementGroupId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/achievements/groups/{achievementGroupId}. Get one
	 * achievement group.
	 */
	public Response getAchievementsGroup(Long achievementGroupId,
			List<String> fields) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementGroupId", achievementGroupId);
		array.put("fields", fields);

		return this.callService(
				"/admin/achievements/groups/{achievementGroupId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/achievements/groups. Create a new achievement
	 * group. This method needs a body and returns the created object.
	 */
	public Response postAchievementsGroups(JSONObject body) throws Exception {

		return this.callService("/admin/achievements/groups", "post", null,
				body);

	}

	/**
	 * Access to url : /admin/achievements/groups. Get a list achievement
	 * groups.
	 */
	public Response getAchievementsGroups(List<String> fields,
			Map<String, String> order, Long offset, Long limit)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("order", order);
		array.put("offset", offset);
		array.put("limit", limit);

		return this.callService("/admin/achievements/groups", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/achievements/progress/doc. Get a schema for
	 * achievement progress.
	 */
	public Response getAchievementsProgressesDoc() throws Exception {

		return this.callService("/admin/achievements/progress/doc", "get",
				null, null);

	}

	/**
	 * Access to url : /admin/achievements/progress/{achievementProgressId}.
	 * Delete an achievement progress.
	 */
	public Response deleteAchievementsProgress(Long achievementProgressId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementProgressId", achievementProgressId);

		return this.callService(
				"/admin/achievements/progress/{achievementProgressId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/achievements/progress/{achievementProgressId}.
	 * Update an achievement progress.
	 */
	public Response putAchievementsProgress(Long achievementProgressId,
			JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementProgressId", achievementProgressId);

		return this.callService(
				"/admin/achievements/progress/{achievementProgressId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/achievements/progress/{achievementProgressId}. Get
	 * one achievement progress.
	 */
	public Response getAchievementsProgress(Long achievementProgressId,
			List<String> fields) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementProgressId", achievementProgressId);
		array.put("fields", fields);

		return this.callService(
				"/admin/achievements/progress/{achievementProgressId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/achievements/progress. Create a new achievement
	 * progress.
	 */
	public Response postAchievementsProgresses(JSONObject body)
			throws Exception {

		return this.callService("/admin/achievements/progress", "post", null,
				body);

	}

	/**
	 * Access to url : /admin/achievements/progress. Get achievement progress
	 * list.
	 */
	public Response getAchievementsProgresses(List<String> fields,
			Map<String, String> order, Long offset, Long limit)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("order", order);
		array.put("offset", offset);
		array.put("limit", limit);

		return this.callService("/admin/achievements/progress", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/achievements/categories/doc. Get a pseudo schema
	 * for category.
	 */
	public Response getAchievementsCategoriesDoc() throws Exception {

		return this.callService("/admin/achievements/categories/doc", "get",
				null, null);

	}

	/**
	 * Access to url : /admin/achievements/categories/{categoryId}. Delete one
	 * achievements category.
	 */
	public Response deleteAchievementsCategory(Long categoryId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("categoryId", categoryId);

		return this.callService("/admin/achievements/categories/{categoryId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/achievements/categories/{categoryId}. Update
	 * achievement category.
	 */
	public Response putAchievementsCategory(Long categoryId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("categoryId", categoryId);

		return this.callService("/admin/achievements/categories/{categoryId}",
				"put", array, body);

	}

	/**
	 * Access to url : /admin/achievements/categories/{categoryId}. Get one
	 * category.
	 */
	public Response getAchievementsCategory(Long categoryId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("categoryId", categoryId);

		return this.callService("/admin/achievements/categories/{categoryId}",
				"get", array, null);

	}

	/**
	 * Access to url : /admin/achievements/categories. Create new category.
	 */
	public Response postAchievementsCategories(JSONObject body)
			throws Exception {

		return this.callService("/admin/achievements/categories", "post", null,
				body);

	}

	/**
	 * Access to url : /admin/achievements/categories. Get list of categories.
	 */
	public Response getAchievementsCategories(List<String> fields,
			Map<String, String> order, Long offset, Long limit)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("order", order);
		array.put("offset", offset);
		array.put("limit", limit);

		return this.callService("/admin/achievements/categories", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/achievements/{achievementId}/segments/{segmentId}.
	 * Delete segment from achievement.
	 */
	public Response deleteAchievementSegment(Long achievementId, Long segmentId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementId", achievementId);
		array.put("segmentId", segmentId);

		return this.callService(
				"/admin/achievements/{achievementId}/segments/{segmentId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/achievements/{achievementId}/segments/{segmentId}.
	 * Add segment to achievement.
	 */
	public Response putAchievementSegment(Long achievementId, Long segmentId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementId", achievementId);
		array.put("segmentId", segmentId);

		return this.callService(
				"/admin/achievements/{achievementId}/segments/{segmentId}",
				"put", array, null);

	}

	/**
	 * Access to url : /admin/achievements/{achievementId}. Delete one
	 * achievement.
	 */
	public Response deleteAchievement(Long achievementId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementId", achievementId);

		return this.callService("/admin/achievements/{achievementId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/achievements/{achievementId}. Update one
	 * achievement.
	 */
	public Response putAchievement(Long achievementId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementId", achievementId);

		return this.callService("/admin/achievements/{achievementId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/achievements/{achievementId}. Get one achievement.
	 */
	public Response getAchievement(Long achievementId, List<String> fields)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("achievementId", achievementId);
		array.put("fields", fields);

		return this.callService("/admin/achievements/{achievementId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/achievements. Use this method to create a new
	 * achievement. It needs a body and a returns the created object.
	 */
	public Response postAchievements(JSONObject body) throws Exception {

		return this.callService("/admin/achievements", "post", null, body);

	}

	/**
	 * Access to url : /admin/achievements. Get a list of achievements.
	 */
	public Response getAchievements(List<Long> groups, Long offset,
			Map<String, String> order, List<String> fields,
			List<Long> segments, Long limit) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("groups", groups);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("limit", limit);

		return this.callService("/admin/achievements", "get", array, null);

	}

	/**
	 * Access to url : /admin/games/doc. Get a schema showing quickly how to
	 * make a proper json for games.
	 */
	public Response getGamesDoc() throws Exception {

		return this.callService("/admin/games/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/games/{gameId}/notifications/{notificationId}.
	 * Remove a notification from a game.
	 */
	public Response deleteGameNotification(Long gameId, String notificationId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("gameId", gameId);
		array.put("notificationId", notificationId);

		return this.callService(
				"/admin/games/{gameId}/notifications/{notificationId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/games/{gameId}/notifications/{notificationId}. Add
	 * a notification to a game.
	 */
	public Response putGameNotification(Long gameId, String notificationId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("gameId", gameId);
		array.put("notificationId", notificationId);

		return this.callService(
				"/admin/games/{gameId}/notifications/{notificationId}", "put",
				array, null);

	}

	/**
	 * Access to url : /admin/games/{gameId}/conditions/{conditionId}. Remove a
	 * condition from a game.
	 */
	public Response deleteGameCondition(Long gameId, Long conditionId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("gameId", gameId);
		array.put("conditionId", conditionId);

		return this.callService(
				"/admin/games/{gameId}/conditions/{conditionId}", "delete",
				array, null);

	}

	/**
	 * Access to url : /admin/games/{gameId}/conditions/{conditionId}. Add a
	 * condition to a game.
	 */
	public Response putGameCondition(Long gameId, Long conditionId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("gameId", gameId);
		array.put("conditionId", conditionId);

		return this.callService(
				"/admin/games/{gameId}/conditions/{conditionId}", "put", array,
				null);

	}

	/**
	 * Access to url : /admin/games/{gameId}. Delete a game.
	 */
	public Response deleteGame(Long gameId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("gameId", gameId);

		return this.callService("/admin/games/{gameId}", "delete", array, null);

	}

	/**
	 * Access to url : /admin/games/{gameId}. Update a game.
	 */
	public Response putGame(Long gameId, JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("gameId", gameId);

		return this.callService("/admin/games/{gameId}", "put", array, body);

	}

	/**
	 * Access to url : /admin/games/{gameId}. Get one game by its id.
	 */
	public Response getGame(Long gameId, List<String> fields) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("gameId", gameId);
		array.put("fields", fields);

		return this.callService("/admin/games/{gameId}", "get", array, null);

	}

	/**
	 * Access to url : /admin/games. Create a game.
	 */
	public Response postGames(JSONObject body) throws Exception {

		return this.callService("/admin/games", "post", null, body);

	}

	/**
	 * Access to url : /admin/games. Get a list of games.
	 */
	public Response getGames(List<String> fields, Long offset, Long limit,
			Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("order", order);

		return this.callService("/admin/games", "get", array, null);

	}

	/**
	 * Access to url : /admin/leaderboards/{leaderboardId}/recalculate.
	 * Recalculate a leaderboard
	 */
	public Response getLeaderboardRecalculated(Long leaderboardId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("leaderboardId", leaderboardId);

		return this.callService(
				"/admin/leaderboards/{leaderboardId}/recalculate", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/leaderboards/{leaderboardId}. Remove a
	 * leaderboard.
	 */
	public Response deleteLeaderboard(Long leaderboardId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("leaderboardId", leaderboardId);

		return this.callService("/admin/leaderboards/{leaderboardId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/leaderboards/{leaderboardId}. Update a
	 * leaderboard.
	 */
	public Response putLeaderboard(Long leaderboardId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("leaderboardId", leaderboardId);

		return this.callService("/admin/leaderboards/{leaderboardId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/leaderboards/{leaderboardId}. Get a leaderboard.
	 */
	public Response getLeaderboard(Long leaderboardId, List<String> fields)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("leaderboardId", leaderboardId);
		array.put("fields", fields);

		return this.callService("/admin/leaderboards/{leaderboardId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/leaderboards/doc. Get a schema showing how to make
	 * a proper json for leaderboards.
	 */
	public Response getLeaderboardsDocs() throws Exception {

		return this.callService("/admin/leaderboards/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/leaderboards. Add a new leaderboard.
	 */
	public Response postLeaderboards(JSONObject body) throws Exception {

		return this.callService("/admin/leaderboards", "post", null, body);

	}

	/**
	 * Access to url : /admin/leaderboards. Get a leaderboard list.
	 */
	public Response getLeaderboards(List<String> fields, Long offset,
			Long limit, Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("order", order);

		return this.callService("/admin/leaderboards", "get", array, null);

	}

	/**
	 * Access to url : /admin/statistics/doc. Get a schema showing how to make a
	 * proper json for a statistic. Still being tested.
	 */
	public Response getStatisticsDocs() throws Exception {

		return this.callService("/admin/statistics/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/statistics. Update the statistic. Still being
	 * tested.
	 */
	public Response putStatistics(JSONObject body) throws Exception {

		return this.callService("/admin/statistics", "put", null, body);

	}

	/**
	 * Access to url : /admin/statistics. Get all current statistics. Still
	 * being tested.
	 */
	public Response getStatistics(List<String> fields, Long offset, Long limit,
			Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("order", order);

		return this.callService("/admin/statistics", "get", array, null);

	}

	/**
	 * Access to url : /admin/transactionsources/doc. Get a schema showing how
	 * to make a proper json for transaction source.
	 */
	public Response getTransactionSourcesDocs() throws Exception {

		return this.callService("/admin/transactionsources/doc", "get", null,
				null);

	}

	/**
	 * Access to url :
	 * /admin/transactionsources/{transactionSourceId}/function/{functionId}.
	 * Delete a transaction source function.
	 */
	public Response deleteTransactionSourceFunction(Long transactionSourceId,
			Long functionId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("transactionSourceId", transactionSourceId);
		array.put("functionId", functionId);

		return this
				.callService(
						"/admin/transactionsources/{transactionSourceId}/function/{functionId}",
						"delete", array, null);

	}

	/**
	 * Access to url :
	 * /admin/transactionsources/{transactionSourceId}/function/{functionId}.
	 * Add a transaction source function.
	 */
	public Response putTransactionSourceFunction(Long transactionSourceId,
			Long functionId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("transactionSourceId", transactionSourceId);
		array.put("functionId", functionId);

		return this
				.callService(
						"/admin/transactionsources/{transactionSourceId}/function/{functionId}",
						"put", array, null);

	}

	/**
	 * Access to url : /admin/transactionsources/{transactionSourceId}. Delete a
	 * transaction source.
	 */
	public Response deleteTransactionSource(Long transactionSourceId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("transactionSourceId", transactionSourceId);

		return this.callService(
				"/admin/transactionsources/{transactionSourceId}", "delete",
				array, null);

	}

	/**
	 * Access to url : /admin/transactionsources/{transactionSourceId}. Update a
	 * transaction source.
	 */
	public Response putTransactionSource(Long transactionSourceId,
			JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("transactionSourceId", transactionSourceId);

		return this.callService(
				"/admin/transactionsources/{transactionSourceId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/transactionsources/{transactionSourceId}. Get a
	 * transaction source by its id.
	 */
	public Response getTransactionSource(Long transactionSourceId,
			List<String> fields) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("transactionSourceId", transactionSourceId);
		array.put("fields", fields);

		return this.callService(
				"/admin/transactionsources/{transactionSourceId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/transactionsources. Add a transaction source.
	 */
	public Response postTransactionSources(JSONObject body) throws Exception {

		return this
				.callService("/admin/transactionsources", "post", null, body);

	}

	/**
	 * Access to url : /admin/transactionsources. Get a list of transaction
	 * sources.
	 */
	public Response getTransactionSources(List<String> fields, Long offset,
			Long limit, Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("order", order);

		return this
				.callService("/admin/transactionsources", "get", array, null);

	}

	/**
	 * Access to url : /admin/users/doc. Get a schema showing how to make a
	 * proper json for users.
	 */
	public Response getUsersDoc() throws Exception {

		return this.callService("/admin/users/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/users/groups/doc. Get a schema showing how to make
	 * a proper json for user group.
	 */
	public Response getUserGroupsDoc() throws Exception {

		return this.callService("/admin/users/groups/doc", "get", null, null);

	}

	/**
	 * Access to url :
	 * /admin/users/groups/externalids/{externalIdName}/{externalId}. Get one
	 * user group by external id. Usage - name/id
	 */
	public Response getUserGroupByExternalId(String externalIdName,
			String externalId, List<String> fields) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("externalIdName", externalIdName);
		array.put("externalId", externalId);
		array.put("fields", fields);

		return this
				.callService(
						"/admin/users/groups/externalids/{externalIdName}/{externalId}",
						"get", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/customfields/{key}.
	 * Delete a custom field by key.
	 */
	public Response deleteUserGroupCustomField(Long userGroupId, Long key)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("key", key);

		return this.callService(
				"/admin/users/groups/{userGroupId}/customfields/{key}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/customfields/{key}. Get
	 * a custom field by key.
	 */
	public Response getUserGroupCustomField(Long userGroupId, Long key)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("key", key);

		return this.callService(
				"/admin/users/groups/{userGroupId}/customfields/{key}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/customfields. Create a
	 * new custom field for user group.
	 */
	public Response postUserGroupCustomFields(Long userGroupId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/customfields", "post",
				array, body);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/customfields. Update an
	 * existing custom field for user group.
	 */
	public Response putUserGroupCustomFields(Long userGroupId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/customfields", "put", array,
				body);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/customfields. Get all
	 * existing custom fields for user group.
	 */
	public Response getUserGroupCustomFields(Long userGroupId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/customfields", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/gainedachievements/doc.
	 * Get a schema showing how to make a proper json for user group gained
	 * achivements.
	 */
	public Response getUserGroupGainedAchievementDocs(Long userGroupId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/gainedachievements/doc",
				"get", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/gainedachievements/{
	 * gainedAchievementId}. Delete a gained achievement for a group by id.
	 */
	public Response deleteUserGroupGainedAchievement(Long userGroupId,
			Long gainedAchievementId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("gainedAchievementId", gainedAchievementId);

		return this
				.callService(
						"/admin/users/groups/{userGroupId}/gainedachievements/{gainedAchievementId}",
						"delete", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/gainedachievements/{
	 * gainedAchievementId}. Update a gained achievement for a group by id.
	 */
	public Response putUserGroupGainedAchievement(Long userGroupId,
			Long gainedAchievementId, JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("gainedAchievementId", gainedAchievementId);

		return this
				.callService(
						"/admin/users/groups/{userGroupId}/gainedachievements/{gainedAchievementId}",
						"put", array, body);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/gainedachievements/{
	 * gainedAchievementId}. Get a gained achievement for a group by id.
	 */
	public Response getUserGroupGainedAchievement(Long userGroupId,
			Long gainedAchievementId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("gainedAchievementId", gainedAchievementId);

		return this
				.callService(
						"/admin/users/groups/{userGroupId}/gainedachievements/{gainedAchievementId}",
						"get", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/gainedachievements.
	 * Create a gained achievement for a group.
	 */
	public Response postUserGroupGainedAchievements(Long userGroupId,
			JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/gainedachievements", "post",
				array, body);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/gainedachievements. Get
	 * a list of gained achievements for a group.
	 */
	public Response getUserGroupGainedAchievements(Long offset,
			Map<String, String> order, Long userGroupId, List<String> fields,
			Long limit) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("order", order);
		array.put("userGroupId", userGroupId);
		array.put("fields", fields);
		array.put("limit", limit);

		return this.callService(
				"/admin/users/groups/{userGroupId}/gainedachievements", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/users/{friendId}.
	 * Delete a user from user group.
	 */
	public Response deleteUserGroupFriend(Long userGroupId, Long friendId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("friendId", friendId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/users/{friendId}", "delete",
				array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/users/{friendId}. Add a
	 * user to user group.
	 */
	public Response putUserGroupFriend(Long userGroupId, Long friendId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("friendId", friendId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/users/{friendId}", "put",
				array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/externalids/doc. Get a
	 * schema showing how to make a proper json for user group external ids.
	 */
	public Response getUserGroupExternalIdsDocs(Long userGroupId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/externalids/doc", "get",
				array, null);

	}

	/**
	 * Access to url :
	 * /admin/users/groups/{userGroupId}/externalids/{externalId}. Remove an
	 * external group id.
	 */
	public Response deleteUserGroupExternalId(Long userGroupId,
			String externalId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("externalId", externalId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/externalids/{externalId}",
				"delete", array, null);

	}

	/**
	 * Access to url :
	 * /admin/users/groups/{userGroupId}/externalids/{externalId}. Update an
	 * external group id.
	 */
	public Response putUserGroupExternalId(Long userGroupId, String externalId,
			JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("externalId", externalId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/externalids/{externalId}",
				"put", array, body);

	}

	/**
	 * Access to url :
	 * /admin/users/groups/{userGroupId}/externalids/{externalId}. Get an
	 * external group id.
	 */
	public Response getUserGroupExternalId(Long userGroupId, String externalId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("externalId", externalId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/externalids/{externalId}",
				"get", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/externalids. Add an
	 * external group id.
	 */
	public Response postUserGroupExternalIds(Long userGroupId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/externalids", "post", array,
				body);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/externalids. Get a list
	 * of external ids.
	 */
	public Response getUserGroupExternalIds(Long offset,
			Map<String, String> order, Long userGroupId, List<String> fields,
			Long limit) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("order", order);
		array.put("userGroupId", userGroupId);
		array.put("fields", fields);
		array.put("limit", limit);

		return this.callService(
				"/admin/users/groups/{userGroupId}/externalids", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/segments/{segmentId}.
	 * Remove a segment from a user group.
	 */
	public Response deleteUserGroupSegment(Long userGroupId, Long segmentId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("segmentId", segmentId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/segments/{segmentId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/segments/{segmentId}.
	 * Add a segment to a user group.
	 */
	public Response putUserGroupSegment(Long userGroupId, Long segmentId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("segmentId", segmentId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/segments/{segmentId}",
				"put", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/countervalues/doc. Get
	 * a schema showing how to make a proper json for user group counter value.
	 */
	public Response getUserGroupCounterValueDoc(Long userGroupId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/countervalues/doc", "get",
				array, null);

	}

	/**
	 * Access to url :
	 * /admin/users/groups/{userGroupId}/countervalues/{counterValueId}. Remove
	 * one counter value from a user group.
	 */
	public Response deleteUserGroupCounterValue(Long userGroupId,
			Long counterValueId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("counterValueId", counterValueId);

		return this
				.callService(
						"/admin/users/groups/{userGroupId}/countervalues/{counterValueId}",
						"delete", array, null);

	}

	/**
	 * Access to url :
	 * /admin/users/groups/{userGroupId}/countervalues/{counterValueId}. Update
	 * one counter value for a user group.
	 */
	public Response putUserGroupCounterValue(Long userGroupId,
			Long counterValueId, JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("counterValueId", counterValueId);

		return this
				.callService(
						"/admin/users/groups/{userGroupId}/countervalues/{counterValueId}",
						"put", array, body);

	}

	/**
	 * Access to url :
	 * /admin/users/groups/{userGroupId}/countervalues/{counterValueId}. Get one
	 * counter value for a user group.
	 */
	public Response getUserGroupCounterValue(Long userGroupId,
			Long counterValueId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("counterValueId", counterValueId);

		return this
				.callService(
						"/admin/users/groups/{userGroupId}/countervalues/{counterValueId}",
						"get", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/countervalues. Create a
	 * new counter value.
	 */
	public Response postUserGroupCounterValues(Long userGroupId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/countervalues", "post",
				array, body);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/countervalues. Get a
	 * list of counter values fro a user group.
	 */
	public Response getUserGroupCounterValues(Long offset,
			Map<String, String> order, Long userGroupId, List<String> fields,
			Long limit) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("order", order);
		array.put("userGroupId", userGroupId);
		array.put("fields", fields);
		array.put("limit", limit);

		return this.callService(
				"/admin/users/groups/{userGroupId}/countervalues", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/wongames/doc. Get a
	 * schema showing how to make a proper json for user group won games.
	 */
	public Response getUserGroupWonGameDoc(Long userGroupId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/wongames/doc", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/wongames/{wonGameId}.
	 * Delete a won game for user group by id.
	 */
	public Response deleteUserGroupWonGame(Long userGroupId, Long wonGameId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("wonGameId", wonGameId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/wongames/{wonGameId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/wongames/{wonGameId}.
	 * Update a won game for user group by id.
	 */
	public Response putUserGroupWonGame(Long userGroupId, Long wonGameId,
			JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("wonGameId", wonGameId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/wongames/{wonGameId}",
				"put", array, body);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/wongames/{wonGameId}.
	 * Get a won game for user group by id.
	 */
	public Response getUserGroupWonGame(Long userGroupId, Long wonGameId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);
		array.put("wonGameId", wonGameId);

		return this.callService(
				"/admin/users/groups/{userGroupId}/wongames/{wonGameId}",
				"get", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/wongames. Create a won
	 * game for user group.
	 */
	public Response postUserGroupWonGames(Long userGroupId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService("/admin/users/groups/{userGroupId}/wongames",
				"post", array, body);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}/wongames. Get a list of
	 * user group won games.
	 */
	public Response getUserGroupWonGames(Long offset,
			Map<String, String> order, Long userGroupId, List<String> fields,
			Long limit) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("order", order);
		array.put("userGroupId", userGroupId);
		array.put("fields", fields);
		array.put("limit", limit);

		return this.callService("/admin/users/groups/{userGroupId}/wongames",
				"get", array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}. Delete a user group.
	 */
	public Response deleteUserGroup(Long userGroupId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService("/admin/users/groups/{userGroupId}", "delete",
				array, null);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}. Update a user group.
	 */
	public Response putUserGroup(Long userGroupId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService("/admin/users/groups/{userGroupId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/users/groups/{userGroupId}. Get a user group.
	 */
	public Response getUserGroup(Long userGroupId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userGroupId", userGroupId);

		return this.callService("/admin/users/groups/{userGroupId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/users/groups. Add a user group.
	 */
	public Response postUserGroups(JSONObject body) throws Exception {

		return this.callService("/admin/users/groups", "post", null, body);

	}

	/**
	 * Access to url : /admin/users/groups. Get a list of user groups.
	 */
	public Response getUserGroups(Long offset, Map<String, String> order,
			List<String> fields, List<Long> segments, Long limit)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("limit", limit);

		return this.callService("/admin/users/groups", "get", array, null);

	}

	/**
	 * Access to url : /admin/users/externalids/{externalIdName}/{externalId}.
	 * Get one user by external id. Usage - name/id
	 */
	public Response getUserByExternalId(String externalIdName,
			String externalId, List<String> fields) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("externalIdName", externalIdName);
		array.put("externalId", externalId);
		array.put("fields", fields);

		return this.callService(
				"/admin/users/externalids/{externalIdName}/{externalId}",
				"get", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/gainedachievements/doc. Get a
	 * schema showing how to make a proper json for user gained achievement.
	 */
	public Response getUserGainedAchievementsDoc(Long userId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/gainedachievements/doc",
				"get", array, null);

	}

	/**
	 * Access to url :
	 * /admin/users/{userId}/gainedachievements/{gainedAchievementId}. Update
	 * one user gained achievement.
	 */
	public Response deleteUserGainedAchievement(Long userId,
			Long gainedAchievementId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("gainedAchievementId", gainedAchievementId);

		return this
				.callService(
						"/admin/users/{userId}/gainedachievements/{gainedAchievementId}",
						"delete", array, null);

	}

	/**
	 * Access to url :
	 * /admin/users/{userId}/gainedachievements/{gainedAchievementId}. Update
	 * one user gained achievement.
	 */
	public Response putUserGainedAchievement(Long userId,
			Long gainedAchievementId, JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("gainedAchievementId", gainedAchievementId);

		return this
				.callService(
						"/admin/users/{userId}/gainedachievements/{gainedAchievementId}",
						"put", array, body);

	}

	/**
	 * Access to url :
	 * /admin/users/{userId}/gainedachievements/{gainedAchievementId}. Get one
	 * user gained achievement.
	 */
	public Response getUserGainedAchievement(Long userId,
			Long gainedAchievementId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("gainedAchievementId", gainedAchievementId);

		return this
				.callService(
						"/admin/users/{userId}/gainedachievements/{gainedAchievementId}",
						"get", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/gainedachievements. Create a new
	 * gained achievement for a user.
	 */
	public Response postUserGainedAchievements(Long userId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/gainedachievements",
				"post", array, body);

	}

	/**
	 * Access to url : /admin/users/{userId}/gainedachievements. Get a list of
	 * gained achievements for a user.
	 */
	public Response getUserGainedAchievements(Long offset,
			Map<String, String> order, List<String> fields, Long userId,
			Long limit) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService("/admin/users/{userId}/gainedachievements",
				"get", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/customfields/{key}. Delete a custom
	 * field by key.
	 */
	public Response deleteUserCustomField(Long userId, Long key)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("key", key);

		return this.callService("/admin/users/{userId}/customfields/{key}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/customfields/{key}. Get a custom
	 * field by key.
	 */
	public Response getUserCustomField(Long userId, Long key) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("key", key);

		return this.callService("/admin/users/{userId}/customfields/{key}",
				"get", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/customfields. Create a new custom
	 * field for user.
	 */
	public Response postUserCustomFields(Long userId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/customfields", "post",
				array, body);

	}

	/**
	 * Access to url : /admin/users/{userId}/customfields. Update an existing
	 * custom field for user.
	 */
	public Response putUserCustomFields(Long userId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/customfields", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/users/{userId}/customfields. Get all existing
	 * custom fields for user.
	 */
	public Response getUserCustomFields(Long userId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/customfields", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/groups/{groupId}. Remove a group
	 * from user.
	 */
	public Response deleteUserGroup(Long userId, Long groupId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("groupId", groupId);

		return this.callService("/admin/users/{userId}/groups/{groupId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/groups/{groupId}. Add a group to
	 * user.
	 */
	public Response putUserGroup(Long userId, Long groupId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("groupId", groupId);

		return this.callService("/admin/users/{userId}/groups/{groupId}",
				"put", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/externalids/doc. Get a schema
	 * showing how to make a proper json for user external ids.
	 */
	public Response getUserExternalIdsDoc(Long userId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/externalids/doc", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/externalids/{externalId}. Delete
	 * one external id for a user.
	 */
	public Response deleteUserExternalId(Long userId, String externalId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("externalId", externalId);

		return this.callService(
				"/admin/users/{userId}/externalids/{externalId}", "delete",
				array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/externalids/{externalId}. Update
	 * one external id for a user.
	 */
	public Response putUserExternalId(Long userId, String externalId,
			JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("externalId", externalId);

		return this.callService(
				"/admin/users/{userId}/externalids/{externalId}", "put", array,
				body);

	}

	/**
	 * Access to url : /admin/users/{userId}/externalids/{externalId}. Get one
	 * external id for a user.
	 */
	public Response getUserExternalId(Long userId, String externalId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("externalId", externalId);

		return this.callService(
				"/admin/users/{userId}/externalids/{externalId}", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/users/{userId}/externalids. Create a new external
	 * id.
	 */
	public Response postUserExternalIds(Long userId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/externalids", "post",
				array, body);

	}

	/**
	 * Access to url : /admin/users/{userId}/externalids. Get a list of external
	 * ids.
	 */
	public Response getUserExternalIds(Long offset, Map<String, String> order,
			List<String> fields, Long userId, Long limit) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService("/admin/users/{userId}/externalids", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/segments/{segmentId}. Delete a
	 * segment from a user.
	 */
	public Response deleteUserSegment(Long userId, Long segmentId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("segmentId", segmentId);

		return this.callService("/admin/users/{userId}/segments/{segmentId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/segments/{segmentId}. Add a segment
	 * to a user.
	 */
	public Response putUserSegment(Long userId, Long segmentId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("segmentId", segmentId);

		return this.callService("/admin/users/{userId}/segments/{segmentId}",
				"put", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/countervalues/doc. Get a schema
	 * showing how to make a proper json for user counter values.
	 */
	public Response getUserCounterValueDoc(Long userId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/countervalues/doc",
				"get", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/countervalues/{counterValueId}.
	 * Delete one user counter value.
	 */
	public Response deleteUserCounterValue(Long userId, Long counterValueId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("counterValueId", counterValueId);

		return this.callService(
				"/admin/users/{userId}/countervalues/{counterValueId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/countervalues/{counterValueId}.
	 * Update one user counter value.
	 */
	public Response putUserCounterValue(Long userId, Long counterValueId,
			JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("counterValueId", counterValueId);

		return this.callService(
				"/admin/users/{userId}/countervalues/{counterValueId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/users/{userId}/countervalues/{counterValueId}. Get
	 * one user counter value.
	 */
	public Response getUserCounterValue(Long userId, Long counterValueId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("counterValueId", counterValueId);

		return this.callService(
				"/admin/users/{userId}/countervalues/{counterValueId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/countervalues. Create a new counter
	 * value for a user.
	 */
	public Response postUserCounterValues(Long userId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/countervalues", "post",
				array, body);

	}

	/**
	 * Access to url : /admin/users/{userId}/countervalues. Get a list of
	 * counter values for a user.
	 */
	public Response getUserCounterValues(Long offset,
			Map<String, String> order, List<String> fields, Long userId,
			Long limit) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService("/admin/users/{userId}/countervalues", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/wongames/doc. Get a pseudo schema
	 * showing quickly how to make a proper json for user won game.
	 */
	public Response getUserWonGamesDoc(Long userId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/wongames/doc", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/wongames/{wonGameId}. Delete one
	 * won game for a user.
	 */
	public Response deleteUserWonGame(Long userId, Long wonGameId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("wonGameId", wonGameId);

		return this.callService("/admin/users/{userId}/wongames/{wonGameId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/wongames/{wonGameId}. Update one
	 * won game for a user.
	 */
	public Response putUserWonGame(Long userId, Long wonGameId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("wonGameId", wonGameId);

		return this.callService("/admin/users/{userId}/wongames/{wonGameId}",
				"put", array, body);

	}

	/**
	 * Access to url : /admin/users/{userId}/wongames/{wonGameId}. Get one won
	 * game for a user.
	 */
	public Response getUserWonGame(Long userId, Long wonGameId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("wonGameId", wonGameId);

		return this.callService("/admin/users/{userId}/wongames/{wonGameId}",
				"get", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/wongames. Create a new won game for
	 * a user.
	 */
	public Response postUserWonGames(Long userId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}/wongames", "post",
				array, body);

	}

	/**
	 * Access to url : /admin/users/{userId}/wongames. Get a list of won games
	 * for a user.
	 */
	public Response getUserWonGames(Long offset, Map<String, String> order,
			List<String> fields, Long userId, Long limit) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("userId", userId);
		array.put("limit", limit);

		return this.callService("/admin/users/{userId}/wongames", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/users/{userId}/friends/{friendId}. Remove a friend
	 * from user.
	 */
	public Response deleteUserFriend(Long userId, Long friendId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("friendId", friendId);

		return this.callService("/admin/users/{userId}/friends/{friendId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}/friends/{friendId}. Add a friend to
	 * user.
	 */
	public Response putUserFriend(Long userId, Long friendId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);
		array.put("friendId", friendId);

		return this.callService("/admin/users/{userId}/friends/{friendId}",
				"put", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}. Delete one user
	 */
	public Response deleteUser(Long userId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}", "delete", array, null);

	}

	/**
	 * Access to url : /admin/users/{userId}. Update one user by id.
	 */
	public Response putUser(Long userId, JSONObject body) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}", "put", array, body);

	}

	/**
	 * Access to url : /admin/users/{userId}. Get one user by id.
	 */
	public Response getUser(Long userId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("userId", userId);

		return this.callService("/admin/users/{userId}", "get", array, null);

	}

	/**
	 * Access to url : /admin/users. Add a user.
	 */
	public Response postUsers(JSONObject body) throws Exception {

		return this.callService("/admin/users", "post", null, body);

	}

	/**
	 * Access to url : /admin/users. Get a list of users.
	 */
	public Response getUsers(List<Long> groups, Long offset,
			Map<String, String> order, List<String> fields,
			List<Long> segments, Long limit) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("groups", groups);
		array.put("offset", offset);
		array.put("order", order);
		array.put("fields", fields);
		array.put("segments", segments);
		array.put("limit", limit);

		return this.callService("/admin/users", "get", array, null);

	}

	/**
	 * Access to url : /admin/clientscripts/doc. Get a schema showing how to
	 * create a proper json for clientscripts.
	 */
	public Response getClientScriptsDoc() throws Exception {

		return this.callService("/admin/clientscripts/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/clientscripts/{clientScriptId}. Delete one client
	 * script using and id.
	 */
	public Response deleteClientScript(Long clientScriptId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("clientScriptId", clientScriptId);

		return this.callService("/admin/clientscripts/{clientScriptId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/clientscripts/{clientScriptId}. Use this method to
	 * change one client script.
	 */
	public Response putClientScript(Long clientScriptId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("clientScriptId", clientScriptId);

		return this.callService("/admin/clientscripts/{clientScriptId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/clientscripts/{clientScriptId}. Use this method to
	 * get one client script by id.
	 */
	public Response getClientScript(Long clientScriptId, List<String> fields)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("clientScriptId", clientScriptId);
		array.put("fields", fields);

		return this.callService("/admin/clientscripts/{clientScriptId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/clientscripts. We can use this method to create a
	 * new client script. It needs a body and returns the created object.
	 */
	public Response postClientScripts(JSONObject body) throws Exception {

		return this.callService("/admin/clientscripts", "post", null, body);

	}

	/**
	 * Access to url : /admin/clientscripts. Use this method to get a list of
	 * client scripts. It returns a json body.
	 */
	public Response getClientScripts(List<String> fields,
			Map<String, String> order, Long offset, Long limit)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("order", order);
		array.put("offset", offset);
		array.put("limit", limit);

		return this.callService("/admin/clientscripts", "get", array, null);

	}

	/**
	 * Access to url : /admin/segments/doc. Get a schema showing how to make a
	 * proper json for segment.
	 */
	public Response getSegmentsDocs() throws Exception {

		return this.callService("/admin/segments/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/segments/{segmentId}. Delete a segment.
	 */
	public Response deleteSegment(Long segmentId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("segmentId", segmentId);

		return this.callService("/admin/segments/{segmentId}", "delete", array,
				null);

	}

	/**
	 * Access to url : /admin/segments/{segmentId}. Update a segment.
	 */
	public Response putSegment(Long segmentId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("segmentId", segmentId);

		return this.callService("/admin/segments/{segmentId}", "put", array,
				body);

	}

	/**
	 * Access to url : /admin/segments/{segmentId}. Get a segment by its id.
	 */
	public Response getSegment(Long segmentId, List<String> fields)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("segmentId", segmentId);
		array.put("fields", fields);

		return this.callService("/admin/segments/{segmentId}", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/segments. Add a new segment.
	 */
	public Response postSegments(JSONObject body) throws Exception {

		return this.callService("/admin/segments", "post", null, body);

	}

	/**
	 * Access to url : /admin/segments. Get a segment list.
	 */
	public Response getSegments(List<String> fields, Long offset, Long limit,
			Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("order", order);

		return this.callService("/admin/segments", "get", array, null);

	}

	/**
	 * Access to url : /admin/conditions/doc. Get a schema showing how to make a
	 * proper json for clientscripts.
	 */
	public Response getConditionsDoc() throws Exception {

		return this.callService("/admin/conditions/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/conditions/{conditionId}/counters/{counterId}.
	 * Remove a counter.
	 */
	public Response deleteConditionCounter(Long conditionId, Long counterId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("conditionId", conditionId);
		array.put("counterId", counterId);

		return this.callService(
				"/admin/conditions/{conditionId}/counters/{counterId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/conditions/{conditionId}/counters/{counterId}. Add
	 * a counter.
	 */
	public Response putConditionCounter(Long conditionId, Long counterId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("conditionId", conditionId);
		array.put("counterId", counterId);

		return this.callService(
				"/admin/conditions/{conditionId}/counters/{counterId}", "put",
				array, null);

	}

	/**
	 * Access to url : /admin/conditions/{conditionId}. Delete one condition.
	 */
	public Response deleteCondition(Long conditionId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("conditionId", conditionId);

		return this.callService("/admin/conditions/{conditionId}", "delete",
				array, null);

	}

	/**
	 * Access to url : /admin/conditions/{conditionId}. Change one condition.
	 */
	public Response putCondition(Long conditionId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("conditionId", conditionId);

		return this.callService("/admin/conditions/{conditionId}", "put",
				array, body);

	}

	/**
	 * Access to url : /admin/conditions/{conditionId}. Get one condition by its
	 * id.
	 */
	public Response getCondition(Long conditionId, List<String> fields)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("conditionId", conditionId);
		array.put("fields", fields);

		return this.callService("/admin/conditions/{conditionId}", "get",
				array, null);

	}

	/**
	 * Access to url : /admin/conditions. Add a new condition.
	 */
	public Response postConditions(JSONObject body) throws Exception {

		return this.callService("/admin/conditions", "post", null, body);

	}

	/**
	 * Access to url : /admin/conditions. Get a list of conditions.
	 */
	public Response getConditions(List<String> fields, Long offset, Long limit,
			Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("fields", fields);
		array.put("offset", offset);
		array.put("limit", limit);
		array.put("order", order);

		return this.callService("/admin/conditions", "get", array, null);

	}

	/**
	 * Access to url : /admin/counters/doc. Get a schema showing how to make a
	 * proper json for counters.
	 */
	public Response getCountersDoc() throws Exception {

		return this.callService("/admin/counters/doc", "get", null, null);

	}

	/**
	 * Access to url : /admin/counters/{counterId}/conditions/{conditionId}.
	 * Remove a condition from a counter.
	 */
	public Response deleteCounterCondition(Long counterId, Long conditionId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("counterId", counterId);
		array.put("conditionId", conditionId);

		return this.callService(
				"/admin/counters/{counterId}/conditions/{conditionId}",
				"delete", array, null);

	}

	/**
	 * Access to url : /admin/counters/{counterId}/conditions/{conditionId}. Add
	 * a condition to a counter.
	 */
	public Response putCounterCondition(Long counterId, Long conditionId)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("counterId", counterId);
		array.put("conditionId", conditionId);

		return this.callService(
				"/admin/counters/{counterId}/conditions/{conditionId}", "put",
				array, null);

	}

	/**
	 * Access to url : /admin/counters/{counterId}. Delete one counter.
	 */
	public Response deleteCounter(Long counterId) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("counterId", counterId);

		return this.callService("/admin/counters/{counterId}", "delete", array,
				null);

	}

	/**
	 * Access to url : /admin/counters/{counterId}. Update a counter.
	 */
	public Response putCounter(Long counterId, JSONObject body)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("counterId", counterId);

		return this.callService("/admin/counters/{counterId}", "put", array,
				body);

	}

	/**
	 * Access to url : /admin/counters/{counterId}. Get one counter.
	 */
	public Response getCounter(Long counterId, List<String> fields)
			throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("counterId", counterId);
		array.put("fields", fields);

		return this.callService("/admin/counters/{counterId}", "get", array,
				null);

	}

	/**
	 * Access to url : /admin/counters. Add a new counter.
	 */
	public Response postCounters(JSONObject body) throws Exception {

		return this.callService("/admin/counters", "post", null, body);

	}

	/**
	 * Access to url : /admin/counters. Get one counter.
	 */
	public Response getCounters(Long offset, Long limit, List<String> fields,
			Map<String, String> order) throws Exception {

		Map<String, Object> array = new HashMap<String, Object>();

		array.put("offset", offset);
		array.put("limit", limit);
		array.put("fields", fields);
		array.put("order", order);

		return this.callService("/admin/counters", "get", array, null);

	}

}