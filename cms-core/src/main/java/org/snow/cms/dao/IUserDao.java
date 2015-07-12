package org.snow.cms.dao;

import java.util.List;
import java.util.Map;
import org.snow.cms.model.Group;
import org.snow.cms.model.Role;
import org.snow.cms.model.RoleType;
import org.snow.cms.model.User;
import org.snow.cms.model.UserGroup;
import org.snow.cms.model.UserRole;
import org.snow.cms.util.Pager;

public abstract interface IUserDao extends IBaseDao<User>
{
  public abstract UserRole loadUserRole(int paramInt1, int paramInt2);

  public abstract UserGroup loadUserGroup(int paramInt1, int paramInt2);

  public abstract User loadByUsername(String paramString);

  public abstract List<User> listRoleUsers(int paramInt);

  public abstract List<User> listRoleUsers(RoleType paramRoleType);

  public abstract List<User> listGroupUsers(int paramInt);

  public abstract void addUserRole(User paramUser, Role paramRole);

  public abstract void addUserGroup(User paramUser, Group paramGroup);

  public abstract void deleteUserRoles(int paramInt);

  public abstract void deleteUserGroups(int paramInt);

  public abstract Pager<User> findUser(Map<String, Object> paramMap);

  public abstract void deleteUserRole(int paramInt1, int paramInt2);

  public abstract void deleteUserGroup(int paramInt1, int paramInt2);
}
