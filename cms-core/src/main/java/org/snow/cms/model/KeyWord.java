/*    */ package org.snow.cms.model;
/*    */ 
/*    */ public class KeyWord
/*    */   implements Comparable<KeyWord>
/*    */ {
/*    */   private int id;
/*    */   private String name;
/*    */   private int times;
/*    */   private String nameFullPy;
/*    */   private String nameShortPy;
/*    */ 
/*    */   public int getId()
/*    */   {
/* 33 */     return this.id;
/*    */   }
/*    */   public void setId(int id) {
/* 36 */     this.id = id;
/*    */   }
/*    */   public String getName() {
/* 39 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 42 */     this.name = name;
/*    */   }
/*    */   public int getTimes() {
/* 45 */     return this.times;
/*    */   }
/*    */   public void setTimes(int times) {
/* 48 */     this.times = times;
/*    */   }
/*    */   public String getNameFullPy() {
/* 51 */     return this.nameFullPy;
/*    */   }
/*    */   public void setNameFullPy(String nameFullPy) {
/* 54 */     this.nameFullPy = nameFullPy;
/*    */   }
/*    */   public String getNameShortPy() {
/* 57 */     return this.nameShortPy;
/*    */   }
/*    */   public void setNameShortPy(String nameShortPy) {
/* 60 */     this.nameShortPy = nameShortPy;
/*    */   }
/*    */ 
/*    */   public KeyWord() {
/*    */   }
/*    */ 
/*    */   public KeyWord(String name, int times) {
/* 67 */     this.name = name;
/* 68 */     this.times = times;
/*    */   }
/*    */ 
/*    */   public KeyWord(int id, String name, int times)
/*    */   {
/* 73 */     this.id = id;
/* 74 */     this.name = name;
/* 75 */     this.times = times;
/*    */   }
/*    */ 
/*    */   public KeyWord(int id, String name, String nameFullPy, String nameShortPy) {
/* 79 */     this.id = id;
/* 80 */     this.name = name;
/* 81 */     this.nameShortPy = nameShortPy;
/* 82 */     this.nameFullPy = nameFullPy;
/*    */   }
/*    */ 
/*    */   public KeyWord(int id, String name, int times, String nameFullPy, String nameShortPy) {
/* 86 */     this.id = id;
/* 87 */     this.name = name;
/* 88 */     this.times = times;
/* 89 */     this.nameShortPy = nameShortPy;
/* 90 */     this.nameFullPy = nameFullPy;
/*    */   }
/*    */ 
/*    */   public int compareTo(KeyWord o) {
/* 94 */     return this.times == o.times ? 0 : this.times > o.times ? -1 : 1;
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.KeyWord
 * JD-Core Version:    0.6.2
 */