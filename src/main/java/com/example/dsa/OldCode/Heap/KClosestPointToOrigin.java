package OldCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    static class pair {
        double res;
        int[] val;

        public pair(double res, int[] val) {
            this.res = res;
            this.val = val;
        }

        public double getRes() {
            return res;
        }

        public void setRes(double res) {
            this.res = res;
        }

        public int[] getVal() {
            return val;
        }

        public void setVal(int[] val) {
            this.val = val;
        }
    }

    static void sort(int[][] arr, int[] origin, int k) {
        PriorityQueue<pair> pQueue = new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair p1, pair p2) {
                return (int) (p2.res - p1.res);
            }
        });
        for (int[] i : arr) {
            double res = Math.sqrt(Math.pow(origin[0] - i[0], 2) + Math.pow(origin[1] - i[1], 2));

            pQueue.add(new pair(res, i));

            if (pQueue.size() > k)
                pQueue.poll();

        }

        while (!pQueue.isEmpty()) {
            pair pp = pQueue.poll();
            System.out.println(pp.val[0] + ":" + pp.val[1] + " -> " + pp.res);
        }

    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int[] origin = {0, 0};
        sort(arr, origin, 2);
    }
}
