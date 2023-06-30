package OldCode.BitManuplation1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {

    static class Pair{
        int key;
        int value;

        public Pair(int key, int value) {
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

    static void countFrequency(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        PriorityQueue<Pair> queue=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for(Map.Entry<Integer, Integer> kv :map.entrySet()){

            queue.add(new Pair(kv.getValue(), kv.getKey()));
            if(queue.size()>k){
                queue.poll();
            }
        }

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            System.out.println(pair.getValue()+"->"+ pair.getKey());
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,3,3,2,1};
        countFrequency(arr, arr.length, 3);

    }
}
