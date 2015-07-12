/*     */ package org.snow.cms.util;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class Chptcha
/*     */ {
/*     */   private int width;
/*     */   private int heigh;
/*     */   private int num;
/*     */   private String code;
/*  22 */   private static final Random rdm = new Random();
/*     */   private static Chptcha chptcha;
/*     */ 
/*     */   private Chptcha()
/*     */   {
/*  25 */     this.code = "0123456789abcdefghijklmnopqretuvwxwzABCDEFGHIJKLMNOPQRSTUVWXYZ";
/*  26 */     this.num = 4;
/*     */   }
/*     */ 
/*     */   public static Chptcha getInstance() {
/*  30 */     if (chptcha == null) chptcha = new Chptcha();
/*  31 */     return chptcha;
/*     */   }
/*     */ 
/*     */   public int getWidth() {
/*  35 */     return this.width;
/*     */   }
/*     */ 
/*     */   public void setWidth(int width) {
/*  39 */     this.width = width;
/*     */   }
/*     */ 
/*     */   public int getHeigh() {
/*  43 */     return this.heigh;
/*     */   }
/*     */ 
/*     */   public void setHeigh(int heigh) {
/*  47 */     this.heigh = heigh;
/*     */   }
/*     */ 
/*     */   public int getNum() {
/*  51 */     return this.num;
/*     */   }
/*     */ 
/*     */   public void setNum(int num) {
/*  55 */     this.num = num;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/*  59 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/*  63 */     this.code = code;
/*     */   }
/*     */   public void set(int width, int height, int num, String code) {
/*  66 */     this.width = width;
/*  67 */     this.heigh = height;
/*  68 */     setNum(num);
/*  69 */     setCode(code);
/*     */   }
/*     */ 
/*     */   public void set(int width, int height) {
/*  73 */     this.width = width;
/*  74 */     this.heigh = height;
/*     */   }
/*     */ 
/*     */   public String generateCheckcode()
/*     */   {
/*  79 */     StringBuffer cc = new StringBuffer();
/*  80 */     for (int i = 0; i < this.num; i++) {
/*  81 */       cc.append(this.code.charAt(rdm.nextInt(this.code.length())));
/*     */     }
/*  83 */     return cc.toString();
/*     */   }
/*     */ 
/*     */   public BufferedImage generateCheckImg(String checkcode)
/*     */   {
/*  89 */     BufferedImage img = new BufferedImage(this.width, this.heigh, 1);
/*     */ 
/*  91 */     Graphics2D graphic = img.createGraphics();
/*  92 */     graphic.setColor(Color.WHITE);
/*  93 */     graphic.fillRect(0, 0, this.width, this.heigh);
/*  94 */     graphic.setColor(Color.BLACK);
/*  95 */     graphic.drawRect(0, 0, this.width - 1, this.heigh - 1);
/*  96 */     Font font = new Font("宋体", 3, (int)(this.heigh * 0.8D));
/*  97 */     graphic.setFont(font);
/*  98 */     for (int i = 0; i < this.num; i++) {
/*  99 */       graphic.setColor(new Color(rdm.nextInt(200), rdm.nextInt(200), rdm.nextInt(200)));
/* 100 */       graphic.drawString(String.valueOf(checkcode.charAt(i)), i * (this.width / this.num) + 4, (int)(this.heigh * 0.8D));
/*     */     }
/*     */ 
/* 104 */     for (int i = 0; i < this.width + this.heigh; i++) {
/* 105 */       graphic.setColor(new Color(rdm.nextInt(255), rdm.nextInt(255), rdm.nextInt(255)));
/* 106 */       graphic.drawOval(rdm.nextInt(this.width), rdm.nextInt(this.heigh), 1, 1);
/*     */     }
/*     */ 
/* 110 */     for (int i = 0; i < 3; i++) {
/* 111 */       graphic.setColor(new Color(rdm.nextInt(255), rdm.nextInt(255), rdm.nextInt(255)));
/* 112 */       graphic.drawLine(rdm.nextInt(this.width), rdm.nextInt(this.heigh), rdm.nextInt(this.width), rdm.nextInt(this.heigh));
/*     */     }
/* 114 */     return img;
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.Chptcha
 * JD-Core Version:    0.6.2
 */