package com.tutorial.controller;

import com.tutorial.dao.BookDao;
import com.tutorial.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    //save
    @RequestMapping("/saveBook")
    public void saveBook(){
        //清空
        bookDao.deleteAll();
        //
        Book book = new Book();
     //   book.setId(1L);
        book.setName("java");
        book.setPrice(99.0F);
        bookDao.save(book);
    }
    //save batch
    //save
    @RequestMapping("/saveBatchBook")
    public void saveBatchBook(){
        List<Book> list = new ArrayList<Book>();
        Book book = null;
        for(Long i=2L;i<10L;i++){
            book = new Book();
         //   book.setId(i);
            book.setName("java");
            book.setPrice(99.0F);
            list.add(book);
        }
        for(Long i=10L;i<15L;i++){
            book = new Book();
            book.setId(i);
            book.setName("php");
            book.setPrice(87.0F);
            list.add(book);
        }
            bookDao.save(list);
    }

    //findAll
    @RequestMapping("/findAll")
    public List<Book> findAll(){
        return bookDao.findAll();
    }

    //findByName
    @RequestMapping("/findByName")
    public List<Book> findByName(){
        return bookDao.findByName("java");
    }

    //delete
    @RequestMapping("/deleteById")
    public void deleteById(){
        Book book = bookDao.findOne(1L);
        System.out.println("book---"+book);
        bookDao.delete(book);
        System.out.println(bookDao.findOne(1L));
    }
}
