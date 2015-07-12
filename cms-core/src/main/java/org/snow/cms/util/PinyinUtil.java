/*    */ package org.snow.cms.util;
/*    */ 
/*    */ import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
/*    */ import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
/*    */ import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
/*    */ import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
/*    */ import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
/*    */ 
/*    */ public class PinyinUtil
/*    */ {
/* 11 */   private static final HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
/*    */ 
/*    */   public static String str2Pinyin(String str, String fill)
/*    */   {
/*    */     try
/*    */     {
/* 20 */       StringBuffer sb = new StringBuffer();
/* 21 */       if (fill == null) fill = "";
/* 22 */       boolean isCn = true;
/* 23 */       for (int i = 0; i < str.length(); i++) {
/* 24 */         char c = str.charAt(i);
/* 25 */         if ((i > 0) && (isCn)) {
/* 26 */           sb.append(fill);
/*    */         }
/* 28 */         if (c == ' ') {
/* 29 */           sb.append(fill);
/*    */         }
/*    */ 
/* 32 */         if ((c >= '一') && (c <= 40869)) {
/* 33 */           isCn = true;
/* 34 */           sb.append(net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinStringArray(c, format)[0]);
/*    */         }
/*    */         else {
/* 37 */           if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'))) {
/* 38 */             sb.append(c);
/*    */           }
/* 40 */           isCn = false;
/*    */         }
/*    */       }
/* 43 */       return sb.toString();
/*    */     } catch (BadHanyuPinyinOutputFormatCombination e) {
/* 45 */       e.printStackTrace();
/*    */     }
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */   public static String strFirst2Pinyin(String str) {
/*    */     try {
/* 52 */       StringBuffer sb = new StringBuffer();
/* 53 */       for (int i = 0; i < str.length(); i++) {
/* 54 */         char c = str.charAt(i);
/*    */ 
/* 56 */         if ((c >= '一') && (c <= 40869)) {
/* 57 */           sb.append(net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinStringArray(c, format)[0].charAt(0));
/*    */         }
/*    */       }
/*    */ 
/* 61 */       return sb.toString();
/*    */     } catch (BadHanyuPinyinOutputFormatCombination e) {
/* 63 */       e.printStackTrace();
/*    */     }
/* 65 */     return null;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 13 */     format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
/* 14 */     format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
/* 15 */     format.setVCharType(HanyuPinyinVCharType.WITH_V);
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.PinyinUtil
 * JD-Core Version:    0.6.2
 */