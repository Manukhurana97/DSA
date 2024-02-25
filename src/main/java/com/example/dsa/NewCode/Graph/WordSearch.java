package com.example.dsa.NewCode.Graph;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                    if (dfs(i, j, board, word, visited, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean dfs(int r, int c, char[][] board, String endWord, boolean[][] visited, int index) {

        if (index == endWord.length())
            return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != endWord.charAt(index)
                || visited[r][c])
            return false;

        visited[r][c] = true;

        if (dfs(r - 1, c, board, endWord, visited, index + 1))
            return true;
        if (dfs(r, c - 1, board, endWord, visited, index + 1))
            return true;
        if (dfs(r + 1, c, board, endWord, visited, index + 1))
            return true;
        if (dfs(r, c + 1, board, endWord, visited, index + 1))
            return true;

        visited[r][c] = false;

        return false;

    }

    public static void main(String[] args) {
        char[][] arr = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(arr, "ABCCED"));
    }
}
