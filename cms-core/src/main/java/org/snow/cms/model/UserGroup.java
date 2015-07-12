/*    */ package org.snow.cms.model;
/*    */ 
/*    */ public class UserGroup
/*    */ {
/*    */   private int id;
/*    */   private User user;
/*    */   private Group group;
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
/*    */   public Group getGroup() {
/* 34 */     return this.group;
/*    */   }
/*    */   public void setGroup(Group group) {
/* 37 */     this.group = group;
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.UserGroup
 * JD-Core Version:    0.6.2
 */