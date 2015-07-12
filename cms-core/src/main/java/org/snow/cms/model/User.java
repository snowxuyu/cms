/*     */ package org.snow.cms.model;
/*     */ 
/*     */ import java.sql.Timestamp;
/*     */ 
/*     */ public class User
/*     */ {
/*     */   private int id;
/*     */   private String username;
/*     */   private String password;
/*     */   private String nickname;
/*     */   private String phone;
/*     */   private String email;
/*     */   private int status;
/*     */   private Timestamp createDate;
/*     */ 
/*     */   public int getId()
/*     */   {
/*  48 */     return this.id;
/*     */   }
/*     */   public void setId(int id) {
/*  51 */     this.id = id;
/*     */   }
/*     */   public String getUsername() {
/*  54 */     return this.username;
/*     */   }
/*     */   public void setUsername(String username) {
/*  57 */     this.username = username;
/*     */   }
/*     */   public String getPassword() {
/*  60 */     return this.password;
/*     */   }
/*     */   public void setPassword(String password) {
/*  63 */     this.password = password;
/*     */   }
/*     */   public String getNickname() {
/*  66 */     return this.nickname;
/*     */   }
/*     */   public void setNickname(String nickname) {
/*  69 */     this.nickname = nickname;
/*     */   }
/*     */   public String getPhone() {
/*  72 */     return this.phone;
/*     */   }
/*     */   public void setPhone(String phone) {
/*  75 */     this.phone = phone;
/*     */   }
/*     */   public String getEmail() {
/*  78 */     return this.email;
/*     */   }
/*     */   public void setEmail(String email) {
/*  81 */     this.email = email;
/*     */   }
/*     */   public int getStatus() {
/*  84 */     return this.status;
/*     */   }
/*     */   public void setStatus(int status) {
/*  87 */     this.status = status;
/*     */   }
/*     */   public Timestamp getCreateDate() {
/*  90 */     return this.createDate;
/*     */   }
/*     */   public void setCreateDate(Timestamp createDate) {
/*  93 */     this.createDate = createDate;
/*     */   }
/*     */ 
/*     */   public User(int id, String username, String password, String nickname, String phone, String email, int status, Timestamp createDate) {
/*  97 */     this.id = id;
/*  98 */     this.username = username;
/*  99 */     this.password = password;
/* 100 */     this.nickname = nickname;
/* 101 */     this.phone = phone;
/* 102 */     this.email = email;
/* 103 */     this.status = status;
/* 104 */     this.createDate = createDate;
/*     */   }
/*     */ 
/*     */   public User() {
/*     */   }
/*     */ 
/*     */   public User(int id, String username, String password, String nickname, String phone, String email, int status) {
/* 111 */     this.id = id;
/* 112 */     this.username = username;
/* 113 */     this.password = password;
/* 114 */     this.nickname = nickname;
/* 115 */     this.phone = phone;
/* 116 */     this.email = email;
/* 117 */     this.status = status;
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.User
 * JD-Core Version:    0.6.2
 */