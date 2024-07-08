package yl.lbnts.leetcode.algorithm;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("CM"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        final int stringLength = s.length();
        final int[] currentArr = new int[stringLength];
        int count = 0;

        while (count < stringLength) {
            char currentChar = s.charAt(count);
            int nextCharIndex = count + 1;

            if ((currentChar == 'I' || currentChar == 'X' || currentChar == 'C') && nextCharIndex < stringLength) {
                int currentInteger = specialRomansToInteger(currentChar, s.charAt(nextCharIndex));
                currentArr[count] = currentInteger;

                if(currentInteger == 1|| currentInteger == 10 || currentInteger == 100){
                    count ++;
                } else count+=2;

            } else {
                int currentInteger = romansToInteger(currentChar);
                currentArr[count] = currentInteger;

                count++;
            }
        }

        for(int i =0; i< currentArr.length; i++){
            result +=currentArr[i];
        }
        return result;
    }

    public static int romansToInteger(char currentChar) {
        int resultNumber = 0;
        switch (currentChar) {
            case 'I':
                resultNumber = 1;
                break;
            case 'V':
                resultNumber = 5;
                break;
            case 'X':
                resultNumber = 10;
                break;
            case 'L':
                resultNumber = 50;
                break;
            case 'C':
                resultNumber = 100;
                break;
            case 'D':
                resultNumber = 500;
                break;
            case 'M':
                resultNumber = 1000;
                break;

        }

        return resultNumber;
    }

    public static int specialRomansToInteger(char currentChar, char nextChar) {
        if (nextChar == '0') {
            return romansToInteger(currentChar);
        } else {
            if (currentChar == 'I') {
                if (nextChar == 'V') {
                    return 4;
                } else if (nextChar == 'X') {
                    return 9;
                } else return 1;
            } else if (currentChar == 'X') {
                if (nextChar == 'L') {
                    return 40;
                } else if (nextChar == 'C') {
                    return 90;
                } else return 10;
            } else if (currentChar == 'C') {
                if (nextChar == 'D') {
                    return 400;
                } else if (nextChar == 'M') {
                    return 900;
                } else return 100;
            }
        }
        return 0;
    }
}
