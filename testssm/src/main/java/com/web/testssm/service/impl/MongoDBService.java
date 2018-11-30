package com.web.testssm.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/11/30
 */
@Service("mongoDBService")
public class MongoDBService {
    /*@Resource(name = "mongoTemplate")
    protected MongoTemplate mongoTemplate;*/


    /**
     *
     * @param query
     * @param entityClass
     * @return T
     */
    public <T> T findOne(Query query, Class<T> entityClass)
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("mongoDB.xml");
        MongoTemplate mongoTemplate= (MongoTemplate) context.getBean("mongoTemplate");
        // 可以直接调用
        return mongoTemplate.findOne(query, entityClass);
    }
}
