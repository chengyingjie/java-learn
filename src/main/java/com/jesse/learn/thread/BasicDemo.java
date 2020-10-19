package com.jesse.learn.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BasicDemo {

    public class DemoThread extends Thread {

        public void run() {
            System.out.println("demoThread.run");
        }
    }

    public class RunnableThread implements Runnable {
        @Override
        public void run() {
            System.out.println("runnableThread.run");
        }
    }

    public class CallabeThread implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }

    public static void main(String[] args) {
        BasicDemo basicDemo = new BasicDemo();
        basicDemo.createThread();
    }

    public void createThread() {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(() -> new Runnable() {
            @Override
            public void run() {
                System.out.println("createThread.run: implements runnable");
            }
        });

        executorService.execute(() -> {
                System.out.println("createThread.run: implements runnable");
        });


        executorService.execute(new DemoThread());
        executorService.execute(new RunnableThread());

        Future<Integer> future = executorService.submit(new CallabeThread());





    }
}
