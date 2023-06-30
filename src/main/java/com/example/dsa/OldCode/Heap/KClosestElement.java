package OldCode.Heap;

import java.util.*;

public class KClosestElement {

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

    public static void closestElement(int[] arr, int element, int count) {
        PriorityQueue<pair> queue = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o2.getKey() - o1.getKey();
            }
        });
        for (int i : arr) {
            queue.add(new pair(Math.abs(i - element), i));
            if (queue.size() > count)
                queue.poll();
        }

        while (!queue.isEmpty()) {

            System.out.print(queue.poll().value + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        closestElement(arr, 7, 3);

    }
}
