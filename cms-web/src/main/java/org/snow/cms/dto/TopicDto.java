package org.snow.cms.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.snow.cms.model.Topic;

public class TopicDto
{
  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private int id;
  private String title;
  private String keyword;
  private int status;
  private int recommend;
  private String content;
  private String summary;
  private int channelPicId;
  private String publishDate;
  private int cid;

  public int getId()
  {
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
  public String getPublishDate() {
    return this.publishDate;
  }
  public void setPublishDate(String publishDate) {
    this.publishDate = publishDate;
  }
  public int getCid() {
    return this.cid;
  }
  public void setCid(int cid) {
    this.cid = cid;
  }
  public TopicDto() {
  }

  public TopicDto(Topic topic) {
    setChannelPicId(topic.getChannelPicId());
    setContent(topic.getContent());
    setId(topic.getId());
    setKeyword(topic.getKeyword());
    setPublishDate(sdf.format(topic.getPublishDate()));
    setRecommend(topic.getRecommend());
    setStatus(topic.getStatus());
    setSummary(topic.getSummary());
    setTitle(topic.getTitle());
  }

  public TopicDto(Topic topic, Integer cid) {
    setChannelPicId(topic.getChannelPicId());
    setContent(topic.getContent());
    setId(topic.getId());
    setCid(cid.intValue());
    setKeyword(topic.getKeyword());
    setPublishDate(sdf.format(topic.getPublishDate()));
    setRecommend(topic.getRecommend());
    setStatus(topic.getStatus());
    setSummary(topic.getSummary());
    setTitle(topic.getTitle());
  }

  public Topic getTopic() {
    Topic t = new Topic();
    t.setChannelPicId(getChannelPicId());
    t.setContent(getContent());
    t.setId(getId());
    t.setKeyword(getKeyword());
    String sdt = sdf.format(Date.valueOf(getPublishDate()));
    Timestamp tt = Timestamp.valueOf(sdt);
    t.setPublishDate(tt);
    t.setRecommend(getRecommend());
    t.setStatus(getStatus());
    t.setSummary(getSummary());
    t.setTitle(getTitle());
    return t;
  }
}