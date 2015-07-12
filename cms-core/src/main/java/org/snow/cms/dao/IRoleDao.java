package org.snow.cms.dao;

import java.util.List;
import org.snow.cms.model.Role;

public abstract interface IRoleDao extends IBaseDao<Role>
{
  public abstract List<Role> listUserRoles(int paramInt);

  public abstract List<Integer> listUserRoleIds(int paramInt);

  public abstract List<Role> listRole();

  public abstract void deleteRoleUsers(int paramInt);
}
