package yl.lbnts.leetcode.algorithm;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(])"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> parentheses = Map.of(')', '(', ']', '[', '}', '{');
        Stack<Character> stringChars= new Stack<>();

        int sLength = s.length();

        for(int i=0; i< sLength; i++){
            char currenChar = s.charAt(i);
            for (Character ch: parentheses.values()) {
                if(currenChar == ch){
                    stringChars.push(currenChar);
                }
            }

                for (Character ch2 : parentheses.keySet()) {
                    if (currenChar == ch2) {
                        if(stringChars.empty()){
                            return false;
                        }
                        if (parentheses.get(currenChar) == stringChars.peek()) {
                            stringChars.pop();
                        } else return false;
                    }
                }
            }
        return stringChars.empty();
    }
}
