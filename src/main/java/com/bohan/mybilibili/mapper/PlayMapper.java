package com.bohan.mybilibili.mapper;

import com.bohan.mybilibili.dto.Play;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlayMapper {

    @Select("SELECT * from play where bv=#{bv};")
    List<Play> getPlayByBv(String bv);

    @Insert("INSERT into play (id, title, url, duration, bv) VALUES (#{id}, #{title}, #{url}, #{duration}, #{bv});")
    void insertPlay(Play play);

}
