package org.snow.cms.service;

import java.util.List;
import org.snow.cms.model.Channel;
import org.snow.cms.model.ChannelTree;

public abstract interface IChannelService
{
  public abstract void add(Channel paramChannel, Integer paramInteger);

  public abstract void update(Channel paramChannel);

  public abstract void delete(int paramInt);

  public abstract Channel load(int paramInt);

  public abstract void clearTopic(int paramInt);

  public abstract List<Channel> listChannelByParent(Integer paramInteger);

  public abstract List<ChannelTree> generateTree();

  public abstract List<ChannelTree> generateTreeByParent(Integer paramInteger);

  public abstract void updateSort(Integer[] paramArrayOfInteger);

  public abstract List<Channel> listPublishChannel();
}

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-topic\0.0.1-SNAPSHOT\cms-topic-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.IChannelService
 * JD-Core Version:    0.6.2
 */