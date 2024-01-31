package yl.lbnts.leetcode.algorithm;

import java.util.Arrays;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

public class ClimbingStairs {
    public static void main(String[] args) {
        int[] memo = new int[46];
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs2(memo, 44));
    }

    private static int climbStairs(int n) {
        int[] term = new int[46];

        if (n == 1 || n == 2) {
            return n;
        }
        if (term[n] != 0) {
            return term[n];

        } else {
            term[n] = climbStairs(n - 1) + climbStairs(n - 2);
            return term[n];
        }
    }


    private static int climbStairs2(int[] memo, int n) {
        Arrays.fill(memo, -1);
        return step(memo, n);
    }

    private static int step(int[] memo, int n) {
        if (n < 0) return 0;
        if (memo[n] != -1) return memo[n];
        if (n == 0) {
            return 1;
        }
        int s1 = step(memo, n - 1);
        int s2 = step(memo, n - 2);

        memo[n] = s1 + s2;
        return memo[n];
    }
}
