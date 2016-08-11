 package org.snow.cms.util;
 
 import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
 public class EnumUtils
 {
   public static List<Integer> enumToOrdinal(Class<? extends Enum> clz)
   {
     if (!clz.isEnum()) return null;
    List list = new ArrayList();
    Enum[] enums = (Enum[])clz.getEnumConstants();
    for (Enum en : enums) {
      list.add(Integer.valueOf(en.ordinal()));
     }
     return list;
   }
 
   public static List<String> enumToName(Class<? extends Enum> clz)
   {
    if (!clz.isEnum()) return null;
    List list = new ArrayList();
    Enum[] enums = (Enum[])clz.getEnumConstants();
    for (Enum en : enums) {
       list.add(en.name());
     }
     return list;
   }
 
   public static Map<Integer, String> enumToBasicMap(Class<? extends Enum> clz)
   {
    if (!clz.isEnum()) return null;
     Map map = new HashMap();
    Enum[] enums = (Enum[])clz.getEnumConstants();
    for (Enum en : enums) {
       map.put(Integer.valueOf(en.ordinal()), en.name());
     }
     return map;
   }
 
   public static List<String> enumPropToList(Class<? extends Enum> clz, String propName)
   {
     if (!clz.isEnum()) return null; try
     {
      Enum[] enums = (Enum[])clz.getEnumConstants();
      List list = new ArrayList();
      for (Enum en : enums) {
        list.add((String)PropertyUtils.getProperty(en, propName));
       }
      return list;
     } catch (IllegalAccessException e) {
      e.printStackTrace();
     } catch (InvocationTargetException e) {
       e.printStackTrace();
     } catch (NoSuchMethodException e) {
      e.printStackTrace();
     }
     return null;
   }
 
   public static Map<Integer, String> enumPropToOrdinalMap(Class<? extends Enum> clz, String propName)
   {
     if (!clz.isEnum()) return null; try
     {
      Map map = new HashMap();
       Enum[] enums = (Enum[])clz.getEnumConstants();
      for (Enum en : enums) {
        map.put(Integer.valueOf(en.ordinal()), (String)PropertyUtils.getProperty(en, propName));
       }
       return map;
     } catch (IllegalAccessException e) {
       e.printStackTrace();
     } catch (InvocationTargetException e) {
       e.printStackTrace();
     }
     catch (NoSuchMethodException e) {
       e.printStackTrace();
     }
     return null;
   }
 
   public static Map<String, String> enumPropToNameMap(Class<? extends Enum> clz, String propName)
   {
     if (!clz.isEnum()) return null; try
     {
       Map map = new HashMap();
       Enum[] enums = (Enum[])clz.getEnumConstants();
       for (Enum en : enums) {
         map.put(en.name(), (String)PropertyUtils.getProperty(en, propName));
       }
       return map;
     } catch (IllegalAccessException e) {
      e.printStackTrace();
     } catch (InvocationTargetException e) {
       e.printStackTrace();
     }
     catch (NoSuchMethodException e) {
       e.printStackTrace();
     }
     return null;
   }
 
   public static Map<String, String> enumPropToMap(Class<? extends Enum> clz, String keyProp, String valueProp)
   {
     if (!clz.isEnum()) return null; try
     {
      Enum[] enums = (Enum[])clz.getEnumConstants();
       Map map = new HashMap();
      for (Enum en : enums) {
        map.put((String)PropertyUtils.getProperty(en, keyProp), (String)PropertyUtils.getProperty(en, valueProp));
       }
       return map;
     } catch (IllegalAccessException e) {
      e.printStackTrace();
     } catch (InvocationTargetException e) {
       e.printStackTrace();
     } catch (NoSuchMethodException e) {
       e.printStackTrace();
     }
     return null;
   }
 }

