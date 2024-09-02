package com.bohan.mybilibili.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Controller
public class UploadController {
    @Value("${video-path}")
    private String videoPath;
    @Value("${img-path}")
    private String imgPath;

    //处理上传文件
    @RequestMapping("/upload")
    @ResponseBody   //参数名由前端指定,顺序不影响 MultipartFile上传二进制数据类型
    public Map<String, String> upload(int i, int chunks, MultipartFile data, String url) throws IOException {
        System.out.println(i + " " + chunks + " " + data + " " + url);
        //把数据文件存下来，data: url.part{i}
        data.transferTo(Path.of(videoPath, url + ".part" + i));
        return Map.of(url, i/(double)chunks*100 + "%");
    }

    @RequestMapping("/finish")
    @ResponseBody
    public void finish(int chunks, String url) throws IOException {
        //合并数据块，找到所有part合并  FileOutputStream必须关闭，最好用try with resources
        try (FileOutputStream fos = new FileOutputStream(videoPath + url)){
            //写入新文件
            for (int i = 1; i <= chunks; i++) {
                Path parti = Path.of(videoPath, url + ".part" + i);//Path.of可以补全/
                Files.copy(parti, fos);         //parti复制到目标文件
                Files.deleteIfExists(parti);    //parti.toFile().delete();
            }
        }
        //自动finally fos.close()
        System.out.println(url + " upload finished!");
    }

    @RequestMapping("/uploadCover")
    @ResponseBody
    public Map<String, String> uploadCover(MultipartFile data, String cover) throws IOException {
        data.transferTo(Path.of(imgPath, cover));
        return Map.of("cover", cover);
    }
}
