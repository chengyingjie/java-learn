package com.jesse.learn.mybatis.custom;

import com.jesse.learn.mybatis.demo.KolDao;

public class TestMybatis {

    public static void main(String[] args) {
        CustomSqlSession sqlSession = new CustomSqlSession(new CustomConfiguration(), new CustomDefaultExecutor());
        KolDao kolDao = sqlSession.getMapper(KolDao.class);
        System.out.println(kolDao.getKolById(1L));
    }
}
