package com.jesse.learn.mybatis.custom;


import com.jesse.learn.mybatis.demo.KolDao;

import java.util.HashMap;
import java.util.Map;

public class CustomConfiguration {

    public final MapperRegistory mapperRegistory = new MapperRegistory();

    public static final Map<String, String> mappedStatements = new HashMap<String, String>();

    //初始化时Configuration加载所有Mapper方法与Sql语句
    public CustomConfiguration() {
        mapperRegistory.addMapper(KolDao.class);
        mappedStatements.put("com.jesse.learn.mybatis.demo.KolDao.getKolById"
                , "select * from spotlight_kol where id = %d");
    }

    //MapperProxy根据statementName查找是否有对应SQL
    public boolean hasStatement(String statementName) {
        return mappedStatements.containsKey(statementName);
    }

    //MapperProxy根据statementID获取SQL
    public String getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public <T> T getMapper(Class<T> clazz, CustomSqlSession sqlSession) {
        return mapperRegistory.getMapper(clazz, sqlSession);
    }
}
