package yl.lbnts.leetcode.algorithm;

import java.math.BigInteger;


/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 */

public class PlusOne {
    public static void main(String[] args) {
        System.out.print(plusOne(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6}));
        System.out.print(plusOneAlternative(new int[]{9,8,9, 9}));
    }

    public static int[] plusOne(int[] digits) {
        final StringBuilder currentNum = new StringBuilder();

        for (int digit : digits) {
            currentNum.append(digit);
        }

        final BigInteger currentSum = new BigInteger(currentNum.toString());
        final BigInteger currentSumPlusOne = currentSum.add(new BigInteger("1"));

        final StringBuilder returnedArrStringBuilder = new StringBuilder();
        returnedArrStringBuilder.append(currentSumPlusOne);

        int[] returnedArr = new int[returnedArrStringBuilder.length()];

        for (int j = 0; j < returnedArrStringBuilder.length(); j++) {
            returnedArr[j] = Integer.parseInt(String.valueOf(returnedArrStringBuilder.charAt(j)));
        }
        return returnedArr;
    }

    public static int[] plusOneAlternative(int[] digits) {
        int lastDigit = digits[digits.length-1];
        if(lastDigit == 9){
            if(digits.length==1){
                return new int[]{1,0};
            }

            if(digits[digits.length-2] + 1 > 9 && areAllNumbersNines(digits)){
                int[] finalArr = new int[digits.length + 1];
                finalArr[0] = 1;
                for(int i =1; i< finalArr.length; i++){
                    finalArr[i] = 0;
                }

                return finalArr;
            }

            for(int k =digits.length -1; k >= 0; k--){
                if(digits[k]!=9){
                    digits[k] += 1;
                    for(int i =k+1; i< digits.length; i++){
                        digits[i] = 0;
                    }
                    return digits;
                }
            }
            digits[digits.length -2] += 1;
            digits[digits.length -1] =0;

        } else digits[digits.length-1] ++;
        for(int digit : digits){
            System.out.println(digit);
        }
        return digits;
    }

    private static boolean areAllNumbersNines(int[]digits){
        int digitLength = digits.length;
        int count =0;
        for(int k =digits.length -1; k >= 0; k--) {
            if (digits[k] == 9) {
                count ++;
            }

            if(count == digitLength){
                return true;
            }
        }
        return false;
    }

}
