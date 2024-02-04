package yl.lbnts.leetcode.algorithm;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {

            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < dp.length; i++) {

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
