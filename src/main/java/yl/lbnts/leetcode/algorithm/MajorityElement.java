package yl.lbnts.leetcode.algorithm;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[]{-1,1,1,1,2,1}));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> elementsCount = new HashMap<>();

        for (int num : nums) {
            if (elementsCount.isEmpty() || !elementsCount.containsValue(num)) {
                int count = countEl(nums, num);
                elementsCount.put(count, num);
            }
        }

        return elementsCount.get(Collections.max(elementsCount.keySet()));
    }

    private static int countEl(int[] nums, int el){
        return
                (int) Arrays.stream(nums).filter(numsEl -> el == numsEl).count();
    }
}
