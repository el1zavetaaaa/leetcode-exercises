package yl.lbnts.leetcode.algorithm.leetcode75.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.*;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("ai"));
        System.out.println(reverseVowels("aA"));
    }
    public static String reverseVowels(String s) {
        List<Character> chars = new ArrayList<>(of('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'));

        char[] arr = s.toCharArray();

        int i = 0;
        int k = arr.length -1;
        StringBuilder result = new StringBuilder();
        char current1st;


        while (i<k){
            if(chars.contains(arr[i]) && chars.contains(arr[k])){
                current1st = arr[i];
               arr[i] = arr[k];
               arr[k] = current1st;
               i++;
               k--;
            }
            else if(chars.contains(arr[i])){
                k--;
            }
            else i++;
        }

        for (int j = 0; j < arr.length; j++) {
            result.append(arr[j]);
        }

        return result.toString();
    }
}
