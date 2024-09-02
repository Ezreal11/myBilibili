package com.bohan.mybilibili.mapper;

import com.bohan.mybilibili.dto.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VideoMapper {
    //根据bv查询Video
    @Select("SELECT * from video where bv=#{bv};")
    Video getVideoByBv(String bv);

    @Select("SELECT * from video;")
    List<Video> getAllVideo();

    @Insert("""
            INSERT into video (type, category, title, cover, introduction, publish_time, tags)
            Values (#{type}, #{category}, #{title}, #{cover}, #{introduction}, #{publishTime},#{tags})
            """)
    void insertVideo(Video video);

    @Select("Select  last_insert_id()")
    int lastInsertId();

    // 更新 bv 号
    @Update("update video set bv=#{bv} where id=#{id}")
    void updateBv(@Param("bv") String bv, @Param("id") int id);

}
