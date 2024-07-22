package yl.lbnts.leetcode.algorithm.priorityqueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in)
 * <p>
 * Example 1:
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * <p>
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        System.out.println(kClosest(new int[][]{new int[]{1, 3}, new int[]{-2, 2}}, 1));
        System.out.println(kClosest(new int[][]{new int[]{0, 1}, new int[]{1, 0}}, 2));
        System.out.println(kClosest(new int[][]{new int[]{3, 3}, new int[]{5, -1}, new int[]{-2, 4}}, 2));
        System.out.println(kClosest(new int[][]{new int[]{2, 2}, new int[]{2, 2}, new int[]{2, 2}, new int[]{2, 2}, new int[]{2, 2}, new int[]{2, 2}, new int[]{1, 1}}, 1));
        System.out.println(kClosest(new int[][]{new int[]{6, 10}, new int[]{-3, 3}, new int[]{-2, 5}, new int[]{0, 2}}, 3));
    }

    public static int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                double distanceA = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
                double distanceB = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
                return Double.compare(distanceA, distanceB);
            }
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        int[][] result = new int[k][2];

        Collections.addAll(pq, points);

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
        return result;
    }

    private static int findIndex(List<Double> distances, double value) {
        for (int i = 0; i < distances.size(); i++) {
            if (value == distances.get(i)) {
                return i;
            }
        }
        return 0;
    }

}