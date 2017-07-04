package com.tutorial.dao;

import com.tutorial.pojo.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookDao extends MongoRepository<Book, Long> {
    /**
     * 通过name查询
     * @param name
     * @return
     */
    public List<Book> findByName(String name);
}
