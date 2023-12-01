package com.example.dsa.NewCode.Heap;

import java.util.*;

public class TopKElements {

    class Node{
        int data;
        int count;


        Node(int data, int count){
            this.data = data;
            this.count = count;
        }
    }
    public  int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node node) ->  node.count));
        Map<Integer, Integer> map = new HashMap<>();

        for(int i: nums) map.put(i, map.getOrDefault(i, 0)+1);
        System.out.println(map);
        for(Map.Entry<Integer, Integer> k_v: map.entrySet()){
            queue.add(new Node(k_v.getKey(), k_v.getValue()));

            if(queue.size()>k) {
                queue.remove();
            }
        }

        int[] result = new int[k];
        int i=0;
        while(!queue.isEmpty()){
            result[i++] = queue.remove().data;
        }

        return result;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));


        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(Map.Entry<Integer, Integer> k_v: map.entrySet()){
            queue.add(k_v.getKey());

            if(queue.size()>k) {
                queue.remove();
            }
        }

        int[] result = new int[k];
        int i=0;
        while(!queue.isEmpty()){
            result[i++] = queue.remove();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKElements elements = new TopKElements();
        System.out.println(Arrays.toString(elements.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }
}
