package com.jesse.learn.thread;

/**
 * 模拟实现简易版 CountdownLatch
 *
 */
public class CountdownLatchDemo {

    private final static int COUNT = 1;

    public class MyLatch {

        private volatile int count;

        public MyLatch(int count) {
            this.count = count;
        }

        public synchronized void countdown() {
            if (--count == 0) {
                this.notifyAll();
            }
        }

        public synchronized void await() {
            while (count > 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class LatchThread extends Thread {

        private MyLatch myLatch;

        public LatchThread(MyLatch myLatch) {
            this.myLatch = myLatch;
        }

        public void run() {
            System.out.println(this.getName());
            myLatch.await();
        }

    }

    private void start() {

        MyLatch myLatch = new MyLatch(COUNT);
        Thread[] threads = new LatchThread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new LatchThread(myLatch);
            threads[i].setName("thread" + i);
            threads[i].start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myLatch.countdown();
    }


    public static void main(String[] args) {
        CountdownLatchDemo countdownLatch = new CountdownLatchDemo();
        countdownLatch.start();
    }

}
