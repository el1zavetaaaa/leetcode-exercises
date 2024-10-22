package yl.lbnts.leetcode.algorithm.arrays;

import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements {
    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1,2,3,2}));
    }

    public static int sumOfUnique(int[] nums) {
        Map<Integer, Integer>
                keys = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            keys.put(nums[i], keys.getOrDefault(nums[i], 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: keys.entrySet()
             ) {
            if(entry.getValue() == 1){
                sum+= entry.getKey();
            }
        }
        return sum;
    }
}
