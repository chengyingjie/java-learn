package com.jesse.learn.optimization;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
//@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})  //加载配置文件,这里写你自己的spring配置文件的存放目录
@ContextConfiguration(classes = SpringConfiguration.class)
public class BaseJunitTest {


}
