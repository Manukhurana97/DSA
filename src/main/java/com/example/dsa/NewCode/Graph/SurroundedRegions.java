package com.example.dsa.NewCode.Graph;

import java.util.*;

public class SurroundedRegions {

    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public void solve(char[][] board) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                queue.add(new Node(i, j));
            }
        }

        while (!queue.isEmpty()) {
            var node = queue.poll();
            int r = node.r;
            int c = node.c;

            if (r == 0 || c == 0 || r == board.length - 1 || c == board.length - 1 || board[r][c] == 'X')
                continue;

            if (board[r][c] == 'O' && board[r - 1][c] == 'X' && board[r][c - 1] == 'X' && board[r + 1][c] == 'X'
                    && board[r + 1][c] == 'X') {
                board[r][c] = 'X';
            }

        }
    }

    private static void dfs(char[][] board, int r, int c, Queue<Node> queue) {
        if (r == 0 || c == 0 || r == board.length - 1 || c == board.length - 1 || board[r][c] == 'X') {
            return;
        }
        if (board[r][c] == 'O' && board[r - 1][c] == 'X' && board[r][c - 1] == 'X' && board[r + 1][c] == 'X'
                && board[r + 1][c] == 'X') {
            board[r][c] = 'X';
        }

        dfs(board, r - 1, c, queue);
        dfs(board, r, c - 1, queue);
        dfs(board, r + 1, c, queue);
        dfs(board, r, c + 1, queue);
    }

}
