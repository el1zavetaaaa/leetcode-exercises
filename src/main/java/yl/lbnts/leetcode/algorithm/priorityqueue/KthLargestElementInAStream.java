package yl.lbnts.leetcode.algorithm.priorityqueue;

public class KthLargestElementInAStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 3, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));

        KthLargest kthLargest2 = new KthLargest(1, new int[]{});
        System.out.println(kthLargest2.add(-3));
        System.out.println(kthLargest2.add(-2));
        System.out.println(kthLargest2.add(-4));
        System.out.println(kthLargest2.add(0));
        System.out.println(kthLargest2.add(4));
    }
}

class KthLargest {

    private int k;
    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new int[k];
        if (nums.length == 0) {
            this.nums = new int[1];
            this.nums[0] = Integer.MIN_VALUE;
        } else {
            this.nums[this.nums.length - 1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (val > nums[i]) {
                nums = moveArrayIndexes(nums, i, val);
                break;
            }
        }
        return nums[0];
    }

    private int[] moveArrayIndexes(int[] nums, int index, int lastVal) {
        if (index == 0) {
            nums[index] = lastVal;
            return nums;
        } else {

            int[] copyNums = new int[nums.length + 1];
            for (int i = 0; i <= index; i++) {
                copyNums[i] = nums[i];
            }
            copyNums[index + 1] = lastVal;
            for (int i = index + 1; i < nums.length; i++) {
                copyNums[i + 1] = nums[i];
            }
            int[] finalCopy = new int[nums.length];
            for (int i = 0; i < finalCopy.length; i++) {
                finalCopy[i] = copyNums[i + 1];
            }
            return finalCopy;
        }
    }
}
