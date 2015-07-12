package org.snow.cms.dao;

import java.util.List;
import org.snow.cms.model.Channel;
import org.snow.cms.model.ChannelTree;

public abstract interface IChannelDao extends IBaseDao<Channel>
{
  public abstract List<Channel> listChannelByParent(Integer paramInteger);

  public abstract int getMaxOrderByParent(Integer paramInteger);

  public abstract List<ChannelTree> generateTree();

  public abstract List<ChannelTree> generateTreeByParent(Integer paramInteger);

  public abstract void updateSort(Integer[] paramArrayOfInteger);

  public abstract List<Channel> listPublishChannel();
}
