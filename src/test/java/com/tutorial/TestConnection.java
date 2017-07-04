package com.tutorial;

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.junit.Test;

import java.util.Set;

/**
 * Created by YSTen on 2017/7/4.
 */
public class TestConnection {

    @Test
    public void testConnection(){
        // 连接到 mongodb 服务
        Mongo mongo = new Mongo("192.168.50.21", 27017);
        //根据mongodb数据库的名称获取mongodb对象 ,
        DB db = mongo.getDB( "test" );
        Set<String> collectionNames = db.getCollectionNames();
        // 打印出test中的集合
        for (String name : collectionNames) {
            System.out.println("collectionName==="+name);
        }
    }
}
