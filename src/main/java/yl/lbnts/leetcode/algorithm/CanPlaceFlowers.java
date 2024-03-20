package yl.lbnts.leetcode.algorithm;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
        System.out.println(canPlaceFlowers(new int[]{0}, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int k = 1;
        int j = 2;

        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) {
            return true;
        }

        if (flowerbed[i] == 0 && flowerbed[k] == 0) {
            flowerbed[i] = 1;
            n--;
            i++;
            k++;
            j++;
        }

        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            n--;
        }

        while (i < flowerbed.length && k < flowerbed.length && j < flowerbed.length) {
            if (flowerbed[i] == 0 && flowerbed[k] == 0 && flowerbed[j] == 0) {
                flowerbed[k] = 1;
                n = n - 1;
            }
            i++;
            k++;
            j++;
        }


        return n <= 0;

    }
}
