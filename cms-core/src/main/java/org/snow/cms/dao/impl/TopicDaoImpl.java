package org.snow.cms.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.snow.cms.dao.ITopicDao;
import org.snow.cms.model.Topic;
import org.snow.cms.util.Pager;
import org.springframework.stereotype.Repository;

@Repository("topicDao")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements ITopicDao {
	public Pager<Topic> find(Integer channelId, String title, int status) {
		return find(null, channelId, title, status);
	}

	public Pager<Topic> find(Integer userId, Integer channelId, String title,
			int status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("channelId", channelId);
		map.put("title", title);
		map.put("status", Integer.valueOf(status));
		return find(Topic.class, map);
	}

	public Pager<Topic> searchTopicByKeyword(String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		return find(Topic.class.getName() + ".search_topic_by_keyword", map);
	}

	public Pager<Topic> searchTopic(String con) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("con", con);
		return find(Topic.class.getName() + ".search_topic", map);
	}

	public Pager<Topic> findRecommendTopic(Integer channelId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("channelId", channelId);
		return find(Topic.class.getName() + ".find_recommend_topic", map);
	}
}
