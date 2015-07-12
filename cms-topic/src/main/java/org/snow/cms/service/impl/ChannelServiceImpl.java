/*    */ package org.snow.cms.service.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ import org.snow.cms.dao.IChannelDao;
/*    */ import org.snow.cms.model.Channel;
/*    */ import org.snow.cms.model.ChannelTree;
/*    */ import org.snow.cms.service.IChannelService;
/*    */ import org.snow.cms.util.CmsException;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("channelService")
/*    */ public class ChannelServiceImpl
/*    */   implements IChannelService
/*    */ {
/*    */ 
/*    */   @Inject
/*    */   private IChannelDao channelDao;
/*    */ 
/*    */   public void add(Channel channel, Integer pid)
/*    */   {
/* 20 */     int orders = this.channelDao.getMaxOrderByParent(pid);
/* 21 */     if ((null != pid) && (pid.intValue() > 0)) {
/* 22 */       Channel ch = (Channel)this.channelDao.load(Channel.class, pid);
/* 23 */       if (null == ch) throw new CmsException("添加栏目的父栏目不正确!");
/* 24 */       channel.setParent(ch);
/*    */     }
/* 26 */     channel.setOrders(orders + 1);
/* 27 */     this.channelDao.add(channel);
/*    */   }
/*    */ 
/*    */   public void update(Channel channel)
/*    */   {
/* 32 */     this.channelDao.update(channel);
/*    */   }
/*    */ 
/*    */   public void delete(int id)
/*    */   {
/* 38 */     List channels = this.channelDao.listChannelByParent(Integer.valueOf(id));
/* 39 */     if ((null != channels) && (channels.size() > 0)) {
/* 40 */       throw new CmsException("要删除的栏目还有子栏目，不能删除");
/*    */     }
/*    */ 
/* 44 */     this.channelDao.delete(Channel.class, Integer.valueOf(id));
/*    */   }
/*    */ 
/*    */   public Channel load(int id)
/*    */   {
/* 49 */     return (Channel)this.channelDao.load(Channel.class, Integer.valueOf(id));
/*    */   }
/*    */ 
/*    */   public void clearTopic(int id)
/*    */   {
/*    */   }
/*    */ 
/*    */   public List<Channel> listChannelByParent(Integer pid)
/*    */   {
/* 59 */     return this.channelDao.listChannelByParent(pid);
/*    */   }
/*    */ 
/*    */   public List<ChannelTree> generateTree()
/*    */   {
/* 64 */     return this.channelDao.generateTree();
/*    */   }
/*    */ 
/*    */   public List<ChannelTree> generateTreeByParent(Integer pid)
/*    */   {
/* 69 */     return this.channelDao.generateTreeByParent(pid);
/*    */   }
/*    */ 
/*    */   public void updateSort(Integer[] ids)
/*    */   {
/* 74 */     this.channelDao.updateSort(ids);
/*    */   }
/*    */ 
/*    */   public List<Channel> listPublishChannel()
/*    */   {
/* 79 */     return this.channelDao.listPublishChannel();
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-topic\0.0.1-SNAPSHOT\cms-topic-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.impl.ChannelServiceImpl
 * JD-Core Version:    0.6.2
 */