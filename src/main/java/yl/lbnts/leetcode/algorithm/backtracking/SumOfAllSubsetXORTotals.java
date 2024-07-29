package yl.lbnts.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 1863. Sum of All Subset XOR Totals
 * The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
 * <p>
 * For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
 * Given an array nums, return the sum of all XOR totals for every subset of nums.
 * <p>
 * Note: Subsets with the same elements should be counted multiple times.
 * <p>
 * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3]
 * Output: 6
 * Explanation: The 4 subsets of [1,3] are:
 * - The empty subset has an XOR total of 0.
 * - [1] has an XOR total of 1.
 * - [3] has an XOR total of 3.
 * - [1,3] has an XOR total of 1 XOR 3 = 2.
 * 0 + 1 + 3 + 2 = 6
 * Example 2:
 * <p>
 * Input: nums = [5,1,6]
 * Output: 28
 * Explanation: The 8 subsets of [5,1,6] are:
 * - The empty subset has an XOR total of 0.
 * - [5] has an XOR total of 5.
 * - [1] has an XOR total of 1.
 * - [6] has an XOR total of 6.
 * - [5,1] has an XOR total of 5 XOR 1 = 4.
 * - [5,6] has an XOR total of 5 XOR 6 = 3.
 * - [1,6] has an XOR total of 1 XOR 6 = 7.
 * - [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
 * 0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
 * Example 3:
 * <p>
 * Input: nums = [3,4,5,6,7,8]
 * Output: 480
 * Explanation: The sum of all XOR totals for every subset is 480.
 */
public class SumOfAllSubsetXORTotals {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{5,1,6}));
    }

    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums, 0);
        int result = 0;
        for (List<Integer> list : resultList
        ) {
            int xor = 0;
            for (Integer current : list
            ) {
                xor ^= current;
            }
            result += xor;
        }
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add the current subset to the result
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]); // Include nums[i] in the current subset
            backtrack(result, tempList, nums, i + 1); // Recurse with the next elements
            tempList.remove(tempList.size() - 1); // Remove the last element (backtrack)
        }
    }

}
