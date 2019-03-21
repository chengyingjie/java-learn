package com.jesse.learn.thread;

/**
 * 同时开始demo，模拟CountdownLatch
 * 共享变量：boolean变量；等待条件：boolean变量值为true
 */
public class StartAtTheSameTimeDemo {

    public class WaitCondition {

        private volatile boolean start = false;

        private synchronized void wating() {
            while (!start) {
                try {
                    this.wait();
                    System.out.println("go away...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private synchronized void fireWait() {
            this.start = true;
            this.notifyAll();
        }
    }

    public class WaitThread extends Thread {

        private WaitCondition waitCondition;

        public WaitThread(WaitCondition waitCondition) {
            this.waitCondition = waitCondition;
        }

        public void run() {
            System.out.println(this.getName() + " coming...");
            this.waitCondition.wating();
        }
    }

    private void start() {

        WaitCondition waitCondition = new WaitCondition();

        Thread threadA = new WaitThread(waitCondition);
        threadA.setName("threadA");
        Thread threadB = new WaitThread(waitCondition);
        threadB.setName("threadB");
        Thread threadC = new WaitThread(waitCondition);
        threadC.setName("threadC");
        Thread threadD = new WaitThread(waitCondition);
        threadD.setName("threadD");
        Thread threadE = new WaitThread(waitCondition);
        threadE.setName("threadE");

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitCondition.fireWait();
    }

    public static void main(String[] args) {

        StartAtTheSameTimeDemo demo = new StartAtTheSameTimeDemo();
        demo.start();
    }
}
