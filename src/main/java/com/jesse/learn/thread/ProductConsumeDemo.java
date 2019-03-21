package com.jesse.learn.thread;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 生产者、消费者演示Demo
 * 采用wait()/notify()实现，注意点：采用线程原始调度机制时，要先梳理出共享变量和等待条件
 */
public class ProductConsumeDemo {

    public class MyQueue {

        private int limit;
        private Queue<Integer> queue;

        public MyQueue(int limit) {
            this.queue = new ArrayDeque<Integer>();
            this.limit = limit;
        }

        public synchronized Integer take() {
            while (queue.isEmpty()) {
                try {
                    System.out.println("take_1:" + limit);
                    this.wait();
                    System.out.println("take_2:" + limit);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Integer value = queue.poll();
            this.notifyAll();
            return value;
        }

        public synchronized void push(Integer value) {

            while (queue.size() == limit) {
                try {
                    System.out.println("push_1:" + value);
                    this.wait();
                    System.out.println("push_2:" + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            queue.offer(value);
            this.notifyAll();
        }
    }

    public class ProductThread extends Thread {

        private MyQueue myQueue;

        ProductThread(MyQueue myQueue) {
            this.myQueue = myQueue;
        }

        public void run() {

            int num = 0;
            while (true) {
                System.out.print("product:" + num + "  ");
                myQueue.push(num++);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public class ConsumeThread extends Thread {

        private MyQueue myQueue;

        ConsumeThread(MyQueue myQueue) {
            this.myQueue = myQueue;
        }

        public void run() {

            while (true) {
                System.out.print("consume:" + myQueue.take() + "  ");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void start() {
        MyQueue myQueue = new MyQueue(5);
        Thread prodThread = new ProductThread(myQueue);
        Thread consumeThread = new ConsumeThread(myQueue);
        prodThread.start();
        consumeThread.start();
    }

    public static void main(String[] args) {

        ProductConsumeDemo demo = new ProductConsumeDemo();
        demo.start();
    }
}
