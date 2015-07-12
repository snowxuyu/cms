/*     */ package org.snow.cms.util;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.beanutils.PropertyUtils;
/*     */ 
/*     */ public class EnumUtils
/*     */ {
/*     */   public static List<Integer> enumToOrdinal(Class<? extends Enum> clz)
/*     */   {
/*  28 */     if (!clz.isEnum()) return null;
/*  29 */     List list = new ArrayList();
/*  30 */     Enum[] enums = (Enum[])clz.getEnumConstants();
/*  31 */     for (Enum en : enums) {
/*  32 */       list.add(Integer.valueOf(en.ordinal()));
/*     */     }
/*  34 */     return list;
/*     */   }
/*     */ 
/*     */   public static List<String> enumToName(Class<? extends Enum> clz)
/*     */   {
/*  43 */     if (!clz.isEnum()) return null;
/*  44 */     List list = new ArrayList();
/*  45 */     Enum[] enums = (Enum[])clz.getEnumConstants();
/*  46 */     for (Enum en : enums) {
/*  47 */       list.add(en.name());
/*     */     }
/*  49 */     return list;
/*     */   }
/*     */ 
/*     */   public static Map<Integer, String> enumToBasicMap(Class<? extends Enum> clz)
/*     */   {
/*  58 */     if (!clz.isEnum()) return null;
/*  59 */     Map map = new HashMap();
/*  60 */     Enum[] enums = (Enum[])clz.getEnumConstants();
/*  61 */     for (Enum en : enums) {
/*  62 */       map.put(Integer.valueOf(en.ordinal()), en.name());
/*     */     }
/*  64 */     return map;
/*     */   }
/*     */ 
/*     */   public static List<String> enumPropToList(Class<? extends Enum> clz, String propName)
/*     */   {
/*  74 */     if (!clz.isEnum()) return null; try
/*     */     {
/*  76 */       Enum[] enums = (Enum[])clz.getEnumConstants();
/*  77 */       List list = new ArrayList();
/*  78 */       for (Enum en : enums) {
/*  79 */         list.add((String)PropertyUtils.getProperty(en, propName));
/*     */       }
/*  81 */       return list;
/*     */     } catch (IllegalAccessException e) {
/*  83 */       e.printStackTrace();
/*     */     } catch (InvocationTargetException e) {
/*  85 */       e.printStackTrace();
/*     */     } catch (NoSuchMethodException e) {
/*  87 */       e.printStackTrace();
/*     */     }
/*  89 */     return null;
/*     */   }
/*     */ 
/*     */   public static Map<Integer, String> enumPropToOrdinalMap(Class<? extends Enum> clz, String propName)
/*     */   {
/*  99 */     if (!clz.isEnum()) return null; try
/*     */     {
/* 101 */       Map map = new HashMap();
/* 102 */       Enum[] enums = (Enum[])clz.getEnumConstants();
/* 103 */       for (Enum en : enums) {
/* 104 */         map.put(Integer.valueOf(en.ordinal()), (String)PropertyUtils.getProperty(en, propName));
/*     */       }
/* 106 */       return map;
/*     */     } catch (IllegalAccessException e) {
/* 108 */       e.printStackTrace();
/*     */     } catch (InvocationTargetException e) {
/* 110 */       e.printStackTrace();
/*     */     }
/*     */     catch (NoSuchMethodException e) {
/* 113 */       e.printStackTrace();
/*     */     }
/* 115 */     return null;
/*     */   }
/*     */ 
/*     */   public static Map<String, String> enumPropToNameMap(Class<? extends Enum> clz, String propName)
/*     */   {
/* 125 */     if (!clz.isEnum()) return null; try
/*     */     {
/* 127 */       Map map = new HashMap();
/* 128 */       Enum[] enums = (Enum[])clz.getEnumConstants();
/* 129 */       for (Enum en : enums) {
/* 130 */         map.put(en.name(), (String)PropertyUtils.getProperty(en, propName));
/*     */       }
/* 132 */       return map;
/*     */     } catch (IllegalAccessException e) {
/* 134 */       e.printStackTrace();
/*     */     } catch (InvocationTargetException e) {
/* 136 */       e.printStackTrace();
/*     */     }
/*     */     catch (NoSuchMethodException e) {
/* 139 */       e.printStackTrace();
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */ 
/*     */   public static Map<String, String> enumPropToMap(Class<? extends Enum> clz, String keyProp, String valueProp)
/*     */   {
/* 152 */     if (!clz.isEnum()) return null; try
/*     */     {
/* 154 */       Enum[] enums = (Enum[])clz.getEnumConstants();
/* 155 */       Map map = new HashMap();
/* 156 */       for (Enum en : enums) {
/* 157 */         map.put((String)PropertyUtils.getProperty(en, keyProp), (String)PropertyUtils.getProperty(en, valueProp));
/*     */       }
/* 159 */       return map;
/*     */     } catch (IllegalAccessException e) {
/* 161 */       e.printStackTrace();
/*     */     } catch (InvocationTargetException e) {
/* 163 */       e.printStackTrace();
/*     */     } catch (NoSuchMethodException e) {
/* 165 */       e.printStackTrace();
/*     */     }
/* 167 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.util.EnumUtils
 * JD-Core Version:    0.6.2
 */