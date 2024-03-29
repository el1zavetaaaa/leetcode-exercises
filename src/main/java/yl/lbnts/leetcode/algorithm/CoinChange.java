package yl.lbnts.leetcode.algorithm;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinCountGreedyAlgorithms(new int[]{1,2,5}, 11));
        System.out.println(coinCountGreedyAlgorithms(new int[]{2}, 3));
        System.out.println(coinCountGreedyAlgorithms(new int[]{1}, 0));

        System.out.println(coinChangeDynamicProgramming(new int[]{2}, 3));
        System.out.println(coinChangeDynamicProgramming(new int[]{1,2,5}, 11));
        System.out.println(coinChangeDynamicProgramming(new int[]{1}, 0));
        System.out.println(coinChangeRecursion(new int[]{1,2,5}, 11));

    }


    public static int coinChangeDynamicProgramming(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {

                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }


    public static int coinChangeRecursion(int[] coins, int amount) {

        int ans = coinCount(coins, amount);
        return (ans == Integer.MAX_VALUE) ?  -1 : ans;
    }
    private static int coinCount(int[] coins, int amount) {

        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return Integer.MAX_VALUE;
        }

        int minCoins = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++) {
            int ans = coinCount(coins, amount - coins[i]);

            if(ans != Integer.MAX_VALUE) {
                //we have returned 0 in ans, so now we are updating the ans count
                //hence 1 + ans
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        return minCoins;
    }
    public static int coinCountGreedyAlgorithms(int[] coins, int amount) {
        int currentAmount = amount;

        if(amount == 0){
            return 0;
        }

        if(coins.length == 1 && amount<coins[0]){
            return -2;
        }

        int max  = findMax(coins);

        if(max <= amount){
            currentAmount=currentAmount-max;
            return 1 + coinCountGreedyAlgorithms(coins, currentAmount);
        }


        coins = deleteEl(max, coins);
        return coinCountGreedyAlgorithms(coins, currentAmount);
    }


    private static int findMax(int[] coins){
        int max = coins[0];
        for(int i =0; i<coins.length; i++){
            if(coins[i] > max){
                max  = coins[i];
            }
        }

        return max;
    }

    private static int[] deleteEl(int rm_el, int[] array){
        int [] copyArr = new int[array.length-1];

        for(int i =0, k =0; i< array.length; i++){

            if(array[i] == rm_el){
                continue;
            }

            copyArr[k++] = array[i];
        }

        return copyArr;
    }

}
