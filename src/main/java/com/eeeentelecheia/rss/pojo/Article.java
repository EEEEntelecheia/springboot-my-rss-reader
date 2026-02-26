package com.eeeentelecheia.rss.pojo;

public class Article {
    private Integer id;
    private String title;
    private String link;
    private String summary;
    private boolean isRead;
    private String published;
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

    public boolean isisRead() {
        return isRead;
    }

    public void setisRead(boolean isRead) {
        this.isRead = isRead;
    }

    public String getpublished() {
        return published;
    }

    public void setpublished(String published) {
        this.published = published;
    }

    public Integer getfeedId() {
        return feedId;
    }

    public void setfeedId(Integer feedId) {
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
