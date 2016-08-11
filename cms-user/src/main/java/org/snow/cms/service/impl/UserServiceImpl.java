/*     */ package org.snow.cms.service.impl;
/*     */ 
/*     */ import org.apache.commons.lang.ArrayUtils;
import org.snow.cms.dao.IGroupDao;
import org.snow.cms.dao.IRoleDao;
import org.snow.cms.dao.IUserDao;
import org.snow.cms.model.Group;
import org.snow.cms.model.Role;
import org.snow.cms.model.User;
import org.snow.cms.service.IUserService;
import org.snow.cms.util.CmsException;
import org.snow.cms.util.Pager;
import org.snow.cms.util.SecurityUtil;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ @Service("userService")
/*     */ public class UserServiceImpl
/*     */   implements IUserService
/*     */ {
/*     */
/*     */   @Inject
/*     */   private IUserDao userDao;
/*     */
/*     */   @Inject
/*     */   private IRoleDao roleDao;
/*     */
/*     */   @Inject
/*     */   private IGroupDao groupDao;
/*     */
/*     */   public void add(User user, Integer[] roleIds, Integer[] groupIds)
/*     */   {
/*  30 */     User u = this.userDao.loadByUsername(user.getUsername());
/*  31 */     if (null != u) {
/*  32 */       throw new CmsException("要添加的用户已存在,不能重复添加!");
/*     */     }
/*     */ 
/*  35 */     user.setPassword(SecurityUtil.md5(user.getUsername(), user.getPassword()));
/*  36 */     this.userDao.add(user);
/*     */ 
/*  39 */     Integer[] arr = roleIds; int len = arr.length;
    for (int i = 0; i < len; i++) { int roleId = arr[i].intValue();
/*  40 */       addUserRole(user, roleId);
/*     */     }
/*     */ 
/*  44 */     Integer[] arr$ = groupIds; int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { int groupId = arr$[i$].intValue();
/*  45 */       addUserGroup(user, groupId);
/*     */     }
/*     */   }
/*     */
/*     */   public void delete(int userId)
/*     */   {
/*  54 */     this.userDao.deleteUserRoles(userId);
/*     */ 
/*  57 */     this.userDao.deleteUserGroups(userId);
/*     */ 
/*  60 */     this.userDao.delete(User.class, Integer.valueOf(userId));
/*     */   }
/*     */
/*     */   public void update(User user, Integer[] roleIds, Integer[] groupIds)
/*     */   {
/*  66 */     List gids = this.groupDao.listUserGroupIds(user.getId());
/*  67 */     List rids = this.roleDao.listUserRoleIds(user.getId());
/*     */ 
/*  70 */     Integer[] arr$ = roleIds; int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { int rid = arr$[i$].intValue();
/*  71 */       if (!rids.contains(Integer.valueOf(rid))) {
/*  72 */         addUserRole(user, rid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  77 */     Integer[] arr$1 = groupIds; int len$1 = arr$.length; for (int i$ = 0; i$ < len$; i$++) { int gid = arr$[i$].intValue();
/*  78 */       if (!gids.contains(Integer.valueOf(gid))) {
/*  79 */         addUserGroup(user, gid);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  84 */     for (Iterator i$ = rids.iterator(); i$.hasNext(); ) { int rid = ((Integer)i$.next()).intValue();
/*     */ 
/*  86 */       if (!ArrayUtils.contains(roleIds, Integer.valueOf(rid))) {
/*  87 */         this.userDao.deleteUserRole(user.getId(), rid);
/*     */       }
/*     */     }
/*     */ 
/*  91 */     for (Iterator i$ = gids.iterator(); i$.hasNext(); ) { int gid = ((Integer)i$.next()).intValue();
/*     */ 
/*  93 */       if (!ArrayUtils.contains(groupIds, Integer.valueOf(gid))) {
/*  94 */         this.userDao.deleteUserGroup(user.getId(), gid);
/*     */       }
/*     */     }
/*     */ 
/*  98 */     this.userDao.update(user);
/*     */   }
/*     */
/*     */   public void updateStatus(int userId)
/*     */   {
/* 103 */     User user = (User)this.userDao.load(User.class, Integer.valueOf(userId));
/* 104 */     if (0 == user.getStatus())
/* 105 */       user.setStatus(1);
/*     */     else {
/* 107 */       user.setStatus(0);
/*     */     }
/* 109 */     this.userDao.update(user);
/*     */   }
/*     */
/*     */   public Pager<User> findUser()
/*     */   {
/* 114 */     return this.userDao.findUser(null);
/*     */   }
/*     */
/*     */   public User load(int userId)
/*     */   {
/* 119 */     return (User)this.userDao.load(User.class, Integer.valueOf(userId));
/*     */   }
/*     */
/*     */   public List<Role> listUserRoles(int userId)
/*     */   {
/* 124 */     return this.roleDao.listUserRoles(userId);
/*     */   }
/*     */
/*     */   public List<Group> listUserGroups(int userId)
/*     */   {
/* 129 */     return this.groupDao.listUserGroups(userId);
/*     */   }
/*     */
/*     */   private void addUserRole(User user, int roleId)
/*     */   {
/* 134 */     Role role = (Role)this.roleDao.load(Role.class, Integer.valueOf(roleId));
/* 135 */     if (null == role) {
/* 136 */       throw new CmsException("要添加的角色不存在!");
/*     */     }
/* 138 */     this.userDao.addUserRole(user, role);
/*     */   }
/*     */
/*     */   private void addUserGroup(User user, int groupId)
/*     */   {
/* 143 */     Group group = (Group)this.groupDao.load(Group.class, Integer.valueOf(groupId));
/* 144 */     if (null == group) {
/* 145 */       throw new CmsException("要添加的组对象不存在");
/*     */     }
/* 147 */     this.userDao.addUserGroup(user, group);
/*     */   }
/*     */
/*     */   public List<Integer> listUserRoleIds(int userId)
/*     */   {
/* 152 */     return this.roleDao.listUserRoleIds(userId);
/*     */   }
/*     */
/*     */   public List<Integer> listUserGroupIds(int userId)
/*     */   {
/* 157 */     return this.groupDao.listUserGroupIds(userId);
/*     */   }
/*     */
/*     */   public List<User> listGroupUsers(int groupId)
/*     */   {
/* 162 */     return this.userDao.listGroupUsers(groupId);
/*     */   }
/*     */
/*     */   public List<User> listRoleUsers(int roleId)
/*     */   {
/* 167 */     return this.userDao.listRoleUsers(roleId);
/*     */   }
/*     */
/*     */   public User login(String username, String password)
/*     */   {
/* 172 */     User user = this.userDao.loadByUsername(username);
/* 173 */     if (null == user) {
/* 174 */       throw new CmsException("用户名或密码错误!");
/*     */     }
/* 176 */     if (!SecurityUtil.md5(username, password).equals(user.getPassword())) {
/* 177 */       throw new CmsException("用户名或密码错误!");
/*     */     }
/* 179 */     if (0 == user.getStatus()) {
/* 180 */       throw new CmsException("用户已经停用，请与管理员联系!");
/*     */     }
/* 182 */     return user;
/*     */   }
/*     */
/*     */   public void updateSelf(User user)
/*     */   {
/* 187 */     this.userDao.update(user);
/*     */   }
/*     */
/*     */   public void updatePwd(int id, String oldPwd, String password)
/*     */   {
/* 192 */     User user = (User)this.userDao.load(User.class, Integer.valueOf(id));
/* 193 */     if (!SecurityUtil.md5(user.getUsername(), oldPwd).equals(user.getPassword())) {
/* 194 */       throw new CmsException("原始密码输入不正确!");
/*     */     }
/* 196 */     user.setPassword(SecurityUtil.md5(user.getUsername(), password));
/* 197 */     this.userDao.update(user);
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-user\0.0.1-SNAPSHOT\cms-user-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.impl.UserServiceImpl
 * JD-Core Version:    0.6.2
 */