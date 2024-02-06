package com.example.dsa.NewCode.Graph;

import java.util.*


/* intution: take each word and modify the all characters of words from a-z and check if is exist ot now, if exist add in queue 
and increment the count*/ 
public class WordLadder1 {

    static class Node {
        String data;
        int count;

        Node(String data, int count) {
            this.data = data;
            this.count = count;
        }
    }

    private static int wordLadderLength(String startWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        int count = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startWord, 1));

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (node.data.equals(endWord))
                return node.count;
            count++;
            checkNextWord(node.data, node.count, set, queue);
        }

        return count;
    }

    // modify each character of word and check if iexist or not
    private static void checkNextWord(String currentWord, int count, Set<String> set, Queue<Node> queue) {
        for (int i = 0; i < currentWord.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {

                var chArr = currentWord.toCharArray();
                chArr[i] = ch;
                String newWord = String.valueOf(chArr);

                if (set.contains(newWord)) {
                    set.remove(newWord);
                    queue.add(new Node(newWord, count + 1));
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(wordLadderLength("der", "dfs", Arrays.asList("des", "der", "dfs", "dgt", "dts")));
    }

}
