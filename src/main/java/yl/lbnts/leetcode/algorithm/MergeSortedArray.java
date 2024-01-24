package yl.lbnts.leetcode.algorithm;

import java.util.Arrays;

import static java.lang.String.format;

public class MergeSortedArray {
    public static void main(String[] args) {
       mergeSolution(new int[]{1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsWithoutZeros1 =returnCurrentArrWithoutZeros(nums1, m);
        nums2 = returnCurrentArrWithoutZeros(nums2, n);

        nums1 = new int[m+n];

        for(int i =0; i< m; i++){
            nums1[i] = numsWithoutZeros1[i];
        }


        for(int k = 0; k< n; k++){
            nums1[k+m] = nums2[k];
        }

        for(int f=1; f< nums1.length; f++){
            if(nums1[f] < nums1[f-1]){
                int val = nums1[f-1];
                nums1[f-1] = nums1[f];
                nums1[f] = val;
            }
        }


        System.out.println("----nums1------");
        for(int digit: nums1){
            System.out.println(digit);
        }
        System.out.println(nums1.length);

        System.out.println("----nums2------");
        for(int digit: nums2){
            System.out.println(digit);
        }
        System.out.println(nums2.length);
    }

    public static int[] returnCurrentArrWithoutZeros(int[] nums, int length){
        int[] currentArr;
        if(length!=0){
            currentArr = new int[length];
        } else currentArr = new int[]{};

        for(int k=0; k<nums.length; k++){
            if(nums[k] != 0){
                currentArr[k] = nums[k];
            }
        }

        return currentArr;
    }

    public static void mergeSolution(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int pMerge = m + n - 1;

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[pMerge--] = nums1[p1--];
            } else {
                nums1[pMerge--] = nums2[p2--];
            }
        }
    }
}
