/*    */ package org.snow.cms.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ import org.snow.cms.dao.IRoleDao;
/*    */ import org.snow.cms.dao.IUserDao;
/*    */ import org.snow.cms.model.Role;
/*    */ import org.snow.cms.service.IRoleService;
/*    */ import org.snow.cms.util.CmsException;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("roleService")
/*    */ public class RoleServiceImpl
/*    */   implements IRoleService
/*    */ {
/*    */ 
/*    */   @Inject
/*    */   private IRoleDao roleDao;
/*    */ 
/*    */   @Inject
/*    */   private IUserDao userDao;
/*    */ 
/*    */   public void add(Role role)
/*    */   {
/* 22 */     this.roleDao.add(role);
/*    */   }
/*    */ 
/*    */   public void update(Role role)
/*    */   {
/* 27 */     this.roleDao.update(role);
/*    */   }
/*    */ 
/*    */   public void delete(int roleId)
/*    */   {
/* 32 */     List users = this.userDao.listRoleUsers(roleId);
/* 33 */     if ((null != users) && (users.size() > 0)) {
/* 34 */       throw new CmsException("要删除的角色中有用户存在，不能删除!");
/*    */     }
/* 36 */     this.roleDao.delete(Role.class, Integer.valueOf(roleId));
/*    */   }
/*    */ 
/*    */   public Role load(int roleId)
/*    */   {
/* 41 */     return (Role)this.roleDao.load(Role.class, Integer.valueOf(roleId));
/*    */   }
/*    */ 
/*    */   public List<Role> listRole()
/*    */   {
/* 46 */     return this.roleDao.listRole();
/*    */   }
/*    */ 
/*    */   public void deleteRoleUsers(int roleId)
/*    */   {
/* 51 */     this.roleDao.deleteRoleUsers(roleId);
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-user\0.0.1-SNAPSHOT\cms-user-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.impl.RoleServiceImpl
 * JD-Core Version:    0.6.2
 */