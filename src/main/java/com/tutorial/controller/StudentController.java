package com.tutorial.controller;

import com.tutorial.dao.StudentDao;
import com.tutorial.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jimmy on 2017/7/4.
 */
@RestController
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/saveStudent")
    public void save(){
        Student stu = new Student();
        stu.setName("Jimmy");
        stu.setAge(18);
        stu.setAddress("wuxi");
        final Student save = studentDao.save(stu);
        System.out.println(save);
        System.out.println(save.getId());
    }
}
