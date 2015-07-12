/*    */ package org.snow.cms.model;
/*    */ 
/*    */ public enum ChannelType
/*    */ {
/*  4 */   NAV_CHANNEL("导航栏目"), TOPIC_LIST("文章列表栏目"), 
/*  5 */   TOPIC_CONTENT("文章内容栏目"), IMG_LIST("图片列表栏目");
/*    */ 
/*    */   private String name;
/*    */ 
/*    */   private ChannelType(String name) {
/* 10 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 14 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 17 */     this.name = name;
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.ChannelType
 * JD-Core Version:    0.6.2
 */