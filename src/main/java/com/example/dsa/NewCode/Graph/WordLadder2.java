package com.example.dsa.NewCode.Graph;

import java.util.*;

public class WordLadder2 {

    public static List<List<String>> findSequence(String startWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        Set<String> elemUsedInLastLevel = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(Arrays.asList(startWord));

        int level = 0;
        while (!queue.isEmpty()) {

            List<String> list = queue.poll();
            String lastString = list.get(list.size() - 1);

            if (queue.size() > level) {
                level++;
                // erase all the words from set that are used in last level, before processing
                // further
                for (var wrdUsd : elemUsedInLastLevel)
                    set.remove(wrdUsd);
            }

            // Move this block outside the level check block
            if (lastString.equals(endWord)) {
                result.add(list);
            }

            checkNextWord(lastString, set, list, queue, elemUsedInLastLevel);
        }

        return result;
    }

    private static void checkNextWord(String currentWord, Set<String> set, List<String> list,
            Queue<List<String>> queue, Set<String> wordUsed) {
        for (int i = 0; i < currentWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {

                var chArr = currentWord.toCharArray();
                chArr[i] = ch;
                String newWord = String.valueOf(chArr);

                if (set.contains(newWord)) {
                    List<String> newList = new ArrayList<>(list); // Create a new list
                    newList.add(newWord);
                    queue.add(newList);
                    wordUsed.add(newWord);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        String startWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(findSequence(startWord1, endWord1, wordList1));

        String startWord2 = "red";
        String endWord2 = "tax";
        List<String> wordList2 = Arrays.asList("ted", "tex", "red", "tax", "tad",
                "den", "rex");
        System.out.println(findSequence(startWord2, endWord2, wordList2));
    }

}
