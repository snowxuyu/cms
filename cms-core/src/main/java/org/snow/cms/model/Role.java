/*    */ package org.snow.cms.model;
/*    */ 
/*    */ public class Role
/*    */ {
/*    */   private int id;
/*    */   private String name;
/*    */   private RoleType roleType;
/*    */ 
/*    */   public int getId()
/*    */   {
/* 26 */     return this.id;
/*    */   }
/*    */   public void setId(int id) {
/* 29 */     this.id = id;
/*    */   }
/*    */   public String getName() {
/* 32 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 35 */     this.name = name;
/*    */   }
/*    */   public RoleType getRoleType() {
/* 38 */     return this.roleType;
/*    */   }
/*    */   public void setRoleType(RoleType roleType) {
/* 41 */     this.roleType = roleType;
/*    */   }
/*    */   public Role(int id, String name, RoleType roleType) {
/* 44 */     this.id = id;
/* 45 */     this.name = name;
/* 46 */     this.roleType = roleType;
/*    */   }
/*    */ 
/*    */   public Role()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.Role
 * JD-Core Version:    0.6.2
 */