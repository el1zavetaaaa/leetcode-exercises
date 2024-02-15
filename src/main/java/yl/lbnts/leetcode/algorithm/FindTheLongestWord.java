package yl.lbnts.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FindTheLongestWord {
    public static void main(String[] args) {

        System.out.println(getTheLongestWord("abppplee", Set.of("able", "ale", "apple", "bale", "kangaroo")));
    }

    public static String getTheLongestWord(String subseq, Set<String> words){

        String maxLengthWord = findTheLongestWord(words);

        if(isSubSequence(maxLengthWord, subseq)){
            return maxLengthWord;
        }

        words = remove(words, maxLengthWord);
        return getTheLongestWord(subseq, words);

    }

    private static boolean isSubSequence(String word, String subseq){
        char [] subseqCharArr = subseq.toCharArray();
        char [] wordCharArr = word.toCharArray();
        int j =0;
        for(int i =0; i< subseqCharArr.length; i++){
            if(j >= wordCharArr.length){
                break;
            }
            if(wordCharArr[j] == subseqCharArr[i]){
                j++;
            }
        }

        if(j == wordCharArr.length){
            return true;
        } else return false;
    }

    private static String findTheLongestWord(Set<String> words){
        String [] wordsArr = words.toArray(new String[words.size()]);
        String maxLengthWord = wordsArr[0];
        for(int i =0; i<wordsArr.length; i++){
            if(wordsArr[i].length() > maxLengthWord.length()){
                maxLengthWord = wordsArr[i];
            }
        }
        return maxLengthWord;
    }

    private static Set<String> remove(Set<String> words, String word) {
        HashSet<String> newSet = words.stream()
                .filter(current -> (!current.equals(word)))
                .collect(Collectors.toCollection(HashSet::new));
        return newSet;
    }

}
