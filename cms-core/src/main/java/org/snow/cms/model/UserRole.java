/*    */ package org.snow.cms.model;
/*    */ 
/*    */ public class UserRole
/*    */ {
/*    */   private int id;
/*    */   private User user;
/*    */   private Role role;
/*    */ 
/*    */   public int getId()
/*    */   {
/* 22 */     return this.id;
/*    */   }
/*    */   public void setId(int id) {
/* 25 */     this.id = id;
/*    */   }
/*    */   public User getUser() {
/* 28 */     return this.user;
/*    */   }
/*    */   public void setUser(User user) {
/* 31 */     this.user = user;
/*    */   }
/*    */   public Role getRole() {
/* 34 */     return this.role;
/*    */   }
/*    */   public void setRole(Role role) {
/* 37 */     this.role = role;
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.UserRole
 * JD-Core Version:    0.6.2
 */