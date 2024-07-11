package yl.lbnts.leetcode.algorithm.leetcode75.arraysandstrings;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[]{0, 1, 1, 3, 3}, 4));
        System.out.println(findMaxAverage(new int[]{8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244, -809, 8025, -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406, -6300, -275, -1908, 67, 3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429, 160, -9234, -4444, 3586, -5711, -9506, -79, -4418, -4348, -5891}, 93));
        System.out.println(findMaxAverage(new int[]{5}, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1 && k == 1) {
            return nums[0];
        }

        int firstCount = 0;
        int subArrayLength = k;
        int start = 0;
        for (int i = start; i < subArrayLength; i++) {
            firstCount += nums[i];
        }
        double average = (double) firstCount / k;
        start += 1;
        subArrayLength += 1;

        while (subArrayLength <= nums.length && subArrayLength - start == k) {
            int current = 0;
            for (int i = start; i < subArrayLength; i++) {
                current += nums[i];
            }

            double currentAverage = (double) current / k;

            if (currentAverage > average) {
                average = currentAverage;
            }
            start += 1;
            subArrayLength += 1;
        }

        return average;
    }
}
