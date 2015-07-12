/*     */ package org.snow.cms.model;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ 
/*     */ public class Topic
/*     */ {
/*     */   private int id;
/*     */   private String title;
/*     */   private String keyword;
/*     */   private int status;
/*     */   private int recommend;
/*     */   private String content;
/*     */   private String summary;
/*     */   private int channelPicId;
/*     */   private String author;
/*     */   private String cname;
/*     */   private Timestamp publishDate;
/*     */   private Timestamp createDate;
/*     */   private Channel channel;
/*     */   private User user;
/*     */ 
/*     */   public int getId()
/*     */   {
/*  77 */     return this.id;
/*     */   }
/*     */   public void setId(int id) {
/*  80 */     this.id = id;
/*     */   }
/*     */   public String getTitle() {
/*  83 */     return this.title;
/*     */   }
/*     */   public void setTitle(String title) {
/*  86 */     this.title = title;
/*     */   }
/*     */   public String getKeyword() {
/*  89 */     return this.keyword;
/*     */   }
/*     */   public void setKeyword(String keyword) {
/*  92 */     this.keyword = keyword;
/*     */   }
/*     */   public int getStatus() {
/*  95 */     return this.status;
/*     */   }
/*     */   public void setStatus(int status) {
/*  98 */     this.status = status;
/*     */   }
/*     */   public int getRecommend() {
/* 101 */     return this.recommend;
/*     */   }
/*     */   public void setRecommend(int recommend) {
/* 104 */     this.recommend = recommend;
/*     */   }
/*     */   public String getContent() {
/* 107 */     return this.content;
/*     */   }
/*     */   public void setContent(String content) {
/* 110 */     this.content = content;
/*     */   }
/*     */   public String getSummary() {
/* 113 */     return this.summary;
/*     */   }
/*     */   public void setSummary(String summary) {
/* 116 */     this.summary = summary;
/*     */   }
/*     */   public int getChannelPicId() {
/* 119 */     return this.channelPicId;
/*     */   }
/*     */   public void setChannelPicId(int channelPicId) {
/* 122 */     this.channelPicId = channelPicId;
/*     */   }
/*     */   public String getAuthor() {
/* 125 */     return this.author;
/*     */   }
/*     */   public void setAuthor(String author) {
/* 128 */     this.author = author;
/*     */   }
/*     */   public Timestamp getPublishDate() {
/* 131 */     return this.publishDate;
/*     */   }
/*     */   public void setPublishDate(Timestamp publishDate) {
/* 134 */     this.publishDate = publishDate;
/*     */   }
/*     */   public Timestamp getCreateDate() {
/* 137 */     return this.createDate;
/*     */   }
/*     */   public void setCreateDate(Timestamp createDate) {
/* 140 */     this.createDate = createDate;
/*     */   }
/*     */   public Channel getChannel() {
/* 143 */     return this.channel;
/*     */   }
/*     */   public void setChannel(Channel channel) {
/* 146 */     this.channel = channel;
/*     */   }
/*     */   public User getUser() {
/* 149 */     return this.user;
/*     */   }
/*     */   public void setUser(User user) {
/* 152 */     this.user = user;
/*     */   }
/*     */   public String getCname() {
/* 155 */     return this.cname;
/*     */   }
/*     */   public void setCname(String cname) {
/* 158 */     this.cname = cname;
/*     */   }
/*     */ 
/*     */   public Topic(int id, String title, String keyword, int status, int recommend, Timestamp publishDate, String author, String cname)
/*     */   {
/* 164 */     this.id = id;
/* 165 */     this.title = title;
/* 166 */     this.keyword = keyword;
/* 167 */     this.status = status;
/* 168 */     this.recommend = recommend;
/* 169 */     this.publishDate = publishDate;
/* 170 */     this.author = author;
/* 171 */     this.cname = cname;
/*     */   }
/*     */ 
/*     */   public Topic(int id, String title, String keyword, int status, int recommend, String author)
/*     */   {
/* 177 */     this.id = id;
/* 178 */     this.title = title;
/* 179 */     this.keyword = keyword;
/* 180 */     this.status = status;
/* 181 */     this.recommend = recommend;
/* 182 */     this.author = author;
/*     */   }
/*     */ 
/*     */   public Topic()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.Topic
 * JD-Core Version:    0.6.2
 */