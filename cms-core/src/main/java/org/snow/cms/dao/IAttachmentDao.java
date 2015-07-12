package org.snow.cms.dao;

import java.util.List;
import org.snow.cms.model.Attachment;
import org.snow.cms.util.Pager;

public abstract interface IAttachmentDao extends IBaseDao<Attachment>
{
  public abstract Pager<Attachment> findNoUseAttachment();

  public abstract void clearNoUseAttachment();

  public abstract void deleteByTopic(int paramInt);

  public abstract List<Attachment> listByTopic(int paramInt);

  public abstract List<Attachment> listIndexPic(int paramInt);

  public abstract Pager<Attachment> findChannelPic(int paramInt);

  public abstract List<Attachment> listAttachmentByTopic(int paramInt);
}
