package com.tutorial.dao;

import com.tutorial.pojo.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jimmy on 2017/7/4.
 */
public interface StudentDao extends MongoRepository<Student,String>{

}
