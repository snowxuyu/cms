package org.snow.cms.model;

import java.sql.Timestamp;

public class Topic {
    private int id;
    private String title;
    private String keyword;
    private int status;
    private int recommend;
    private String content;
    private String summary;
    private int channelPicId;
    private String author;
    private String cname;
    private Timestamp publishDate;
    private Timestamp createDate;
    private Channel channel;
    private User user;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRecommend() {
        return this.recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getChannelPicId() {
        return this.channelPicId;
    }

    public void setChannelPicId(int channelPicId) {
        this.channelPicId = channelPicId;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Topic(int id, String title, String keyword, int status, int recommend, Timestamp publishDate, String author, String cname) {
        this.id = id;
        this.title = title;
        this.keyword = keyword;
        this.status = status;
        this.recommend = recommend;
        this.publishDate = publishDate;
        this.author = author;
        this.cname = cname;
    }

    public Topic(int id, String title, String keyword, int status, int recommend, String author) {
        this.id = id;
        this.title = title;
        this.keyword = keyword;
        this.status = status;
        this.recommend = recommend;
        this.author = author;
    }

    public Topic() {
    }
}
