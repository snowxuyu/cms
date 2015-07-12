/*    */ package org.snow.cms.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Properties;
/*    */ 
/*    */ public class PropertiesUtil
/*    */ {
/*  9 */   private static PropertiesUtil util = null;
/* 10 */   private static Map<String, Properties> props = null;
/*    */ 
/*    */   public static PropertiesUtil getInstance()
/*    */   {
/* 16 */     if (util == null) {
/* 17 */       props = new HashMap<String, Properties>();
/* 18 */       util = new PropertiesUtil();
/*    */     }
/* 20 */     return util;
/*    */   }
/*    */ 
/*    */   public Properties load(String name) {
/* 24 */     if (props.get(name) != null) {
/* 25 */       return (Properties)props.get(name);
/*    */     }
/* 27 */     Properties prop = new Properties();
/*    */     try {
/* 29 */       prop.load(PropertiesUtil.class.getResourceAsStream("/" + name + ".properties"));
/* 30 */       props.put(name, prop);
/* 31 */       return prop;
/*    */     } catch (IOException e) {
/* 33 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 36 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.PropertiesUtil
 * JD-Core Version:    0.6.2
 */