package org.snow.cms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.snow.cms.dao.IAttachmentDao;
import org.snow.cms.model.Attachment;
import org.snow.cms.util.Pager;
import org.springframework.stereotype.Repository;

@Repository("attachmentDao")
public class AttachmentDaoImpl extends BaseDaoImpl<Attachment> implements
		IAttachmentDao {
	@Inject
	private SqlSession sqlSession;

	public Pager<Attachment> findNoUseAttachment() {
		Map<String, Object> map = new HashMap<String, Object>();
		return find(Attachment.class.getName() + ".find_no_use_attach", map);
	}

	public void clearNoUseAttachment() {
		this.sqlSession.delete(Attachment.class.getName()
				+ ".clear_no_use_attach");
	}

	public void deleteByTopic(int topicId) {
		this.sqlSession.delete(Attachment.class.getName() + ".delete_by_topic",
				Integer.valueOf(topicId));
	}

	public List<Attachment> listByTopic(int topicId) {
		return this.sqlSession.selectList(Attachment.class.getName()
				+ ".list_by_topic", Integer.valueOf(topicId));
	}

	public List<Attachment> listIndexPic(int num) {
		return this.sqlSession.selectList(Attachment.class.getName()
				+ ".list_index_pic", Integer.valueOf(num));
	}

	public Pager<Attachment> findChannelPic(int channelId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("channelId", Integer.valueOf(channelId));
		return find(Attachment.class.getName() + ".find_channel_pic", map);
	}

	public List<Attachment> listAttachmentByTopic(int topicId) {
		return this.sqlSession.selectList(Attachment.class.getName()
				+ ".list_attach_by_topic", Integer.valueOf(topicId));
	}

}
