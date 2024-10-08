package com.bohan.mybilibili.dto;

import java.time.LocalTime;

public class Play {
    private String id;                 //集号
    private String title;           //标题
    private String url;             //视频文件路径
    private LocalTime duration;     //时长
    private String bv;

    public Play(){
    }

    public Play(String id, String title, LocalTime duration, String url, String bv) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBv() {
        return bv;
    }

    public void setBv(String bv) {
        this.bv = bv;
    }
}
