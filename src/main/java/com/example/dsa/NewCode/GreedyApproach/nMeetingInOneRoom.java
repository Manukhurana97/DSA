package com.example.dsa.NewCode.GreedyApproach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class nMeetingInOneRoom {

    public class Node {
        int startTime;
        int endTime;
        int index;

        Node(int start, int end, int index) {
            this.startTime = start;
            this.endTime = end;
            this.index = index;
        }
    }

    public List<Integer> getMeetings(int[] start, int[] end, int n) {
        ArrayList<Node> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(new Node(start[i], end[i], i));
        }

        lst.sort(Comparator.comparingInt((Node n2) -> n2.endTime));

        int currentStartTime = 0;
        List<Integer> result = new ArrayList<>();
        for (var i : lst) {
            if (i.startTime > currentStartTime) {
                currentStartTime = i.endTime;
                result.add(i.index);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        nMeetingInOneRoom room = new nMeetingInOneRoom();
        System.out.println(room.getMeetings(new int[]{1,0,3,8,5,8},new int[]{2,6,4,9,7,9},6));
    }
}
