/*    */ package org.snow.cms.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class BackupFile
/*    */   implements Comparable<BackupFile>
/*    */ {
/*    */   private String name;
/*    */   private Date time;
/*    */   private int size;
/*    */   private String filetype;
/*    */ 
/*    */   public String getName()
/*    */   {
/* 30 */     return this.name;
/*    */   }
/*    */   public void setName(String name) {
/* 33 */     this.name = name;
/*    */   }
/*    */   public Date getTime() {
/* 36 */     return this.time;
/*    */   }
/*    */   public void setTime(Date time) {
/* 39 */     this.time = time;
/*    */   }
/*    */   public int getSize() {
/* 42 */     return this.size;
/*    */   }
/*    */   public void setSize(int size) {
/* 45 */     this.size = size;
/*    */   }
/*    */   public String getFiletype() {
/* 48 */     return this.filetype;
/*    */   }
/*    */   public void setFiletype(String filetype) {
/* 51 */     this.filetype = filetype;
/*    */   }
/*    */   public int compareTo(BackupFile o) {
/* 54 */     return o.getTime().compareTo(getTime());
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 58 */     return "BackupFile [name=" + this.name + ", time=" + this.time + ", size=" + this.size + ", filetype=" + this.filetype + "]";
/*    */   }
/*    */ }

/* Location:           E:\Tools\javaToos\maven\respo\org\snow\cms\cms-core\0.0.1-SNAPSHOT\cms-core-0.0.1-SNAPSHOT.jar
 * Qualified Name:     org.snow.cms.model.BackupFile
 * JD-Core Version:    0.6.2
 */