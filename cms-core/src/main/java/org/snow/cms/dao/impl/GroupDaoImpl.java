package org.snow.cms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.snow.cms.dao.IGroupDao;
import org.snow.cms.model.Channel;
import org.snow.cms.model.ChannelTree;
import org.snow.cms.model.Group;
import org.snow.cms.model.GroupChannel;
import org.snow.cms.util.Pager;
import org.springframework.stereotype.Repository;

@Repository("groupDao")
public class GroupDaoImpl extends BaseDaoImpl<Group> implements IGroupDao {

	@Inject
	private SqlSession sqlSession;

	public List<Group> listUserGroups(int userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(userId));
		return list(Group.class.getName() + ".list_user_group", map);
	}

	public List<Integer> listUserGroupIds(int userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", Integer.valueOf(userId));
		List<Integer> list = this.sqlSession.selectList(
				"org.snow.cms.model.Group.list_user_roleIds", map);
		return list;
	}

	public List<Group> listGroup() {
		List<Group> list = list(Group.class, null);
		return list;
	}

	public Pager<Group> findGroup() {
		Pager<Group> pager = find(Group.class, null);
		return pager;
	}

	public void deleteGroupUsers(int groupId) {
		this.sqlSession.delete(Group.class.getName() + ".delete_group_users",
				Integer.valueOf(groupId));
	}

	public void addGroupChannel(Group group, Channel channel) {
		GroupChannel gc = loadGroupChannel(group.getId(), channel.getId());
		if (null != gc)
			return;
		gc = new GroupChannel();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupId", Integer.valueOf(group.getId()));
		map.put("channelId", Integer.valueOf(channel.getId()));
		this.sqlSession.insert(Group.class.getName() + ".add_group_channel",map);
	}

	public GroupChannel loadGroupChannel(int gid, int cid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupId", Integer.valueOf(gid));
		map.put("channelId", Integer.valueOf(cid));
		GroupChannel gc = (GroupChannel) this.sqlSession.selectOne(
				Group.class.getName() + ".load_group_channel", map);
		return gc;
	}

	public void deleteGroupChannel(int gid, int cid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupId", Integer.valueOf(gid));
		map.put("channelId", Integer.valueOf(cid));
		this.sqlSession.delete(Group.class.getName() + ".delete_group_channel",
				map);
	}

	public void clearGroupChannel(int gid) {
		this.sqlSession.delete(Group.class.getName() + ".clear_group_channel",
				Integer.valueOf(gid));
	}

	public List<ChannelTree> generateGroupChannelTree(int gid) {
		List<ChannelTree> list = this.sqlSession.selectList(Group.class.getName()
				+ ".generate_group_channel_tree", Integer.valueOf(gid));
		ChannelDaoImpl.initTreeNode(list);
		return list;
	}

	public List<ChannelTree> generateUserChannelTree(int uid) {
		List<ChannelTree> list = this.sqlSession.selectList(Group.class.getName()
				+ ".generate_user_channel_tree", Integer.valueOf(uid));
		ChannelDaoImpl.initTreeNode(list);
		return list;
	}

	public List<Integer> listGroupChannelIds(int gid) {
		List<Integer> list = this.sqlSession.selectList(Group.class.getName()
				+ ".list_group_channel_ids", Integer.valueOf(gid));
		return list;
	}
}
