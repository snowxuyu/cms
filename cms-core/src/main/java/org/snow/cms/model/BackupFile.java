package org.snow.cms.model;

import java.util.Date;

public class BackupFile
        implements Comparable<BackupFile> {
    private String name;
    private Date time;
    private int size;
    private String filetype;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFiletype() {
        return this.filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public int compareTo(BackupFile o) {
        return o.getTime().compareTo(getTime());
    }

    public String toString() {
        return "BackupFile [name=" + this.name + ", time=" + this.time + ", size=" + this.size + ", filetype=" + this.filetype + "]";
    }
}

