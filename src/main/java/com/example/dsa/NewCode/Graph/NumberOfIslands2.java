package com.example.dsa.NewCode.Graph;

import java.util.*;

public class NumberOfIslands2 {

    class disJointSet {

        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        int extraNode = 0;

        disJointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        private int findParent(int i) {
            int node = parent.get(i);
            if (i == node) {
                return node;
            }

            parent.set(i, findParent(node));

            return parent.get(i);
        }

        private void union(int i, int j) {
            int ultPI = findParent(i);
            int ultPJ = findParent(j);

            if (ultPI == ultPJ) {
                extraNode++;
                return;
            }

            if (size.get(ultPI) < size.get(ultPJ)) {
                parent.set(ultPI, ultPJ);
                size.set(ultPJ, size.get(ultPI) + size.get(ultPJ));
            } else {
                parent.set(ultPJ, ultPI);
                size.set(ultPI, size.get(ultPI) + size.get(ultPJ));
            }

        }
    }

    private boolean isValid(int r, int c, int m, int n) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }

    private List<Integer> noOfIlands(List<List<Integer>> adj, int m, int n) {
        List<Integer> result = new ArrayList<>();

        disJointSet set = new disJointSet(m * n);

        int[][] visited = new int[m][n];
        int ilandsCount = 1;

        for (var node : adj) {
            int r = node.get(0);
            int c = node.get(1);

            if (visited[r][c] == 1)
                continue;
            visited[r][c] = 1;

            int currentIndex = r * m + c;
            ilandsCount++;

            int[] dr = { -1, 0, 1, 0 };
            int[] dc = { 0, -1, 0, 1 };
            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                int neighbourIndex = newR * m + newC;

                if (isValid(newR, newC, m, n) && visited[newR][newC] == 1) { // if the neighbours are alread visited
                                                                             // then
                    if (set.findParent(currentIndex) != set.findParent(neighbourIndex)) { // if current and neighbour
                                                                                          // dont have same parent them
                        ilandsCount--; // decrese bcz we are making parent same
                        set.union(currentIndex, neighbourIndex); // perform union with current and neighbour
                    }
                }

            }

            result.add(ilandsCount);
        }
        return result;
    }
}
