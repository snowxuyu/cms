/*    */ package org.snow.cms.util;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class Pager<T>
/*    */ {
/*    */   private int size;
/*    */   private int offset;
/*    */   private long totalRecord;
/*    */   private List<T> datas;
/*    */ 
/*    */   public int getSize()
/*    */   {
/* 35 */     return this.size;
/*    */   }
/*    */   public void setSize(int size) {
/* 38 */     this.size = size;
/*    */   }
/*    */   public int getOffset() {
/* 41 */     return this.offset;
/*    */   }
/*    */   public void setOffset(int offset) {
/* 44 */     this.offset = offset;
/*    */   }
/*    */   public long getTotalRecord() {
/* 47 */     return this.totalRecord;
/*    */   }
/*    */   public void setTotalRecord(long totalRecord) {
/* 50 */     this.totalRecord = totalRecord;
/*    */   }
/*    */   public List<T> getDatas() {
/* 53 */     return this.datas;
/*    */   }
/*    */   public void setDatas(List<T> datas) {
/* 56 */     this.datas = datas;
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.Pager
 * JD-Core Version:    0.6.2
 */