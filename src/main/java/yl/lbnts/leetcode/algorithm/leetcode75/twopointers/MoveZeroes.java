package yl.lbnts.leetcode.algorithm.leetcode75.twopointers;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 */
public class MoveZeroes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Arrays.stream(moveZeroes(new int[]{0, 1, 0, 3, 12})).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(moveZeroes(new int[]{0, 0, 1})).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(moveZeroes(new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1})).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(moveZeroes(new int[]{1})).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(moveZeroes(new int[]{1, 0})).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(moveZeroes(new int[]{0, 1})).toArray()));
        System.out.println(Arrays.toString(Arrays.stream(moveZeroesBetterApproach(new int[]{0, 1, 0, 3, 12})).toArray()));

    }

    public static int[] moveZeroes(int[] nums) {
        int k = 0;
        if (nums.length > 1) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) {
                    reArrangeArray(nums, j, k);
                    k++;
                }
            }
        }
        return nums;
    }

    public static void reArrangeArray(int[] nums, int index, int nonZeroEl) {
        if (index != nonZeroEl) {
            nums[nonZeroEl] = nums[index];
            nums[index] = 0;

        }
    }

    public static int[] moveZeroesBetterApproach(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
        return nums;
    }
}
