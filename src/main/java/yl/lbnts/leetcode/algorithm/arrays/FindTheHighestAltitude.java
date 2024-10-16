package yl.lbnts.leetcode.algorithm.arrays;


public class FindTheHighestAltitude {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int altitude = 0;

        for (int j : gain) {
            altitude = altitude + j;
            if (altitude > max) {
                max = altitude;
            }
        }

        return max;
    }
}
