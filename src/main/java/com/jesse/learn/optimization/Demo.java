package com.jesse.learn.optimization;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * 参考：
 * https://zhuanlan.zhihu.com/p/41664893
 * https://gitee.com/AlanShelby/Course-Chapter/commit/9a02f152eb8999ec7ad43d733a1dc345368b4bfa
 */
public class Demo extends BaseJunitTest {

    @Autowired
    private RequestMerge requestMerge;

    private static final Integer SIZE = 100;

    private CountDownLatch countDownLatch = new CountDownLatch(SIZE);

    @Test
    public void requestMergeDemo() {

        for (int i = 0; i < SIZE; i++) {

            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    countDownLatch.await();
                    // requestMerge
                    ResponsCode responsCode = requestMerge.getByCode(finalI + "");
                    System.out.println("aaaaaaa: " + JSON.toJSONString(responsCode));
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println(Thread.currentThread().getName() + " 线程异常:" + e.getMessage());
                }
            });

            thread.setName("code" + i);
            thread.start();

            countDownLatch.countDown();
            Assert.isNull(null);
        }
    }


    public static void main(String[] args) {
        new Demo().requestMergeDemo();
    }
}
