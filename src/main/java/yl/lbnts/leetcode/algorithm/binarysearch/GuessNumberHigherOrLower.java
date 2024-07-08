package yl.lbnts.leetcode.algorithm.binarysearch;

public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        System.out.println(new GuessGame(4).guess(5));
        System.out.println(new GuessGame(4).guess(3));
        System.out.println(new GuessGame(4).guess(4));
        System.out.println(new Solution(4).guessNumber(10));
        System.out.println(new Solution(6).guessNumber(10));
        System.out.println(new Solution(1).guessNumber(2));
        System.out.println(new Solution(1).guessNumber(3));
    }
}

class Solution extends GuessGame {
    public Solution(int guess) {
        super(guess);
    }

    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int guess = guess(middle);

            if (guess == -1)
                end = middle - 1;

            if (guess == 1)
                start = middle + 1;

            if (guess == 0)
                return middle;

        }

        return -1;
    }
}

