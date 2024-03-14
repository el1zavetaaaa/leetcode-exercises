package yl.lbnts.leetcode.algorithm;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        final StringBuilder result = new StringBuilder();
        char [] arr1 = word1.toCharArray();
        char [] arr2 = word2.toCharArray();

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < arr1.length & pointer2 < arr2.length) {

                result.append(arr1[pointer1]);
                pointer1++;

                result.append(arr2[pointer2]);
                pointer2++;
        }

        if(word1.length() < word2.length()){
            result.append(word2.substring(pointer2));
        } else result.append(word1.substring(pointer1));

        return result.toString();

    }
}
