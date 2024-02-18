package yl.lbnts.leetcode.algorithm;

import java.util.*;

public class ReplaceWords {

    public static void main(String[] args) {
        System.out.println(replaceWordsBruteForceSearch(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(replaceWordsUsingTrie(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }

    public static String replaceWordsBruteForceSearch(List<String> dictionary, String sentence) {
        List<String> sentenceArray = new ArrayList<>(List.of(sentence.split(" ")));

        List<Character> firstLettersInDict = new ArrayList<>();
        List<Character> firstLettersInSent = new ArrayList<>();
        List<Integer> indexesOfWordsMatchedByFirstLetters = new ArrayList<>();

        for (String string : dictionary) {
            firstLettersInDict.add(string.charAt(0));
        }

        for (String s : sentenceArray) {
            firstLettersInSent.add(s.charAt(0));
        }

        for (Character character : firstLettersInDict) {
            for (int j = 0; j < firstLettersInSent.size(); j++) {
                if (character == firstLettersInSent.get(j)) {
                    indexesOfWordsMatchedByFirstLetters.add(j);
                }
            }
        }

        if (indexesOfWordsMatchedByFirstLetters.isEmpty()) {
            return sentence;
        }

        for (int i = 0; i < sentenceArray.size(); i++) {
            Integer index = returnAnIndexOfWord(firstLettersInDict, sentenceArray.get(i).charAt(0));

            if (index != -1) {
                String currentEl = replaceWordWhetherItIsInTheDictionary(dictionary.get(index), sentenceArray.get(i));

                sentenceArray.set(i, currentEl);
            }
        }

        return String.join(" ", sentenceArray);

    }


    private static Integer returnAnIndexOfWord(List<Character> dict, Character sent) {
        for (int i = 0; i < dict.size(); i++) {
            if (dict.get(i).equals(sent)) {
                return i;
            }
        }

        return -1;
    }

    private static String replaceWordWhetherItIsInTheDictionary(String wordFromDict, String wordFromSent) {
        char[] dictionary = wordFromDict.toCharArray();
        char[] sentence = wordFromSent.toCharArray();

        String current = wordFromSent;

        int j = 0;
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i] == sentence[j]) {
                j++;
            }
        }

        if (j == dictionary.length) {
            current = wordFromDict;
        }

        return current;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap();
            endOfWord = false;
        }
    }

    static TrieNode root = new TrieNode();

    public static void insert(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            TrieNode node = current.children.get(c);
            if (node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public static String getRootWord(String word) {
        if (root.children.get(word.charAt(0)) == null)
            return word;

        TrieNode current = root;
        StringBuilder sb = new StringBuilder("");
        for (Character c : word.toCharArray()) {
            TrieNode node = current.children.get(c);
            sb.append(c);
            if (node == null)
                return word;
            else if (node != null && node.endOfWord) {
                return sb.toString();
            } else {
                current = node;
            }
        }
        return word;
    }

    public static String replaceWordsUsingTrie(List<String> dict, String sentence) {
        // build dictionary with trie
        dict.forEach(s -> insert(s));

        //iterate through all the words in sentence and check if smallest prefix root exist or not
        String[] sent = sentence.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < sent.length; i++) {
            sb.append(getRootWord(sent[i])).append(" ");
        }

        return sb.toString().trim();
    }

}


