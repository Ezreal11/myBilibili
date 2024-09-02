package com.bohan.mybilibili;

import com.bohan.mybilibili.dto.Student;
import com.bohan.mybilibili.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest //把单元测试类和Springboot联系起来，才能使用Autowired等功能
public class TestStudentMapper {

    @Autowired  //依赖注入获取Mapper对象
    private StudentMapper studentMapper;

    //测试入口使用@Test修饰，void返回值，方法名任意
    @Test
    public void test1() {
        //List<Student> students = studentMapper.findAll();   //调用mapper方法读取数据库
        List<Student> student = studentMapper.findById(1);
        for (Student s : student) {
            System.out.println(s.getName());
        }
    }

    @Test
    public void test2() {
        Student s = new Student(1,"Zhuyuhuan");
        studentMapper.update(s);
    }

    @Test
    public void test3() {
        //studentMapper.insert(2, "bohan");
        studentMapper.insert(new Student(4,"mika"));
    }

    @Test
    public void test4() {
        studentMapper.delete(3);
    }
}
