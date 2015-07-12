package org.snow.cms.service;

import org.snow.cms.model.Topic;
import org.snow.cms.util.Pager;

public abstract interface ITopicService
{
  public abstract void add(Topic paramTopic, int paramInt1, int paramInt2, Integer[] paramArrayOfInteger);

  public abstract void add(Topic paramTopic, int paramInt1, int paramInt2);

  public abstract void delete(int paramInt);

  public abstract void update(Topic paramTopic, int paramInt, Integer[] paramArrayOfInteger);

  public abstract void update(Topic paramTopic, int paramInt);

  public abstract void updateStatus(int paramInt);

  public abstract Topic load(int paramInt);

  public abstract Pager<Topic> find(Integer paramInteger1, String paramString, Integer paramInteger2);

  public abstract Pager<Topic> find(Integer paramInteger1, Integer paramInteger2, String paramString, Integer paramInteger3);

  public abstract Pager<Topic> searchTopicByKeyword(String paramString);

  public abstract Pager<Topic> searchTopic(String paramString);

  public abstract Pager<Topic> findRecommendTopic(Integer paramInteger);
}

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-topic\0.0.1-SNAPSHOT\cms-topic-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.ITopicService
 * JD-Core Version:    0.6.2
 */