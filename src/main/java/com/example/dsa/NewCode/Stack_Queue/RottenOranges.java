package com.example.dsa.NewCode.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
//        int[][] arr = {{2, 1, 1,}, {1, 1, 0}, {0, 1, 1}};
        int[][] arr = {{2, 1, 1,}, {0, 1, 1}, {1, 0, 1}};
//        int[][] arr = {{0, 2}};
        System.out.println(rottenOranges.calculateTime(arr));
    }

    public Queue<Position> makeOrangesRotten(Queue<Position> existedRippedOranges, int[][] arr) {
        Queue<Position> newRippedOranges = new LinkedList<>();

        for (Position orangePosition : existedRippedOranges) {
            /*top*/
            if (orangePosition.row - 1 >= 0 && arr[orangePosition.col][orangePosition.row - 1] == 1) {
                arr[orangePosition.col][orangePosition.row - 1] = 2;
                Position pos = new Position(orangePosition.col, orangePosition.row - 1);
                newRippedOranges.add(pos);
            }
            /*bottom*/
            if (orangePosition.row + 1 < arr.length && arr[orangePosition.col][orangePosition.row + 1] == 1) {
                arr[orangePosition.col][orangePosition.row + 1] = 2;
                Position pos = new Position(orangePosition.col, orangePosition.row + 1);
                newRippedOranges.add(pos);
            }
            /*left*/
            if (orangePosition.col - 1 >= 0 && arr[orangePosition.col - 1][orangePosition.row] == 1) {
                arr[orangePosition.col - 1][orangePosition.row] = 2;
                Position pos = new Position(orangePosition.col - 1, orangePosition.row);
                newRippedOranges.add(pos);
            }
            /*right*/
            if (orangePosition.col + 1 < arr[0].length && arr[orangePosition.col + 1][orangePosition.row] == 1) {
                arr[orangePosition.col + 1][orangePosition.row] = 2;
                Position pos = new Position(orangePosition.col + 1, orangePosition.row);
                newRippedOranges.add(pos);
            }
        }

        return newRippedOranges;
    }

    public int calculateTime(int[][] arr) {
        int minutes = -1;
        int totalOnce = 0;
        Queue<Position> stack = new LinkedList<>();

        /*initially we get all the ripped oranges to start with*/
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int val = arr[i][j];
                if (val == 1) totalOnce++;
                if (val == 2) {
                    stack.add(new Position(i, j));

                }
            }
        }

        if(totalOnce ==0) return 0;

        while (!stack.isEmpty()) {
            minutes += 1;
            stack = makeOrangesRotten(stack, arr);
            totalOnce -= stack.size();
        }

        if (totalOnce > 0) return -1;


        return minutes;
    }

    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
