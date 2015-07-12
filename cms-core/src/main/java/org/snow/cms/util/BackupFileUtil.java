/*     */ package org.snow.cms.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.snow.cms.model.BackupFile;
/*     */ 
/*     */ public class BackupFileUtil
/*     */ {
/*     */   private static BackupFileUtil util;
/*     */   private String backupFile;
/*     */   private static String realPath;
/*     */   private String database;
/*     */   private String username;
/*     */   private String password;
/*     */   private List<String> backupFiles;
/*     */   private static final String DATABASE_NAME = "database";
/*     */   private static final String BACKUP_NAME = "backup";
/*     */ 
/*     */   private BackupFileUtil()
/*     */     throws IOException
/*     */   {
/*  27 */     Properties prop = new Properties();
/*  28 */     prop.load(BackupFileUtil.class.getClassLoader().getResourceAsStream("backup.properties"));
/*  29 */     this.database = prop.getProperty("database");
/*  30 */     this.username = prop.getProperty("database_username");
/*  31 */     this.password = prop.getProperty("database_password");
/*  32 */     this.backupFile = prop.getProperty("backupFile");
/*  33 */     File bf = new File(realPath + File.separator + this.backupFile);
/*  34 */     if (!bf.exists()) bf.mkdirs();
/*  35 */     this.backupFiles = new ArrayList();
/*     */ 
/*  37 */     String fs = prop.getProperty("file");
/*  38 */     String[] fas = fs.split(",");
/*  39 */     for (String f : fas)
/*  40 */       this.backupFiles.add(f);
/*     */   }
/*     */ 
/*     */   public static BackupFileUtil getInstance(String realPath)
/*     */   {
/*     */     try
/*     */     {
/*  47 */       realPath = realPath;
/*  48 */       if (util == null) util = new BackupFileUtil();
/*  49 */       return util;
/*     */     } catch (IOException e) {
/*  51 */       e.printStackTrace();
/*     */     }
/*  53 */     return null;
/*     */   }
/*     */ 
/*     */   public List<BackupFile> listBackups()
/*     */   {
/*  61 */     File[] fs = new File(realPath + File.separator + this.backupFile).listFiles(new FileFilter() {
/*     */       public boolean accept(File pathname) {
/*  63 */         if (pathname.isDirectory())
/*  64 */           return false;
/*  65 */         return true;
/*     */       }
/*     */     });
/*  68 */     List bs = new ArrayList();
/*  69 */     BackupFile bf = null;
/*  70 */     for (File f : fs) {
/*  71 */       bf = new BackupFile();
/*  72 */       bf.setName(f.getName());
/*  73 */       bf.setSize((int)(f.length() / 1024L));
/*  74 */       bf.setTime(new Date(f.lastModified()));
/*  75 */       bf.setFiletype(f.getName().substring(f.getName().lastIndexOf(".") + 1));
/*  76 */       bs.add(bf);
/*     */     }
/*  78 */     Collections.sort(bs);
/*  79 */     return bs;
/*     */   }
/*     */ 
/*     */   public void backup(String name) {
/*  83 */     String bp = realPath + File.separator + this.backupFile + File.separator + "backup";
/*     */     try
/*     */     {
/*  86 */       File bpf = new File(bp);
/*  87 */       bpf.mkdirs();
/*     */ 
/*  89 */       MySQLUtil msu = MySQLUtil.getInstance();
/*  90 */       msu.setCfg("database", bp, this.database, this.username, this.password);
/*  91 */       msu.backup();
/*     */ 
/*  93 */       for (String f : this.backupFiles) {
/*  94 */         String src = realPath + File.separator + f;
/*  95 */         String dest = bp + f;
/*  96 */         FileUtils.copyDirectory(new File(src), new File(dest));
/*     */       }
/*     */ 
/*  99 */       TarAndGzipUtil tagu = TarAndGzipUtil.getInstance();
/* 100 */       tagu.tarFile(bp, realPath + File.separator + this.backupFile + File.separator + new Date().getTime() + "_" + name + ".tar");
/*     */     } catch (IOException e) {
/* 102 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 105 */         FileUtils.deleteDirectory(new File(bp));
/*     */       } catch (IOException e) {
/* 107 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void resume(String name)
/*     */   {
/* 114 */     String op = realPath + File.separator + this.backupFile + File.separator + "backup";
/*     */     try
/*     */     {
/* 117 */       String fp = realPath + File.separator + this.backupFile + File.separator + name;
/* 118 */       TarAndGzipUtil tagu = TarAndGzipUtil.getInstance();
/* 119 */       tagu.unTarFile(new File(fp), realPath + File.separator + this.backupFile);
/*     */ 
/* 121 */       for (String f : this.backupFiles)
/*     */       {
/* 123 */         String src = op + f;
/* 124 */         String dest = realPath + File.separator + f;
/* 125 */         File dfd = new File(dest);
/* 126 */         if (!dfd.exists()) dfd.mkdirs();
/* 127 */         FileUtils.deleteDirectory(dfd);
/* 128 */         FileUtils.copyDirectory(new File(src), dfd);
/*     */       }
/*     */ 
/* 131 */       MySQLUtil msu = MySQLUtil.getInstance();
/* 132 */       msu.setCfg("database", op, this.database, this.username, this.password);
/* 133 */       msu.resume();
/*     */     } catch (IOException e) {
/* 135 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 138 */         FileUtils.deleteDirectory(new File(op));
/*     */       } catch (IOException e) {
/* 140 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(String name)
/*     */   {
/* 150 */     File f = new File(realPath + File.separator + this.backupFile + File.separator + name);
/* 151 */     f.delete();
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.BackupFileUtil
 * JD-Core Version:    0.6.2
 */