package org.snow.cms.model;

public class Channel {
    public static final String ROOT_NAME = "网站系统栏目";
    public static final int ROOT_ID = 0;
    public static final int ROOT_PID = -1;
    private int id;
    private String name;
    private int customLink;
    private String customLinkUrl;
    private int type;
    private int isIndex;
    private int isTopNav;
    private int recommend;
    private int status;
    private int orders;
    private Channel parent;

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

    public int getCustomLink() {
        return this.customLink;
    }

    public void setCustomLink(int customLink) {
        this.customLink = customLink;
    }

    public String getCustomLinkUrl() {
        return this.customLinkUrl;
    }

    public void setCustomLinkUrl(String customLinkUrl) {
        this.customLinkUrl = customLinkUrl;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsIndex() {
        return this.isIndex;
    }

    public void setIsIndex(int isIndex) {
        this.isIndex = isIndex;
    }

    public int getIsTopNav() {
        return this.isTopNav;
    }

    public void setIsTopNav(int isTopNav) {
        this.isTopNav = isTopNav;
    }

    public int getRecommend() {
        return this.recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrders() {
        return this.orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public Channel getParent() {
        return this.parent;
    }

    public void setParent(Channel parent) {
        this.parent = parent;
    }

    public Channel() {
    }

    public Channel(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
