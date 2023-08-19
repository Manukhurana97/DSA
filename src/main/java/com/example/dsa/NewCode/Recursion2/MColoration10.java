package com.example.dsa.NewCode.Recursion2;

public class MColoration10 {


    private boolean checkGraphColorPossible(int node, boolean graph[][], int[] color, int noOfNodes, int col) {
        for (int i = 0; i < noOfNodes; i++) {
            if (i != node && graph[i][node] && color[i] == col) return false;
        }
        return true;
    }


    private boolean graphColoring(int node, boolean graph[][], int[] color, int noOfColors, int noOfNodes) {

        if (node == noOfNodes) return true;

        /* iterate over each color*/
        for (int col = 1; col <= noOfColors; col++) {
            if (checkGraphColorPossible(node, graph, color, noOfNodes, col)) { // check if that color is possible
                color[node] = col;
                if (graphColoring(node + 1, graph, color, noOfColors, noOfNodes)) { // check for next node
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    /*m: number of colors
    * n: number of nodes */
    private boolean graphColoring(boolean graph[][], int m, int n) {
        return graphColoring(0, graph, new int[graph.length], m, n);
    }

    public static void main(String[] args) {
        MColoration10 mColoration10 = new MColoration10();
        boolean[][] graph = {
                {false, true, true, false},
                {false, false, true, false},
                {false, false, false, true},
                {true, false, false, false}
        };
        var a = mColoration10.graphColoring(graph, 3, 4);
        System.out.println(a);

        boolean[][] graph1 = {
                {false, true, true},
                {false, false, false},
                {false, false, true}
        };
        var b = mColoration10.graphColoring(graph1, 2, 3);
        System.out.println(b);

    }
}
