/*    */ package org.snow.cms.util;
/*    */ 
/*    */ import com.fasterxml.jackson.core.JsonFactory;
/*    */ import com.fasterxml.jackson.core.JsonGenerator;
/*    */ import com.fasterxml.jackson.core.JsonParseException;
/*    */ import com.fasterxml.jackson.databind.JsonMappingException;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.io.IOException;
/*    */ import java.io.StringWriter;
/*    */ 
/*    */ public class JsonUtil
/*    */ {
/*    */   private static JsonUtil ju;
/*    */   private static JsonFactory jf;
/*    */   private static ObjectMapper mapper;
/*    */ 
/*    */   public static JsonUtil getInstance()
/*    */   {
/* 19 */     if (ju == null) ju = new JsonUtil();
/* 20 */     return ju;
/*    */   }
/*    */ 
/*    */   public static ObjectMapper getMapper() {
/* 24 */     if (mapper == null) {
/* 25 */       mapper = new ObjectMapper();
/*    */     }
/* 27 */     return mapper;
/*    */   }
/*    */ 
/*    */   public static JsonFactory getFactory() {
/* 31 */     if (jf == null) jf = new JsonFactory();
/* 32 */     return jf;
/*    */   }
/*    */ 
/*    */   public String obj2json(Object obj) {
/* 36 */     JsonGenerator jg = null;
/*    */     try {
/* 38 */       jf = getFactory();
/* 39 */       mapper = getMapper();
/* 40 */       StringWriter out = new StringWriter();
/* 41 */       jg = jf.createJsonGenerator(out);
/* 42 */       mapper.writeValue(jg, obj);
/* 43 */       return out.toString();
/*    */     } catch (IOException e) {
/* 45 */       e.printStackTrace();
/*    */     } finally {
/*    */       try {
/* 48 */         if (jg != null) jg.close(); 
/*    */       }
/* 50 */       catch (IOException e) { e.printStackTrace(); }
/*    */ 
/*    */     }
/* 53 */     return null;
/*    */   }
/*    */ 
/*    */   public Object json2obj(String json, Class<?> clz) {
/*    */     try {
/* 58 */       mapper = getMapper();
/* 59 */       return mapper.readValue(json, clz);
/*    */     } catch (JsonParseException e) {
/* 61 */       e.printStackTrace();
/*    */     } catch (JsonMappingException e) {
/* 63 */       e.printStackTrace();
/*    */     } catch (IOException e) {
/* 65 */       e.printStackTrace();
/*    */     }
/* 67 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.JsonUtil
 * JD-Core Version:    0.6.2
 */