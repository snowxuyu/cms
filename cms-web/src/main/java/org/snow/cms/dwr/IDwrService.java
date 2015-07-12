package org.snow.cms.dwr;

public abstract interface IDwrService
{
  public abstract void addGroupChannel(int paramInt1, int paramInt2);

  public abstract void deleteGroupChannel(int paramInt1, int paramInt2);

  public abstract void updateIndexPic(int paramInt);

  public abstract void updateAttachInfo(int paramInt);

  public abstract void deleteAttach(int paramInt);

  public abstract void updatePicPos(int paramInt1, int paramInt2, int paramInt3);

  public abstract void updateLinkPos(int paramInt1, int paramInt2, int paramInt3);
}