/*    */ package org.snow.cms.service.impl;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ import org.snow.cms.dao.IKeywordDao;
/*    */ import org.snow.cms.model.KeyWord;
/*    */ import org.snow.cms.service.IKeywordService;
/*    */ import org.snow.cms.util.Pager;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("keywordService")
/*    */ public class KeywordServiceImpl
/*    */   implements IKeywordService
/*    */ {
/*    */ 
/*    */   @Inject
/*    */   private IKeywordDao keywordDao;
/*    */ 
/*    */   public void addOrUpdate(String name)
/*    */   {
/* 20 */     this.keywordDao.addOrUpdate(name);
/*    */   }
/*    */ 
/*    */   public List<KeyWord> getKeywordByTimes(int num)
/*    */   {
/* 25 */     List ks = this.keywordDao.listUseKeyword();
/* 26 */     List kks = new ArrayList();
/*    */     KeyWord k;
/* 27 */     for (Iterator i$ = ks.iterator(); i$.hasNext(); 
/* 28 */       kks.add(k))
/*    */     {
/* 27 */       k = (KeyWord)i$.next();
/* 28 */       if (k.getTimes() < num)
/*    */         break;
/*    */     }
/* 31 */     return kks;
/*    */   }
/*    */ 
/*    */   public List<KeyWord> getMaxTimesKeyword(int num)
/*    */   {
/* 36 */     List ks = this.keywordDao.listUseKeyword();
/* 37 */     List kks = new ArrayList();
/* 38 */     if (ks.size() <= num) return ks;
/* 39 */     for (int i = 0; i <= num; i++) {
/* 40 */       kks.add(ks.get(i));
/*    */     }
/* 42 */     return kks;
/*    */   }
/*    */ 
/*    */   public Pager<KeyWord> findNoUseKeyword()
/*    */   {
/* 47 */     return this.keywordDao.findNoUseKeyword();
/*    */   }
/*    */ 
/*    */   public void clearNoUseKeyword()
/*    */   {
/* 52 */     this.keywordDao.clearNoUsekeyword();
/*    */   }
/*    */ 
/*    */   public List<KeyWord> listUseKeyword()
/*    */   {
/* 57 */     return this.keywordDao.listUseKeyword();
/*    */   }
/*    */ 
/*    */   public List<KeyWord> listKeywordByCon(String con)
/*    */   {
/* 62 */     return this.keywordDao.listKeywordByCon(con);
/*    */   }
/*    */ 
/*    */   public List<String> listKeywordStringByCon(String con)
/*    */   {
/* 67 */     return this.keywordDao.listKeywordStringByCon(con);
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-topic\0.0.1-SNAPSHOT\cms-topic-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.service.impl.KeywordServiceImpl
 * JD-Core Version:    0.6.2
 */