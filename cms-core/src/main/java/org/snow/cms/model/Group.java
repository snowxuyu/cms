package org.snow.cms.model;

public class Group {
    private int id;
    private String name;
    private String descr;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return this.descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group() {
    }
}
