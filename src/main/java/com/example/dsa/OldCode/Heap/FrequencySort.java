package OldCode.Heap;

import java.util.*;

public class FrequencySort {

    static class pair {
        int key;
        int value;

        public pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    static void sort(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) map.replace(i, map.get(i) + 1);
            else map.put(i, 1);
        }

        PriorityQueue<pair> queue = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> kv : map.entrySet())
            queue.add(new pair(kv.getValue(), kv.getKey()));

        while (!queue.isEmpty() && k-- > 0) {
            pair node = queue.poll();
            for (int i = 0; i < node.key; i++)
                System.out.print(node.value + " ");
            System.out.println();
//            System.out.println(node.getKey()+" "+node.getValue());
        }
    }

    // using bucket sort

    static void sort(int[] arr, int n, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, LinkedList<Integer>> count = new TreeMap<>();


        // create a dictionary of count
        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);


        // create a map with count as key and number list as value
        for (Map.Entry<Integer, Integer> kv : map.entrySet()) {

            LinkedList<Integer> temp;
            if (count.containsKey(kv.getValue())) {
                temp = count.get(kv.getValue());
            } else {
                temp = new LinkedList<>();
            }
            temp.add(kv.getKey());
            count.put(kv.getValue(), temp);

        }
        for (Map.Entry<Integer, LinkedList<Integer>> rs : count.descendingMap().entrySet()) {
            for(int i: rs.getValue()){
                System.out.println(i+" "+rs.getKey());
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 4};
        sort(arr, arr.length, 2);
    }
}
