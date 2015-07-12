package org.snow.cms.service;

import java.util.List;
import org.snow.cms.model.Group;
import org.snow.cms.model.Role;
import org.snow.cms.model.User;
import org.snow.cms.util.Pager;

public abstract interface IUserService
{
  public abstract void add(User paramUser, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2);

  public abstract void delete(int paramInt);

  public abstract void update(User paramUser, Integer[] paramArrayOfInteger1, Integer[] paramArrayOfInteger2);

  public abstract void updateStatus(int paramInt);

  public abstract Pager<User> findUser();

  public abstract User load(int paramInt);

  public abstract List<Role> listUserRoles(int paramInt);

  public abstract List<Group> listUserGroups(int paramInt);

  public abstract List<Integer> listUserRoleIds(int paramInt);

  public abstract List<Integer> listUserGroupIds(int paramInt);

  public abstract List<User> listGroupUsers(int paramInt);

  public abstract List<User> listRoleUsers(int paramInt);

  public abstract User login(String paramString1, String paramString2);

  public abstract void updateSelf(User paramUser);

  public abstract void updatePwd(int paramInt, String paramString1, String paramString2);
}

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-user\0.0.1-SNAPSHOT\cms-user-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.IUserService
 * JD-Core Version:    0.6.2
 */