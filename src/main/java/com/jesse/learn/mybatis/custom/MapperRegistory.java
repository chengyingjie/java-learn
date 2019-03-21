package com.jesse.learn.mybatis.custom;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MapperRegistory {

    //用一个Map维护所有Mapper
    private final Map<Class<?>, MapperProxyFactory> knownMappers = new HashMap<Class<?>, MapperProxyFactory>();

    public <T> void addMapper(Class<T> clazz){
        knownMappers.put(clazz, new MapperProxyFactory(clazz));
    }

    /**
     * getMapper最底层执行者，获取mapper的MapperProxyFactory对象
     */
    public <T> T getMapper(Class<T> clazz, CustomSqlSession sqlSession) {
        MapperProxyFactory proxyFactory = knownMappers.get(clazz);
        if (proxyFactory == null) {
            throw new RuntimeException("Type: " + clazz + " can not find");
        }
        return (T)proxyFactory.newInstance(sqlSession);
    }

    /**
     * 内部类实现一个Factory生成Mapper的代理
     */
    public class MapperProxyFactory<T>{

        private Class<T> mapperInterface;

        public MapperProxyFactory(Class<T> mapperInterface) {
            this.mapperInterface = mapperInterface;
        }

        public T newInstance(CustomSqlSession sqlSession) {
            return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, new MapperProxy(sqlSession));
        }
    }
}
