package com.jesse.learn.mybatis.custom;

public interface CustomExecutor {

    <T> T query(String statement, String parameter);
}
