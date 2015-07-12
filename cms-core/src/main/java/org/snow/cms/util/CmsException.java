/*    */ package org.snow.cms.util;
/*    */ 
/*    */ public class CmsException extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   public CmsException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CmsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
/*    */   {
/* 12 */     super(message, cause, enableSuppression, writableStackTrace);
/*    */   }
/*    */ 
/*    */   public CmsException(String message, Throwable cause) {
/* 16 */     super(message, cause);
/*    */   }
/*    */ 
/*    */   public CmsException(String message) {
/* 20 */     super(message);
/*    */   }
/*    */ 
/*    */   public CmsException(Throwable cause) {
/* 24 */     super(cause);
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.CmsException
 * JD-Core Version:    0.6.2
 */