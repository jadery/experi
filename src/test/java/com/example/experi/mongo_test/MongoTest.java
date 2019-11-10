package com.example.experi.mongo_test;

import com.example.experi.domain.MongoUser;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void test_insert_batch(){

        for(int i=0;i<100; i++){
            MongoUser mongoUser = new MongoUser();
            mongoUser.setUserNum(i);
            mongoUser.setUserName("小明"+i);
            MongoUser insert = mongoTemplate.insert(mongoUser);
            System.out.println(insert);

            MongoUser save = mongoTemplate.save(mongoUser);
        }
    }

    @Test
    public void test_get_seq(){

        Query query = new Query();
        Query with = query.addCriteria(Criteria.where("_id")
                .gte(new ObjectId("5d3ab60cd91c045af4d973ce"))
                .lte(new ObjectId("5d3ab60cd91c045af4d97431")))
                .with(new Sort(Sort.Direction.ASC, "_id"));

        List<MongoUser> mongoUsers = mongoTemplate.find(with, MongoUser.class);

        int i=0;
        System.out.println("开始");
        for(MongoUser mongoUser: mongoUsers){
            int userNum = mongoUser.getUserNum();
            if(i != userNum){
                System.out.println(mongoUser);
            }
            i++;
        }
        System.out.println("结束");
        System.out.println("i => " + i);
    }

}
