package org.snow.cms.model;

public enum ChannelType {
    NAV_CHANNEL("导航栏目"), TOPIC_LIST("文章列表栏目"),
    TOPIC_CONTENT("文章内容栏目"), IMG_LIST("图片列表栏目");

    private String name;

    private ChannelType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
