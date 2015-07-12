package org.snow.cms.service;

import java.util.List;
import org.snow.cms.model.Role;

public abstract interface IRoleService
{
  public abstract void add(Role paramRole);

  public abstract void update(Role paramRole);

  public abstract void delete(int paramInt);

  public abstract Role load(int paramInt);

  public abstract List<Role> listRole();

  public abstract void deleteRoleUsers(int paramInt);
}

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-user\0.0.1-SNAPSHOT\cms-user-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.IRoleService
 * JD-Core Version:    0.6.2
 */