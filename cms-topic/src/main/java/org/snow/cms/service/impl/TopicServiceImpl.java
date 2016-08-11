/*     */ package org.snow.cms.service.impl;
/*     */ 
/*     */ import org.snow.cms.dao.IAttachmentDao;
import org.snow.cms.dao.IChannelDao;
import org.snow.cms.dao.ITopicDao;
import org.snow.cms.dao.IUserDao;
import org.snow.cms.model.Attachment;
import org.snow.cms.model.Channel;
import org.snow.cms.model.Topic;
import org.snow.cms.model.User;
import org.snow.cms.service.ITopicService;
import org.snow.cms.util.CmsException;
import org.snow.cms.util.Pager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ @Service("topicService")
/*     */ public class TopicServiceImpl
/*     */   implements ITopicService
/*     */ {
/*     */ 
/*     */   @Inject
/*     */   private ITopicDao topicDao;
/*     */ 
/*     */   @Inject
/*     */   private IAttachmentDao attachmentDao;
/*     */ 
/*     */   @Inject
/*     */   private IChannelDao channelDao;
/*     */ 
/*     */   @Inject
/*     */   private IUserDao userDao;
/*     */ 
/*     */   private void addTopicAttach(Topic topic, Integer[] aids)
/*     */   {
/*  32 */     if (null != aids)
/*  33 */       for (Integer aid : aids) {
/*  34 */         Attachment a = (Attachment)this.attachmentDao.load(Attachment.class, aid);
/*  35 */         if (null != a) {
/*  36 */           a.setTopic(topic);
/*  37 */           this.attachmentDao.update(a);
/*     */         }
/*     */       }
/*     */   }
/*     */ 
/*     */   public void add(Topic topic, int cid, int uid, Integer[] aids)
/*     */   {
/*  44 */     Channel c = (Channel)this.channelDao.load(Channel.class, Integer.valueOf(cid));
/*  45 */     User u = (User)this.userDao.load(User.class, Integer.valueOf(uid));
/*  46 */     if ((null == c) || (null == u)) {
/*  47 */       throw new CmsException("要添加的文章必须有用户和栏目");
/*     */     }
/*  49 */     topic.setAuthor(u.getNickname());
/*  50 */     topic.setCname(c.getName());
/*  51 */     topic.setChannel(c);
/*  52 */     topic.setUser(u);
/*  53 */     this.topicDao.add(topic);
/*  54 */     addTopicAttach(topic, aids);
/*     */   }
/*     */ 
/*     */   public void add(Topic topic, int cid, int uid)
/*     */   {
/*  59 */     add(topic, cid, uid, null);
/*     */   }
/*     */ 
/*     */   public void delete(int tid)
/*     */   {
/*  64 */     List<Attachment> atts = this.attachmentDao.listByTopic(tid);
/*  65 */     this.attachmentDao.deleteByTopic(tid);
/*  66 */     this.topicDao.delete(Topic.class, Integer.valueOf(tid));
/*     */ 
/*  68 */     for (Attachment att : atts)
/*  69 */       AttachmentServiceImpl.deleteAttachFiles(att);
/*     */   }
/*     */ 
/*     */   public void update(Topic topic, int cid, Integer[] aids)
/*     */   {
/*  75 */     Channel c = (Channel)this.channelDao.load(Channel.class, Integer.valueOf(cid));
/*  76 */     if (null == c) {
/*  77 */       throw new CmsException("要添加的文章必须有用户和栏目");
/*     */     }
/*  79 */     topic.setCname(c.getName());
/*  80 */     topic.setChannel(c);
/*  81 */     this.topicDao.update(topic);
/*  82 */     addTopicAttach(topic, aids);
/*     */   }
/*     */ 
/*     */   public void update(Topic topic, int cid)
/*     */   {
/*  87 */     update(topic, cid, null);
/*     */   }
/*     */ 
/*     */   public void updateStatus(int tid)
/*     */   {
/*  92 */     Topic t = (Topic)this.topicDao.load(Topic.class, Integer.valueOf(tid));
/*  93 */     if (t.getStatus() == 0) t.setStatus(1); else
/*  94 */       t.setStatus(0);
/*  95 */     this.topicDao.update(t);
/*     */   }
/*     */ 
/*     */   public Topic load(int id)
/*     */   {
/* 100 */     return (Topic)this.topicDao.load(Topic.class, Integer.valueOf(id));
/*     */   }
/*     */ 
/*     */   public Pager<Topic> find(Integer cid, String title, Integer status)
/*     */   {
/* 105 */     return this.topicDao.find(cid, title, status.intValue());
/*     */   }
/*     */ 
/*     */   public Pager<Topic> find(Integer uid, Integer cid, String title, Integer status)
/*     */   {
/* 111 */     return this.topicDao.find(uid, cid, title, status.intValue());
/*     */   }
/*     */ 
/*     */   public Pager<Topic> searchTopicByKeyword(String keyword)
/*     */   {
/* 116 */     return this.topicDao.searchTopicByKeyword(keyword);
/*     */   }
/*     */ 
/*     */   public Pager<Topic> searchTopic(String con)
/*     */   {
/* 121 */     return this.topicDao.searchTopic(con);
/*     */   }
/*     */ 
/*     */   public Pager<Topic> findRecommendTopic(Integer cid)
/*     */   {
/* 126 */     return this.topicDao.findRecommendTopic(cid);
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-topic\0.0.1-SNAPSHOT\cms-topic-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.impl.TopicServiceImpl
 * JD-Core Version:    0.6.2
 */