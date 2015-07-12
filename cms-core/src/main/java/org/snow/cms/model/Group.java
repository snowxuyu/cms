/*    */ package org.snow.cms.model;
/*    */ 
/*    */ public class Group
/*    */ {
/*    */   private int id;
/*    */   private String name;
/*    */   private String descr;
/*    */ 
/*    */   public int getId()
/*    */   {
/* 25 */     return this.id;
/*    */   }
/*    */   public void setId(int id) {
/* 28 */     this.id = id;
/*    */   }
/*    */   public String getName() {
/* 31 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 34 */     this.name = name;
/*    */   }
/*    */   public String getDescr() {
/* 37 */     return this.descr;
/*    */   }
/*    */   public void setDescr(String descr) {
/* 40 */     this.descr = descr;
/*    */   }
/*    */   public Group(int id, String name) {
/* 43 */     this.id = id;
/* 44 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public Group()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.Group
 * JD-Core Version:    0.6.2
 */