/*     */ package org.snow.cms.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import java.util.zip.GZIPOutputStream;
/*     */ import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
/*     */ import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
/*     */ import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
/*     */ import org.apache.commons.compress.utils.IOUtils;
/*     */ 
/*     */ public class TarAndGzipUtil
/*     */ {
/*     */   private static TarAndGzipUtil util;
/*     */ 
/*     */   public static TarAndGzipUtil getInstance()
/*     */   {
/*  21 */     if (util == null) util = new TarAndGzipUtil();
/*  22 */     return util;
/*     */   }
/*     */ 
/*     */   public void tarFile(String path)
/*     */   {
/*  27 */     String tarFile = path + ".tar";
/*  28 */     tarFile(path, tarFile);
/*     */   }
/*     */ 
/*     */   public void tarFile(String path, String tarFile) {
/*  32 */     TarArchiveOutputStream taos = null;
/*     */     try {
/*  34 */       File f = new File(path);
/*  35 */       int len = f.getParent().length();
/*  36 */       taos = new TarArchiveOutputStream(new FileOutputStream(tarFile));
/*  37 */       taos.setLongFileMode(2);
/*  38 */       tarFile(new File(path), taos, len);
/*     */     } catch (FileNotFoundException e) {
/*  40 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/*  43 */         if (taos != null) taos.close(); 
/*     */       }
/*  45 */       catch (IOException e) { e.printStackTrace(); }
/*     */ 
/*     */     }
/*  48 */     gzipFile(new File(tarFile));
/*     */   }
/*     */ 
/*     */   public void unTarFile(File file, String path) {
/*  52 */     TarArchiveInputStream tais = null;
/*  53 */     File tf = null;
/*     */     try {
/*  55 */       tf = unGzipFile(file);
/*  56 */       tais = new TarArchiveInputStream(new FileInputStream(tf));
/*  57 */       TarArchiveEntry tae = null;
/*  58 */       while ((tae = tais.getNextTarEntry()) != null)
/*  59 */         if (!tae.isDirectory()) {
/*  60 */           String name = path + File.separator + tae.getName();
/*  61 */           FileOutputStream fos = null;
/*  62 */           File ff = new File(name);
/*  63 */           if (!ff.getParentFile().exists()) ff.getParentFile().mkdirs(); try
/*     */           {
/*  65 */             fos = new FileOutputStream(ff);
/*  66 */             IOUtils.copy(tais, fos);
/*     */           } catch (Exception e) {
/*  68 */             e.printStackTrace();
/*     */           } finally {
/*  70 */             if (fos != null) fos.close(); 
/*     */           }
/*     */         }
/*     */     }
/*     */     catch (FileNotFoundException e)
/*     */     {
/*  75 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/*  77 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/*  80 */         if (tais != null) tais.close(); 
/*     */       }
/*  82 */       catch (IOException e) { e.printStackTrace(); }
/*     */ 
/*  84 */       if (tf != null) {
/*  85 */         tf.delete();
/*  86 */         tf.deleteOnExit();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public File unGzipFile(File file) {
/*  92 */     GZIPInputStream gis = null;
/*  93 */     FileOutputStream fos = null;
/*     */     try {
/*  95 */       gis = new GZIPInputStream(new FileInputStream(file));
/*  96 */       String path = file.getAbsolutePath();
/*  97 */       path = path.substring(0, path.lastIndexOf("."));
/*     */ 
/*  99 */       File f = new File(path);
/* 100 */       fos = new FileOutputStream(f);
/* 101 */       IOUtils.copy(gis, fos);
/* 102 */       return f;
/*     */     } catch (FileNotFoundException e) {
/* 104 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 106 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 109 */         if (gis != null) gis.close(); 
/*     */       }
/* 111 */       catch (IOException e) { e.printStackTrace(); }
/*     */       try
/*     */       {
/* 114 */         if (fos != null) fos.close(); 
/*     */       }
/* 116 */       catch (IOException e) { e.printStackTrace(); }
/*     */ 
/*     */     }
/*     */ 
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */   public void gzipFile(File file) {
/* 124 */     GZIPOutputStream gos = null;
/* 125 */     FileInputStream fis = null;
/*     */     try {
/* 127 */       gos = new GZIPOutputStream(new FileOutputStream(file.getAbsolutePath() + ".gz"));
/* 128 */       fis = new FileInputStream(file);
/* 129 */       IOUtils.copy(fis, gos);
/*     */     } catch (FileNotFoundException e) {
/* 131 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 133 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 136 */         if (gos != null) gos.close(); 
/*     */       }
/* 138 */       catch (IOException e) { e.printStackTrace(); }
/*     */       try
/*     */       {
/* 141 */         if (fis != null) fis.close(); 
/*     */       }
/* 143 */       catch (IOException e) { e.printStackTrace(); }
/*     */ 
/* 145 */       file.delete();
/*     */     }
/*     */   }
/*     */ 
/*     */   private void tarFile(File file, TarArchiveOutputStream taos, int len) {
/* 150 */     if (file.isDirectory()) {
/* 151 */       File[] fs = file.listFiles();
/* 152 */       for (File f : fs)
/* 153 */         tarFile(f, taos, len);
/*     */     }
/*     */     else {
/* 156 */       FileInputStream fis = null;
/*     */       try {
/* 158 */         TarArchiveEntry tae = new TarArchiveEntry(file.getParent().substring(len) + File.separator + file.getName());
/* 159 */         tae.setSize(file.length());
/* 160 */         fis = new FileInputStream(file);
/* 161 */         taos.putArchiveEntry(tae);
/* 162 */         IOUtils.copy(fis, taos);
/*     */       } catch (FileNotFoundException e) {
/* 164 */         e.printStackTrace();
/*     */       } catch (IOException e) {
/* 166 */         e.printStackTrace();
/*     */       } finally {
/*     */         try {
/* 169 */           if (fis != null) fis.close(); 
/*     */         }
/* 171 */         catch (IOException e) { e.printStackTrace(); }
/*     */         try
/*     */         {
/* 174 */           taos.closeArchiveEntry();
/*     */         } catch (IOException e) {
/* 176 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.TarAndGzipUtil
 * JD-Core Version:    0.6.2
 */