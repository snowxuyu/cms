/*     */ package org.snow.cms.service.impl;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.List;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.inject.Inject;
/*     */ import net.coobird.thumbnailator.Thumbnails;
/*     */ import net.coobird.thumbnailator.Thumbnails.Builder;
/*     */ import net.coobird.thumbnailator.geometry.Positions;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.snow.cms.dao.IAttachmentDao;
/*     */ import org.snow.cms.model.Attachment;
/*     */ import org.snow.cms.service.IAttachmentService;
/*     */ import org.snow.cms.util.Pager;
/*     */ import org.snow.cms.util.SystemContext;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("attachmentService")
/*     */ public class AttachmentServiceImpl
/*     */   implements IAttachmentService
/*     */ {
/*     */ 
/*     */   @Inject
/*     */   private IAttachmentDao attachmentDao;
/*     */   public static final String UPLOAD_PATH = "/upload/";
/*     */   public static final int IMG_WIDTH = 900;
/*     */   public static final int THUMBNAIL_WIDTH = 100;
/*     */   public static final int THUMBNAIL_HEIGHT = 80;
/*     */ 
/*     */   public static void deleteAttachFiles(Attachment a)
/*     */   {
/*  33 */     String realPath = SystemContext.getRealPath();
/*  34 */     realPath = realPath + "/upload/";
/*  35 */     new File(realPath + a.getNewName()).delete();
/*     */   }
/*     */ 
/*     */   public void add(Attachment a, InputStream is) throws IOException
/*     */   {
/*  40 */     this.attachmentDao.add(a);
/*  41 */     addFile(a, is);
/*     */   }
/*     */ 
/*     */   public void addFile(Attachment a, InputStream is) throws IOException
/*     */   {
/*  46 */     String realPath = SystemContext.getRealPath();
/*  47 */     String path = realPath + "/resources/upload/";
/*  48 */     String thumbPath = realPath + "/resources/upload/thumbnail/";
/*  49 */     File fp = new File(path);
/*  50 */     File tfp = new File(thumbPath);
/*  51 */     if (!fp.exists()) fp.mkdirs();
/*  52 */     if (!tfp.exists()) tfp.mkdirs();
/*  53 */     path = path + a.getNewName();
/*  54 */     thumbPath = thumbPath + a.getNewName();
/*  55 */     if (1 == a.getIsImg()) {
/*  56 */       BufferedImage oldBi = ImageIO.read(is);
/*  57 */       int width = oldBi.getWidth();
/*  58 */       Thumbnails.Builder bf = Thumbnails.of(new BufferedImage[] { oldBi });
/*  59 */       if (width > 900)
/*  60 */         bf.scale(900.0D / width);
/*     */       else {
/*  62 */         bf.scale(1.0D);
/*     */       }
/*  64 */       bf.toFile(path);
/*     */ 
/*  67 */       BufferedImage tbi = Thumbnails.of(new BufferedImage[] { oldBi }).scale(120.0D / width).asBufferedImage();
/*     */ 
/*  70 */       Thumbnails.of(new BufferedImage[] { tbi }).scale(1.0D).sourceRegion(Positions.CENTER, 100, 80).toFile(thumbPath);
/*     */     }
/*     */     else
/*     */     {
/*  74 */       FileUtils.copyInputStreamToFile(is, new File(path));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void delete(int id)
/*     */   {
/*  80 */     Attachment a = (Attachment)this.attachmentDao.load(Attachment.class, Integer.valueOf(id));
/*  81 */     this.attachmentDao.delete(Attachment.class, Integer.valueOf(id));
/*  82 */     deleteAttachFiles(a);
/*     */   }
/*     */ 
/*     */   public Attachment load(int id)
/*     */   {
/*  87 */     return (Attachment)this.attachmentDao.load(Attachment.class, Integer.valueOf(id));
/*     */   }
/*     */ 
/*     */   public Pager<Attachment> findNoUseAttachment()
/*     */   {
/*  92 */     return this.attachmentDao.findNoUseAttachment();
/*     */   }
/*     */ 
/*     */   public void clearNoUseAttachment()
/*     */   {
/*  97 */     this.attachmentDao.clearNoUseAttachment();
/*     */   }
/*     */ 
/*     */   public List<Attachment> listByTopic(int tid)
/*     */   {
/* 102 */     return this.attachmentDao.listByTopic(tid);
/*     */   }
/*     */ 
/*     */   public List<Attachment> listIndexPic(int num)
/*     */   {
/* 107 */     return this.attachmentDao.listIndexPic(num);
/*     */   }
/*     */ 
/*     */   public Pager<Attachment> findChannelPic(int cid)
/*     */   {
/* 112 */     return this.attachmentDao.findChannelPic(cid);
/*     */   }
/*     */ 
/*     */   public List<Attachment> listAttachByTopic(int tid)
/*     */   {
/* 117 */     return this.attachmentDao.listAttachmentByTopic(tid);
/*     */   }
/*     */ 
/*     */   public void updateIndexPic(int aid)
/*     */   {
/* 122 */     Attachment a = (Attachment)this.attachmentDao.load(Attachment.class, Integer.valueOf(aid));
/* 123 */     if (a.getIsIndexPic() == 0)
/* 124 */       a.setIsIndexPic(1);
/*     */     else {
/* 126 */       a.setIsIndexPic(0);
/*     */     }
/* 128 */     this.attachmentDao.update(a);
/*     */   }
/*     */ 
/*     */   public void updateAttachInfo(int aid)
/*     */   {
/* 133 */     Attachment att = (Attachment)this.attachmentDao.load(Attachment.class, Integer.valueOf(aid));
/* 134 */     if (att.getIsAttach() == 0)
/* 135 */       att.setIsAttach(1);
/*     */     else {
/* 137 */       att.setIsAttach(0);
/*     */     }
/* 139 */     this.attachmentDao.update(att);
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-topic\0.0.1-SNAPSHOT\cms-topic-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.impl.AttachmentServiceImpl
 * JD-Core Version:    0.6.2
 */