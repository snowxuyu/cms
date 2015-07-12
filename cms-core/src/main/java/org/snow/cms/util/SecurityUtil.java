/*    */ package org.snow.cms.util;
/*    */ 
/*    */ import java.math.BigInteger;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ public class SecurityUtil
/*    */ {
/*    */   public static String md5(String password)
/*    */   {
/* 19 */     MessageDigest md = null;
/*    */     try
/*    */     {
/* 22 */       md = MessageDigest.getInstance("MD5");
/* 23 */       md.update(password.getBytes());
/*    */     }
/*    */     catch (NoSuchAlgorithmException e) {
/* 26 */       System.out.println("加密失败!" + e.getMessage());
/* 27 */       e.printStackTrace();
/*    */     }
/* 29 */     return new BigInteger(1, md.digest()).toString(16);
/*    */   }
/*    */ 
/*    */   public static String md5(String username, String password)
/*    */   {
/* 35 */     MessageDigest md = null;
/*    */     try
/*    */     {
/* 38 */       md = MessageDigest.getInstance("MD5");
/* 39 */       md.update(username.getBytes());
/* 40 */       md.update(password.getBytes());
/*    */     }
/*    */     catch (NoSuchAlgorithmException e) {
/* 43 */       System.out.println("加密失败!" + e.getMessage());
/* 44 */       e.printStackTrace();
/*    */     }
/* 46 */     return new BigInteger(1, md.digest()).toString(16);
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.SecurityUtil
 * JD-Core Version:    0.6.2
 */