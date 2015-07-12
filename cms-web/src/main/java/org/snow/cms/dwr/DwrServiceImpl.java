package org.snow.cms.dwr;

import javax.inject.Inject;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.snow.cms.service.IAttachmentService;
import org.snow.cms.service.IGroupService;

@RemoteProxy(name="dwrController")
public class DwrServiceImpl
  implements IDwrService
{

  @Inject
  private IGroupService groupService;

  @Inject
  private IAttachmentService attachmentService;

  @RemoteMethod
  public void addGroupChannel(int gid, int cid)
  {
    this.groupService.addGroupChannel(gid, cid);
  }

  @RemoteMethod
  public void deleteGroupChannel(int gid, int cid)
  {
    this.groupService.deleteGroupChannel(gid, cid);
  }

  @RemoteMethod
  public void updateIndexPic(int aid)
  {
    this.attachmentService.updateIndexPic(aid);
  }

  @RemoteMethod
  public void updateAttachInfo(int aid)
  {
    this.attachmentService.updateAttachInfo(aid);
  }

  @RemoteMethod
  public void deleteAttach(int id)
  {
    this.attachmentService.delete(id);
  }

  @RemoteMethod
  public void updatePicPos(int id, int oldPos, int newPos)
  {
  }

  @RemoteMethod
  public void updateLinkPos(int id, int oldPos, int newPos)
  {
  }
}