package com.example.dsa.NewCode.Graph;

import java.util.*;

// mark all the O nodes as x if they are not adjasent to boarder or border nodes
public class SurroundedRegions {

    public void solve(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];

        int m = board.length;
        int n = board[0].length;

        // perform dfs on all the boarder nodes whith value as 0
        for (int i = 0; i < m; i++) {
            if (visited[i][0] == 0 && board[i][0] == 'O')
                dfs(board, visited, i, 0);

            if (visited[i][n - 1] == 0 && board[i][n - 1] == 'O')
                dfs(board, visited, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            if (visited[0][i] == 0 && board[0][i] == 'O')
                dfs(board, visited, 0, i);

            if (visited[m - 1][i] == 0 && board[m - 1][i] == 'O')
                dfs(board, visited, m - 1, i);
        }

        // all the nodes that are not visited and value as O , will be mark as x
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (visited[i][j] == 0 && board[i][j] == 'O')
                    board[i][j] = 'X';

    }

    // all the adjasant nodes with border nodes also markes as visites as it can be
    // changed
    private void dfs(char[][] arr, int[][] visited, int r, int c) {

        if (r < 0 || c < 0 || r >= visited.length || c >= visited[r].length || visited[r][c] == 1 || arr[r][c] == 'X')
            return;

        visited[r][c] = 1;

        dfs(arr, visited, r - 1, c);
        dfs(arr, visited, r, c - 1);
        dfs(arr, visited, r + 1, c);
        dfs(arr, visited, r, c + 1);
    }
}
