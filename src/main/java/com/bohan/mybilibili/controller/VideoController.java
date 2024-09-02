package com.bohan.mybilibili.controller;

import com.bohan.mybilibili.dto.Play;
import com.bohan.mybilibili.dto.Video;
import com.bohan.mybilibili.service.VideoService;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/video/{bv}")
    @ResponseBody
    public Video getVideo(@PathVariable("bv") String bv) {
        Video v = videoService.getVideo(bv);
        return v;
    }

    @RequestMapping("/videolist")
    @ResponseBody
    public List<Video> getVideoList() {
        return videoService.getAllVideo();
    }

    @RequestMapping("/publish")
    @ResponseBody
    public Map<String, String> upload(@RequestBody Video video) {    //用Video对象对应json
        String bv = videoService.publishVideo(video);
        return Map.of("bv", bv);
    }

//    @RequestMapping("/video/1")
//    @ResponseBody
//    public Video video1() {
//        List<Play> playList = List.of(
//                new Play("P1", "二分查找-演示", LocalTime.parse("00:05:46"), "74ec9692f6161386dfde236f664a15d0.mp4", "1"),  //play/1_1.mp4找不到
//                new Play("P2", "二分查找-实现", LocalTime.parse("00:06:47"), "1_2.mp4", "1")
//        );
//        System.out.println(playList.getClass());
//        return new Video("1", 0, "面试专题-基础篇", "itheima", "1.png", "original", "Learning", "基础篇introduction", LocalDateTime.now(),
//                List.of("Java", "IT", "面试"), playList);
//    }
//
//    @RequestMapping("/video/2")
//    @ResponseBody
//    public Video video2() {
//        List<Play> playList = List.of(
//                new Play("P1", "Java中的线程状态", LocalTime.parse("00:09:45"), "2_1.mp4", "2"),
//                new Play("P2", "代码演示1", LocalTime.parse("00:07:05"), "2_2.mp4", "2"),
//                new Play("P3", "代码演示2", LocalTime.parse("00:05:01"), "2_3.mp4", "2")
//        );
//        return new Video("2", 0, "面试专题-并发篇", "itheima", "2.png", "original", "Learning", "并发篇introduction", LocalDateTime.now(),
//                List.of("Java", "IT", "面试"), playList);
//    }
}
