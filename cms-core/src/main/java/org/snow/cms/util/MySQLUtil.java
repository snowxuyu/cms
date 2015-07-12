/*    */ package org.snow.cms.util;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.OutputStreamWriter;
/*    */ 
/*    */ public class MySQLUtil
/*    */ {
/* 20 */   private static MySQLUtil util = null;
/*    */   private String filename;
/*    */   private String backupDir;
/*    */   private String database;
/*    */   private String username;
/*    */   private String password;
/*    */ 
/*    */   public static MySQLUtil getInstance()
/*    */   {
/* 40 */     if (util == null) util = new MySQLUtil();
/* 41 */     return util;
/*    */   }
/*    */ 
/*    */   public void setCfg(String filename, String backupDir, String database, String username, String password) {
/* 45 */     this.filename = filename;
/* 46 */     this.backupDir = backupDir;
/* 47 */     this.database = database;
/* 48 */     this.username = username;
/* 49 */     this.password = password;
/*    */   }
/*    */ 
/*    */   public void backup()
/*    */   {
/* 55 */     BufferedReader br = null;
/* 56 */     BufferedWriter bw = null;
/*    */     try {
/* 58 */       String cmd = "cmd /c mysqldump -u" + this.username + " -p" + this.password + " " + this.database;
/* 59 */       Process proc = Runtime.getRuntime().exec(cmd);
/* 60 */       br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
/* 61 */       bw = new BufferedWriter(new FileWriter(this.backupDir + File.separator + this.filename + ".sql"));
/*    */ 
/* 63 */       System.out.println(this.backupDir + File.separator + this.filename);
/* 64 */       String str = null;
/* 65 */       while ((str = br.readLine()) != null) {
/* 66 */         bw.write(str);
/* 67 */         bw.newLine();
/*    */       }
/*    */     } catch (IOException e) {
/* 70 */       e.printStackTrace();
/*    */     } finally {
/*    */       try {
/* 73 */         if (br != null) br.close(); 
/*    */       }
/* 75 */       catch (IOException e) { e.printStackTrace(); }
/*    */       try
/*    */       {
/* 78 */         if (bw != null) bw.close(); 
/*    */       }
/* 80 */       catch (IOException e) { e.printStackTrace(); }
/*    */ 
/*    */     }
/*    */   }
/*    */ 
/*    */   public void resume()
/*    */   {
/* 88 */     BufferedReader br = null;
/* 89 */     BufferedWriter bw = null;
/*    */     try {
/* 91 */       String cmd = "cmd /c mysql -u" + this.username + " -p" + this.password + " " + this.database;
/* 92 */       Process proc = Runtime.getRuntime().exec(cmd);
/* 93 */       bw = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));
/* 94 */       br = new BufferedReader(new FileReader(this.backupDir + File.separator + this.filename + ".sql"));
/* 95 */       String str = null;
/* 96 */       while ((str = br.readLine()) != null) {
/* 97 */         bw.write(str);
/* 98 */         bw.newLine();
/*    */       }
/* 100 */       br.close();
/* 101 */       bw.close();
/*    */     } catch (IOException e) {
/* 103 */       e.printStackTrace();
/*    */     } finally {
/*    */       try {
/* 106 */         if (br != null) br.close(); 
/*    */       }
/* 108 */       catch (IOException e) { e.printStackTrace(); }
/*    */       try
/*    */       {
/* 111 */         if (bw != null) bw.close(); 
/*    */       }
/* 113 */       catch (IOException e) { e.printStackTrace(); }
/*    */ 
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.MySQLUtil
 * JD-Core Version:    0.6.2
 */