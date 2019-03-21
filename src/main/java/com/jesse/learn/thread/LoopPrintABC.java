package com.jesse.learn.thread;

public class LoopPrintABC {

    public class PrintTread extends Thread {

        private String value;
        private Object beforeLock;
        private Object currentLock;

        public PrintTread(String value, Object beforeLock, Object currentLock) {
            this.value = value;
            this.beforeLock = beforeLock;
            this.currentLock = currentLock;
        }


        public void run() {

            for (int i = 0; i < 10;i++) {
                synchronized (this.beforeLock) {
                    synchronized (this.currentLock) {
                        System.out.print(this.value);
                        this.currentLock.notify();
                    }

                    try {
                        this.beforeLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printABC() {
        Object lockA = new Object();
        Object lockB = new Object();
        Object lockC = new Object();

        Thread threadA = new PrintTread("A", lockC, lockA);
        Thread threadB = new PrintTread("B", lockA, lockB);
        Thread threadC = new PrintTread("C", lockB, lockC);

        try {
            threadA.start();
            Thread.sleep(200);

            threadB.start();
            Thread.sleep(200);

            threadC.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        LoopPrintABC loopPrint = new LoopPrintABC();
        loopPrint.printABC();
    }
}
