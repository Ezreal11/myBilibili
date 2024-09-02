package com.bohan.mybilibili.service;

import com.bohan.mybilibili.dto.Play;
import com.bohan.mybilibili.dto.Video;
import com.bohan.mybilibili.mapper.PlayMapper;
import com.bohan.mybilibili.mapper.VideoMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.Bv;

import java.time.LocalDateTime;
import java.util.List;

/*
    从数据库中查询视频数据
 */
@Service
public class VideoService {

    @Autowired
    VideoMapper videoMapper;
    @Autowired
    PlayMapper playMapper;

    @PostConstruct
    private void init() {
        System.out.println("PostConstruct of VideoService");
    }

    //根据bv号查询视频
    public Video getVideo(String bv) {
        Video video = videoMapper.getVideoByBv(bv);
        if (video == null) {
            return null;
        }
        List<Play> plays = playMapper.getPlayByBv(bv);
        video.setPlayList(plays);
        return video;
    }

    //根据bv号发布视频
    //向video表和play表插入数据
    public String publishVideo(Video video) {
        video.setPublishTime(LocalDateTime.now());  //服务器给出发布时间

        videoMapper.insertVideo(video);
        int lastid = videoMapper.lastInsertId();
        String bv = Bv.get(lastid); //设置bv
        videoMapper.updateBv(bv, lastid);

        for (Play play : video.getPlayList()) {
            play.setBv(bv);
            playMapper.insertPlay(play);
        }
        return bv;
    }
}
