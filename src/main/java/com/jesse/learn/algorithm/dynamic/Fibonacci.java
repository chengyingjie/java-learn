package com.jesse.learn.algorithm.dynamic;

/**
 * 斐波那契数列 / n级台阶，每次上1个或2个台阶，有多少种走法
 *
 * f(1)=1, f(2)=2, f(n)=f(n-1) + f(n-2) n>2
 */
public class Fibonacci {

    /**
     * 时间复杂度 O(n^2)
     *
     * @param n
     * @return
     */
    private int getFnValue(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return getFnValue(n-1) + getFnValue(n-2);
    }

    /**
     * 时间复杂度 O(n)
     *
     * @param n
     * @param remark
     * @return
     */
    private int getFnValueByOn(int n, int[] remark) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (remark[n] > 0) {
            return remark[n];
        }

        remark[n] = getFnValueByOn(n-1, remark) + getFnValueByOn(n-2, remark);
        return remark[n];
    }

    /**
     * 时间复杂度 O(1)
     *
     * @param n
     * @return
     */
    private int getFnValueO1(int n) {

        int prev = 1, cur = 2;
        for (int index = 3; index <= n; index++) {
            int sum = prev + cur;
            prev = cur;
            cur = sum;
        }

        return cur;
    }

    public static void main(String[] args) {

        int num = 5;
        Fibonacci fibonacci = new Fibonacci();

        // O(n^2) 复杂度
        System.out.println(fibonacci.getFnValue(num));

        // O(n) 复杂度
        int[] remark = new int[num+1];
        remark[1] = 1;
        remark[2] = 2;
        System.out.println(fibonacci.getFnValueByOn(num, remark));

        // O(1) 复杂度
        System.out.println(fibonacci.getFnValueO1(num));
    }

}
