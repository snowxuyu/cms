/*    */ package org.snow.cms.model;
/*    */ 
/*    */ public class ChannelTree
/*    */ {
/*    */   private Integer id;
/*    */   private String name;
/*    */   private Integer pid;
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 16 */     return this.id;
/*    */   }
/*    */   public void setId(Integer id) {
/* 19 */     this.id = id;
/*    */   }
/*    */   public String getName() {
/* 22 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 25 */     this.name = name;
/*    */   }
/*    */   public Integer getPid() {
/* 28 */     return this.pid;
/*    */   }
/*    */   public void setPid(Integer pid) {
/* 31 */     this.pid = pid;
/*    */   }
/*    */   public ChannelTree(Integer id, String name, Integer pid) {
/* 34 */     this.id = id;
/* 35 */     this.name = name;
/* 36 */     this.pid = pid;
/*    */   }
/*    */ 
/*    */   public ChannelTree()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.ChannelTree
 * JD-Core Version:    0.6.2
 */