package com.bohan.mybilibili;

import com.bohan.mybilibili.dto.Play;
import com.bohan.mybilibili.dto.Video;
import com.bohan.mybilibili.mapper.PlayMapper;
import com.bohan.mybilibili.mapper.VideoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import util.Bv;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TestVideoMapper {
    @Autowired
    VideoMapper videoMapper;

    @Autowired
    PlayMapper playMapper;

    @Test
    public void test1() {
        Video v = videoMapper.getVideoByBv("1");
        System.out.println(v.toString());
    }

    @Test
    public void test2() {
        List<Play> playByBv = playMapper.getPlayByBv("1");
        System.out.println(playByBv.toString());
    }

    @Test
    public void test3() {
        Video v = new Video();
        v.setType("自制");
        v.setCategory("游戏");
        v.setAuthor("bohan");
        v.setCover("0afa7cea7a477eab5d764ce34f289551.png");
        v.setIntroduction("bfv gaming");
        v.setPublishTime(LocalDateTime.now());
        v.setTags("游戏_战地");
        v.setTitle("战地5游戏片段");

        videoMapper.insertVideo(v);

        System.out.println(videoMapper.lastInsertId());
        videoMapper.updateBv(Bv.get(videoMapper.lastInsertId()), videoMapper.lastInsertId());

    }

}
