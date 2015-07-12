package org.snow.cms.service;

import java.util.List;
import org.snow.cms.model.ChannelTree;
import org.snow.cms.model.Group;
import org.snow.cms.model.GroupChannel;
import org.snow.cms.util.Pager;

public abstract interface IGroupService
{
  public abstract void add(Group paramGroup);

  public abstract void update(Group paramGroup);

  public abstract void delete(int paramInt);

  public abstract Group load(int paramInt);

  public abstract List<Group> listGroup();

  public abstract Pager<Group> findGroup();

  public abstract void deleteGroupUsers(int paramInt);

  public abstract void addGroupChannel(int paramInt1, int paramInt2);

  public abstract GroupChannel loadGroupChannel(int paramInt1, int paramInt2);

  public abstract void deleteGroupChannel(int paramInt1, int paramInt2);

  public abstract void clearGroupChannel(int paramInt);

  public abstract List<ChannelTree> generateGroupChannelTree(int paramInt);

  public abstract List<ChannelTree> generateUserChannelTree(int paramInt);

  public abstract List<Integer> listGroupChannelIds(int paramInt);
}

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-user\0.0.1-SNAPSHOT\cms-user-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.IGroupService
 * JD-Core Version:    0.6.2
 */