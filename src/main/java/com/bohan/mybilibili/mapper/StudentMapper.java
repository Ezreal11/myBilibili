package com.bohan.mybilibili.mapper;

import com.bohan.mybilibili.dto.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //表示用于数据库增删改查的接口
//实现类(mybatis和spring)，通过依赖注入(@Autowired)获取实现类对象
public interface StudentMapper {

    //执行sql语句查询Student
    @Select("SELECT id, name FROM student;")
    List<Student> findAll();

    @Select("SELECT id, name FROM student where id=#{id};")
    //${id} id来自方法参数
    List<Student> findById(int id);     //String也可以

    //新增学生
    @Insert("INSERT into student(id, name) values(#{id}, #{name});")
    //void insert(@Param("id") int i, @Param("name") String n);   //多个参数需要让方法参数对应sql语句变量
    void insert(Student student);     //也可，不用加@Param了

    @Update("UPDATE student set name=#{name} where id=#{id};")  //不能是#{student.id}
    void update(Student student);

    @Delete("DELETE from student where id=#{id};")
    void delete(int id);

}
