package com.bohan.mybilibili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MyBilibiliApplication { //implements WebMvcConfigurer {

    //作用是把url路径映射到磁盘目录
    //http://localhost:8080/play/xxx => static/play
    //http://localhost:8080/play/xxx => C:/aaa
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/play/**").addResourceLocations("file:C:/Users/Bohan Wang/Desktop/Java/Resources");
//    }

    public static void main(String[] args) {
        SpringApplication.run(MyBilibiliApplication.class, args);
    }

}
