package com.example.dsa.NewCode.Heap;

import java.util.*;

public class hand0fStraights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) map.put(i, map.getOrDefault(i, 0) + 1);

        while (!map.isEmpty()) {
            int start = map.firstKey();
            for(int i=start;i<start+groupSize;i++){
                if(!map.containsKey(i)) return false;

                int count = map.get(i);
                if(count==1) map.remove(i);
                else map.put(i, count-1);

            }
        }

        return true;
    }

    public static boolean isNStraightHand1(int[] hand, int groupSize) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : hand) queue.add(i);

        while (!queue.isEmpty()) {
            int head = queue.peek();
            for(int j=1;j<groupSize;j++){
                if(!queue.remove(head+j)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }
}
