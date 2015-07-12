package org.snow.cms.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.snow.cms.model.Attachment;
import org.snow.cms.util.Pager;

public abstract interface IAttachmentService
{
  public abstract void add(Attachment paramAttachment, InputStream paramInputStream)
    throws IOException;

  public abstract void delete(int paramInt);

  public abstract Attachment load(int paramInt);

  public abstract Pager<Attachment> findNoUseAttachment();

  public abstract void clearNoUseAttachment();

  public abstract List<Attachment> listByTopic(int paramInt);

  public abstract List<Attachment> listIndexPic(int paramInt);

  public abstract Pager<Attachment> findChannelPic(int paramInt);

  public abstract List<Attachment> listAttachByTopic(int paramInt);

  public abstract void updateIndexPic(int paramInt);

  public abstract void updateAttachInfo(int paramInt);
}

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-topic\0.0.1-SNAPSHOT\cms-topic-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.IAttachmentService
 * JD-Core Version:    0.6.2
 */