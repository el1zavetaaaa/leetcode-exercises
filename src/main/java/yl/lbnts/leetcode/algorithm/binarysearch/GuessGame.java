package yl.lbnts.leetcode.algorithm.binarysearch;

public class GuessGame {
    private int guess;

    public GuessGame(int guess) {
        this.guess = guess;
    }

    public int guess(int num) {
        if (guess < num) {
            return -1;
        } else if (guess > num) {
            return 1;
        }

        return 0;
    }
}
