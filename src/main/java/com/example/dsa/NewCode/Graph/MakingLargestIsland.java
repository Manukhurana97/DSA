package com.example.dsa.NewCode.Graph;

import java.util.*;

public class MakingLargestIsland {

    class disjointSet {

        int biggestiland = 0;
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        disjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int i) {
            var node = parent.get(i);
            if (node == i)
                return node;

            parent.set(i, findParent(node));
            return parent.get(i);
        }

        public void union(int i, int j) {
            int iP = findParent(i);
            int jP = findParent(j);

            if (iP == jP)
                return;

            if (size.get(iP) < size.get(jP)) {
                parent.set(iP, jP);
                size.set(jP, (size.get(jP) + size.get(iP)));
                biggestiland = Math.max(biggestiland, size.get(jP));

            } else {
                parent.set(jP, iP);
                size.set(iP, (size.get(jP) + size.get(iP)));
                biggestiland = Math.max(biggestiland, size.get(iP));
            }
        }
    }

    private boolean isValid(int r, int c, int i, int j) {
        return i >= 0 && j >= 0 && i < r && j < c;
    }

    public int maxConnections(int grid[][]) {

        int m = grid.length;
        int n = grid[0].length;

        disjointSet set = new disjointSet(m * n);

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0)
                    continue;

                int currentIndex = row * m + col;

                int[] di = { -1, 0, 1, 0 };
                int[] dj = { 0, -1, 0, 1 };

                for (int k = 0; k < 4; k++) {
                    int newRow = row + di[k];
                    int newCol = col + dj[k];
                    int neighbourIndex = newRow * m + newCol;

                    if (isValid(m, n, newRow, newCol) && grid[newRow][newCol] == 1) {
                        set.union(currentIndex, neighbourIndex);
                    }
                }
            }
        }

        // if all element are one in that case we will have biggest iland in the
        // starting itself
        int biggestiland = set.biggestiland;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    continue;
                int currentIndex = row * m + col;

                int[] di = { -1, 0, 1, 0 };
                int[] dj = { 0, -1, 0, 1 };

                Set<Integer> setParent = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int newRow = row + di[k];
                    int newCol = col + dj[k];
                    int neighbourIndex = newRow * m + newCol;

                    // since we dont want to make connection with 0 so we will not perform union
                    // instead we will store the parent of all and the caicilate the sum of size of
                    // all the parents nodes
                    if (isValid(m, n, newRow, newCol) && grid[newRow][newCol] == 1) {
                        setParent.add(set.findParent(neighbourIndex));
                    }
                }

                int sum = 0;
                for (var i : setParent) {
                    sum += set.size.get(i);
                }

                biggestiland = Math.max(biggestiland, sum + 1);
            }
        }

        return biggestiland;
    }

    public static void main(String[] args) {
        MakingLargestIsland obIsland = new MakingLargestIsland();

        int[][] grid = {
                { 1, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 1, 0, 1, 0 },
                { 0, 0, 1, 1, 1 },
                { 1, 1, 0, 0, 0 }
        };
        System.out.println(obIsland.maxConnections(grid));

        int[][] grid1 = {
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0 }
        };

        System.out.println(obIsland.maxConnections(grid1));
    }
}
