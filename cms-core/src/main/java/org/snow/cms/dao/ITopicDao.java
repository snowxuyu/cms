package org.snow.cms.dao;

import org.snow.cms.model.Topic;
import org.snow.cms.util.Pager;

public abstract interface ITopicDao extends IBaseDao<Topic>
{
  public abstract Pager<Topic> find(Integer paramInteger, String paramString, int paramInt);

  public abstract Pager<Topic> find(Integer paramInteger1, Integer paramInteger2, String paramString, int paramInt);

  public abstract Pager<Topic> searchTopicByKeyword(String paramString);

  public abstract Pager<Topic> searchTopic(String paramString);

  public abstract Pager<Topic> findRecommendTopic(Integer paramInteger);
}

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.dao.ITopicDao
 * JD-Core Version:    0.6.2
 */