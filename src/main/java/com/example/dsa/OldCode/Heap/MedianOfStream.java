package OldCode.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {

    // we will divide the list in half eg: 1 2 3 4 5 6
    // 1 2 3   &   4 5 6 : we make 2 queue (max queue, min queue):
    // we will store the first n/2 element in max queue 3 2 1
    // we will store next n/2 element in min queue 4 5 6
    // median : (n/2==0) ? (max.peek() + min.peek()) / 2 :  min.peek();

    PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();

    public void insertNum(int num) {

        if (maxQueue.isEmpty() || maxQueue.peek() >= num)
            maxQueue.add(num);
        else minQueue.add(num);

        if (maxQueue.size() > minQueue.size() + 1)
            minQueue.add(maxQueue.poll());
        else if (maxQueue.size() < minQueue.size())
            maxQueue.add(minQueue.poll());

    }

    public int findMedian() {
        if (maxQueue.size() == minQueue.size()) {
            return (maxQueue.peek() + minQueue.peek()) / 2;
        }
        return maxQueue.peek();
    }

    public static void main(String[] args) {
        MedianOfStream medianOfStream = new MedianOfStream();
        medianOfStream.insertNum(5); //5
        System.out.println("median " + medianOfStream.findMedian());
        medianOfStream.insertNum(2); // 2+5/2
        System.out.println("median " + medianOfStream.findMedian());
        medianOfStream.insertNum(3); // +5/3
        System.out.println("median " + medianOfStream.findMedian());
        medianOfStream.insertNum(1);
        System.out.println("median " + medianOfStream.findMedian());
        medianOfStream.insertNum(6);
        System.out.println("median " + medianOfStream.findMedian());
        medianOfStream.insertNum(4);
        System.out.println("median " + medianOfStream.findMedian());
    }
}
