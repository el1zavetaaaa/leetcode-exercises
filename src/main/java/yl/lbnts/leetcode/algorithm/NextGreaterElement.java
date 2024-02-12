package yl.lbnts.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
//        System.out.println("-------Brute Force Search-------");
//        System.out.println(Arrays.toString(bruteForceSearch(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
//        System.out.println(Arrays.toString(bruteForceSearch(new int[]{2, 4}, new int[]{1, 2, 3, 4})));

        System.out.println("\n-------Optimize Solution: Monotonic Stack & HashMap-------");
        System.out.println(Arrays.toString(monotonicStackAndHashMapSolution(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(monotonicStackAndHashMapSolution(new int[]{2, 4}, new int[]{1, 2, 3, 4})));

    }

    public static int[] monotonicStackAndHashMapSolution(int[] nums1, int[] nums2) {
        // int [] arr = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {

            if (stack.isEmpty()) {
                // arr[i] = -1;
                map.put(nums2[i], -1);
            } else if (!stack.isEmpty() && nums2[i] < stack.peek()) {
                // arr[i]= stack.peek();
                map.put(nums2[i], stack.peek());
            } else { // (!stack.isEmpty() && nums2[i]>= stack.peek())

                while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    // arr[i]= -1;
                    map.put(nums2[i], -1);
                } else {
                    // arr[i] = stack.peek();
                    map.put(nums2[i], stack.peek());
                }
            }
            stack.push(nums2[i]);
        }

        int ans[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static int[] bruteForceSearch(int[] nums1, int[] nums2) {
        int[] copyArr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if ((j + 1) < nums2.length) {
                        int insertEl = Math.max(-1, findMaxFromIndex(j, nums2));
                        copyArr[i] = insertEl;
                    } else {
                        copyArr[i] = -1;
                    }
                }
            }
        }
        return copyArr;

    }

    private static int findMaxFromIndex(int index, int[] arr) {
        int max = -2;
        int currentNum = arr[index];
        for (int i = index + 1; i < arr.length; i++) {
            if (currentNum < arr[i]) {
                max = arr[i];
                break;
            }
        }
        return max;
    }
}
