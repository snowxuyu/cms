package org.snow.cms.dao;

import java.util.List;
import org.snow.cms.model.Channel;
import org.snow.cms.model.ChannelTree;
import org.snow.cms.model.Group;
import org.snow.cms.model.GroupChannel;
import org.snow.cms.util.Pager;

public abstract interface IGroupDao extends IBaseDao<Group>
{
  public abstract List<Group> listUserGroups(int paramInt);

  public abstract List<Integer> listUserGroupIds(int paramInt);

  public abstract List<Group> listGroup();

  public abstract Pager<Group> findGroup();

  public abstract void deleteGroupUsers(int paramInt);

  public abstract void addGroupChannel(Group paramGroup, Channel paramChannel);

  public abstract GroupChannel loadGroupChannel(int paramInt1, int paramInt2);

  public abstract void deleteGroupChannel(int paramInt1, int paramInt2);

  public abstract void clearGroupChannel(int paramInt);

  public abstract List<ChannelTree> generateGroupChannelTree(int paramInt);

  public abstract List<ChannelTree> generateUserChannelTree(int paramInt);

  public abstract List<Integer> listGroupChannelIds(int paramInt);
}
