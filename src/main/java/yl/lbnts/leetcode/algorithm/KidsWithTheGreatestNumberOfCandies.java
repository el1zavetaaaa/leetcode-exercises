package yl.lbnts.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        System.out.println(kidsWithCandies(new int[]{12, 1, 12}, 10));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];

        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }

        List<Boolean> kidsWithCandies = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                kidsWithCandies.add(i, true);
            } else kidsWithCandies.add(i, false);
        }

        return kidsWithCandies;
    }
}
