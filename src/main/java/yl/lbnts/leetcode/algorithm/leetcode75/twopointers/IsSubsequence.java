package yl.lbnts.leetcode.algorithm.leetcode75.twopointers;

/**
 * 392. Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        char[] supposedSubsequence = s.toCharArray();
        char[] fullString = t.toCharArray();
        int subsequenceCounter = 0;
        int fullStringCounter = 0;

        while (subsequenceCounter < s.length() && fullStringCounter < t.length()) {
            if (supposedSubsequence[subsequenceCounter] == fullString[fullStringCounter]) {
                subsequenceCounter++;
            }
            fullStringCounter++;
        }

        return subsequenceCounter == s.length();
    }
}
