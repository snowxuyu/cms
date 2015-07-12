/*     */ package org.snow.cms.model;
/*     */ 
/*     */ public class Channel
/*     */ {
/*     */   public static final String ROOT_NAME = "网站系统栏目";
/*     */   public static final int ROOT_ID = 0;
/*     */   public static final int ROOT_PID = -1;
/*     */   private int id;
/*     */   private String name;
/*     */   private int customLink;
/*     */   private String customLinkUrl;
/*     */   private int type;
/*     */   private int isIndex;
/*     */   private int isTopNav;
/*     */   private int recommend;
/*     */   private int status;
/*     */   private int orders;
/*     */   private Channel parent;
/*     */ 
/*     */   public int getId()
/*     */   {
/*  66 */     return this.id;
/*     */   }
/*     */   public void setId(int id) {
/*  69 */     this.id = id;
/*     */   }
/*     */   public String getName() {
/*  72 */     return this.name;
/*     */   }
/*     */   public void setName(String name) {
/*  75 */     this.name = name;
/*     */   }
/*     */   public int getCustomLink() {
/*  78 */     return this.customLink;
/*     */   }
/*     */   public void setCustomLink(int customLink) {
/*  81 */     this.customLink = customLink;
/*     */   }
/*     */   public String getCustomLinkUrl() {
/*  84 */     return this.customLinkUrl;
/*     */   }
/*     */   public void setCustomLinkUrl(String customLinkUrl) {
/*  87 */     this.customLinkUrl = customLinkUrl;
/*     */   }
/*     */   public int getType() {
/*  90 */     return this.type;
/*     */   }
/*     */   public void setType(int type) {
/*  93 */     this.type = type;
/*     */   }
/*     */   public int getIsIndex() {
/*  96 */     return this.isIndex;
/*     */   }
/*     */   public void setIsIndex(int isIndex) {
/*  99 */     this.isIndex = isIndex;
/*     */   }
/*     */   public int getIsTopNav() {
/* 102 */     return this.isTopNav;
/*     */   }
/*     */   public void setIsTopNav(int isTopNav) {
/* 105 */     this.isTopNav = isTopNav;
/*     */   }
/*     */   public int getRecommend() {
/* 108 */     return this.recommend;
/*     */   }
/*     */   public void setRecommend(int recommend) {
/* 111 */     this.recommend = recommend;
/*     */   }
/*     */   public int getStatus() {
/* 114 */     return this.status;
/*     */   }
/*     */   public void setStatus(int status) {
/* 117 */     this.status = status;
/*     */   }
/*     */   public int getOrders() {
/* 120 */     return this.orders;
/*     */   }
/*     */   public void setOrders(int orders) {
/* 123 */     this.orders = orders;
/*     */   }
/*     */   public Channel getParent() {
/* 126 */     return this.parent;
/*     */   }
/*     */   public void setParent(Channel parent) {
/* 129 */     this.parent = parent;
/*     */   }
/*     */   public Channel() {
/*     */   }
/*     */ 
/*     */   public Channel(int id, String name) {
/* 135 */     this.id = id;
/* 136 */     this.name = name;
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.Channel
 * JD-Core Version:    0.6.2
 */