package yl.lbnts.leetcode.algorithm;

public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        System.out.println(gcdOfStringsRecursion("ABCABC", "ABC"));
        System.out.println(gcdOfStringsRecursion("ABABAB", "ABAB"));
        System.out.println(gcdOfStringsRecursion("LEET", "CODE"));
        System.out.println(gcdOfStringsRecursion("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }

    public static String gcdOfStringsRecursion(String s1, String s2) {
        if (!(s1 + s2).equals(s2 + s1)) {
            return "";
        }
        return s1.substring(0, gcd(s1.length(), s2.length()));
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
