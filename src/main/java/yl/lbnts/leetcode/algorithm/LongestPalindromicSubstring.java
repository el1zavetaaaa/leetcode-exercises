package yl.lbnts.leetcode.algorithm;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int i = 0;
        int k = 0;
        String[] palindromeArr = new String[s.length()];
        while (k < s.length()) {
            String currentStr = s.substring(k, i);
            if (isPalindromePossible(currentStr)) {
                if (palindromeArr[k] == null) {
                    palindromeArr[k] = currentStr;
                }
                if (palindromeArr[k] != null && currentStr.length() > palindromeArr[k].length()) {
                    palindromeArr[k] = currentStr;
                }
            }
            if (i == s.length()) {
                k++;
                i = k + 1;
            } else {
                i++;
            }
        }

        int max = palindromeArr[0].length();
        String longestStr = palindromeArr[0];

        for (int j = 0; j < palindromeArr.length; j++) {
            if (palindromeArr[j] != null && palindromeArr[j].length() > max) {
                max = palindromeArr[j].length();
                longestStr = palindromeArr[j];
            }
        }
        return longestStr;
    }

    public static boolean isPalindromePossible(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
