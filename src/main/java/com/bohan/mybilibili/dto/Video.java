package com.bohan.mybilibili.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Video {
    private String bv;
    private int playCount;
    private String title;
    private String author;
    private String cover;
    private String type;
    private String category;
    private String introduction;
    private LocalDateTime publishTime;

    private List<String> tagList;
    private List<Play> playList;

    String tags;    //"tag1_tag2_tag3"

    public Video() {
    }

    public Video(String bv, int playCount, String title, String author, String cover, String type, String category, String introduction, LocalDateTime publishTime, List<String> tagList, List<Play> playList) {
        this.bv = bv;
        this.playCount = playCount;
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.type = type;
        this.category = category;
        this.introduction = introduction;
        this.publishTime = publishTime;
        this.tagList = tagList;
        this.playList = playList;
    }

    @Override
    public String toString() {
        return "Video{" +
                "bv=" + bv +
                ", playCount=" + playCount +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", introduction='" + introduction + '\'' +
                ", publishTime=" + publishTime +
                ", tagList=" + tagList +
                ", playList=" + this.getTagList() +
                '}';
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getBv() {
        return bv;
    }

    public void setBv(String bv) {
        this.bv = bv;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public List<String> getTagList() {
        if (tags == null) {
            return List.of();
        }
        String[] split = tags.split("_");
        return List.of(split);
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public List<Play> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Play> playList) {
        this.playList = playList;
    }

    public static void main(String[] args){
        LocalDateTime dt1 = LocalDateTime.of(2018, 1, 1, 0, 0);
        LocalDateTime dt2 = LocalDateTime.now();
        LocalDateTime dt3 = LocalDateTime.parse("2018-06-07T10:00:00");
        LocalTime t1 = LocalTime.parse("12:00:00");
        System.out.println(dt1);
        System.out.println(dt2);
        System.out.println(dt3.getSecond());
        System.out.println(t1);
    }
}
