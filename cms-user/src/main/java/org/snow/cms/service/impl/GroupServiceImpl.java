/*     */ package org.snow.cms.service.impl;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import org.snow.cms.dao.IChannelDao;
/*     */ import org.snow.cms.dao.IGroupDao;
/*     */ import org.snow.cms.dao.IUserDao;
/*     */ import org.snow.cms.model.Channel;
/*     */ import org.snow.cms.model.ChannelTree;
/*     */ import org.snow.cms.model.Group;
/*     */ import org.snow.cms.model.GroupChannel;
/*     */ import org.snow.cms.service.IGroupService;
/*     */ import org.snow.cms.util.CmsException;
/*     */ import org.snow.cms.util.Pager;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("groupService")
/*     */ public class GroupServiceImpl
/*     */   implements IGroupService
/*     */ {
/*     */ 
/*     */   @Inject
/*     */   private IGroupDao groupDao;
/*     */ 
/*     */   @Inject
/*     */   private IUserDao userDao;
/*     */ 
/*     */   @Inject
/*     */   private IChannelDao channelDao;
/*     */ 
/*     */   public void add(Group group)
/*     */   {
/*  29 */     this.groupDao.add(group);
/*     */   }
/*     */ 
/*     */   public void update(Group group)
/*     */   {
/*  34 */     this.groupDao.update(group);
/*     */   }
/*     */ 
/*     */   public void delete(int groupId)
/*     */   {
/*  39 */     List users = this.userDao.listGroupUsers(groupId);
/*  40 */     if ((null != users) && (users.size() > 0)) {
/*  41 */       throw new CmsException("要删除的组中有用户存在，不能删除!");
/*     */     }
/*  43 */     this.groupDao.delete(Group.class, Integer.valueOf(groupId));
/*     */   }
/*     */ 
/*     */   public Group load(int groupId)
/*     */   {
/*  48 */     return (Group)this.groupDao.load(Group.class, Integer.valueOf(groupId));
/*     */   }
/*     */ 
/*     */   public List<Group> listGroup()
/*     */   {
/*  53 */     return this.groupDao.listGroup();
/*     */   }
/*     */ 
/*     */   public Pager<Group> findGroup()
/*     */   {
/*  58 */     return this.groupDao.findGroup();
/*     */   }
/*     */ 
/*     */   public void deleteGroupUsers(int groupId)
/*     */   {
/*  63 */     this.groupDao.deleteGroupUsers(groupId);
/*     */   }
/*     */ 
/*     */   public void addGroupChannel(int groupId, int channelId)
/*     */   {
/*  68 */     Group g = (Group)this.groupDao.load(Group.class, Integer.valueOf(groupId));
/*  69 */     Channel c = (Channel)this.channelDao.load(Channel.class, Integer.valueOf(channelId));
/*  70 */     if ((null == c) || (null == g)) {
/*  71 */       throw new CmsException("要添加的组栏目的关联对象不存在...");
/*     */     }
/*  73 */     this.groupDao.addGroupChannel(g, c);
/*     */   }
/*     */ 
/*     */   public GroupChannel loadGroupChannel(int groupId, int channelId)
/*     */   {
/*  78 */     return this.groupDao.loadGroupChannel(groupId, channelId);
/*     */   }
/*     */ 
/*     */   public void deleteGroupChannel(int groupId, int channelId)
/*     */   {
/*  83 */     this.groupDao.deleteGroupChannel(groupId, channelId);
/*     */   }
/*     */ 
/*     */   public void clearGroupChannel(int groupId)
/*     */   {
/*  88 */     this.groupDao.clearGroupChannel(groupId);
/*     */   }
/*     */ 
/*     */   public List<ChannelTree> generateGroupChannelTree(int groupId)
/*     */   {
/*  93 */     return this.groupDao.generateGroupChannelTree(groupId);
/*     */   }
/*     */ 
/*     */   public List<ChannelTree> generateUserChannelTree(int userId)
/*     */   {
/*  98 */     return this.groupDao.generateUserChannelTree(userId);
/*     */   }
/*     */ 
/*     */   public List<Integer> listGroupChannelIds(int groupId)
/*     */   {
/* 103 */     return this.groupDao.listGroupChannelIds(groupId);
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-user\0.0.1-SNAPSHOT\cms-user-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.impl.GroupServiceImpl
 * JD-Core Version:    0.6.2
 */