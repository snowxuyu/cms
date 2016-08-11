package org.snow.cms.model;

public class KeyWord
        implements Comparable<KeyWord> {
    private int id;
    private String name;
    private int times;
    private String nameFullPy;
    private String nameShortPy;

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

    public int getTimes() {
        return this.times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getNameFullPy() {
        return this.nameFullPy;
    }

    public void setNameFullPy(String nameFullPy) {
        this.nameFullPy = nameFullPy;
    }

    public String getNameShortPy() {
        return this.nameShortPy;
    }

    public void setNameShortPy(String nameShortPy) {
        this.nameShortPy = nameShortPy;
    }

    public KeyWord() {
    }

    public KeyWord(String name, int times) {
        this.name = name;
        this.times = times;
    }

    public KeyWord(int id, String name, int times) {
        this.id = id;
        this.name = name;
        this.times = times;
    }

    public KeyWord(int id, String name, String nameFullPy, String nameShortPy) {
        this.id = id;
        this.name = name;
        this.nameShortPy = nameShortPy;
        this.nameFullPy = nameFullPy;
    }

    public KeyWord(int id, String name, int times, String nameFullPy, String nameShortPy) {
        this.id = id;
        this.name = name;
        this.times = times;
        this.nameShortPy = nameShortPy;
        this.nameFullPy = nameFullPy;
    }

    public int compareTo(KeyWord o) {
        return this.times == o.times ? 0 : this.times > o.times ? -1 : 1;
    }
}
