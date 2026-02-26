package com.eeeentelecheia.rss.pojo;

import javax.xml.crypto.Data;

public class Article {
    private Integer id;
    private String title;
    private String link;
    private String summary;
    private boolean isRead;
    private Data published;
    private Integer feedId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public Data getPublished() {
        return published;
    }

    public void setPublished(Data published) {
        this.published = published;
    }

    public Integer getFeedId() {
        return feedId;
    }

    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", summary='" + summary + '\'' +
                ", isRead=" + isRead +
                ", published='" + published + '\'' +
                ", feedId=" + feedId +
                '}';
    }
}
