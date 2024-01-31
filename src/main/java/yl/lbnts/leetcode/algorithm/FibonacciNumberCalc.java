package yl.lbnts.leetcode.algorithm;

public class FibonacciNumberCalc {

    public static void main(String[] args) {
        System.out.println(fib(4));
        System.out.println(Fibonacci(4));
    }

    static int[] memo = new int[1000];

    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    private static int Fibonacci(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        int n0 = 0;
        int n1 = 1;
        int next;
        for (int i = 2; i <= n; i++) {
            next = n0 + n1;
            n0 = n1;
            n1 = next;
        }

        return n1;
    }
}
