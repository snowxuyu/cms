package org.snow.cms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.snow.cms.dao.IChannelDao;
import org.snow.cms.model.Channel;
import org.snow.cms.model.ChannelTree;
import org.springframework.stereotype.Repository;

@Repository("channelDao")
public class ChannelDaoImpl extends BaseDaoImpl<Channel> implements IChannelDao {

	@Inject
	private SqlSession sqlSession;

	public static void initTreeNode(List<ChannelTree> listTree) {
		listTree.add(
				0,
				new ChannelTree(Integer.valueOf(0), "网站系统栏目", Integer
						.valueOf(-1)));
		for (ChannelTree ct : listTree)
			if (null == ct.getPid())
				ct.setPid(Integer.valueOf(0));
	}

	public List<Channel> listChannelByParent(Integer pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pid", pid);
		List<Channel> list = list(Channel.class.getName() + ".list_channel_by_parent",
				map);
		return list;
	}

	public int getMaxOrderByParent(Integer pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pid", pid);
		Integer max = (Integer) this.sqlSession.selectOne(
				Channel.class.getName() + ".get_max_orders_by_parent", map);
		if (null == max)
			return 0;
		return max.intValue();
	}

	public List<ChannelTree> generateTree() {
		List<ChannelTree> list = this.sqlSession.selectList(Channel.class.getName()
				+ ".generate_tree");
		initTreeNode(list);
		return list;
	}

	public List<ChannelTree> generateTreeByParent(Integer pid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pid", pid);
		return this.sqlSession.selectList(Channel.class.getName()
				+ ".generate_tree_by_parent", map);
	}

	public void updateSort(Integer[] ids) {
		int index = 1;
		Map<String, Object> map = new HashMap<String, Object>();
		for (Integer id : ids) {
			map.put("orders", Integer.valueOf(index++));
			map.put("id", id);
			this.sqlSession.update(Channel.class.getName() + ".update_sort",
					map);
		}
	}

	public List<Channel> listPublishChannel() {
		return this.sqlSession.selectList(Channel.class.getName()
				+ ".list_publish_channel");
	}
}
