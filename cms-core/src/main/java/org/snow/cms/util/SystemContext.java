/*    */ package org.snow.cms.util;
/*    */ 
/*    */ public class SystemContext
/*    */ {
/* 15 */   public static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
/*    */ 
/* 19 */   public static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
/*    */ 
/* 23 */   public static ThreadLocal<String> sort = new ThreadLocal<String>();
/*    */ 
/* 27 */   public static ThreadLocal<String> order = new ThreadLocal<String>();
/*    */ 
/* 31 */   public static ThreadLocal<String> realPath = new ThreadLocal<String>();
/*    */ 
/*    */   public static String getRealPath()
/*    */   {
/* 35 */     return (String)realPath.get();
/*    */   }
/*    */   public static void setRealPath(String _realPath) {
/* 38 */     realPath.set(_realPath);
/*    */   }
/*    */   public static Integer getPageSize() {
/* 41 */     return (Integer)pageSize.get();
/*    */   }
/*    */   public static void setPageSize(Integer _pageSize) {
/* 44 */     pageSize.set(_pageSize);
/*    */   }
/*    */   public static Integer getPageOffset() {
/* 47 */     return (Integer)pageOffset.get();
/*    */   }
/*    */   public static void setPageOffset(Integer _pageOffset) {
/* 50 */     pageOffset.set(_pageOffset);
/*    */   }
/*    */   public static String getSort() {
/* 53 */     return (String)sort.get();
/*    */   }
/*    */   public static void setSort(String _sort) {
/* 56 */     sort.set(_sort);
/*    */   }
/*    */   public static String getOrder() {
/* 59 */     return (String)order.get();
/*    */   }
/*    */   public static void setOrder(String _order) {
/* 62 */     order.set(_order);
/*    */   }
/*    */   public static void removePageSize() {
/* 65 */     pageSize.remove();
/*    */   }
/*    */   public static void removePageOffset() {
/* 68 */     pageOffset.remove();
/*    */   }
/*    */   public static void removeSort() {
/* 71 */     sort.remove();
/*    */   }
/*    */   public static void removeOrder() {
/* 74 */     order.remove();
/*    */   }
/*    */   public static void removeRealPath() {
/* 77 */     realPath.remove();
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.SystemContext
 * JD-Core Version:    0.6.2
 */