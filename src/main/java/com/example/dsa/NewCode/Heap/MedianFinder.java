package com.example.dsa.NewCode.Heap;

import java.util.*;

public class MedianFinder {

    int size = 0;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        maxHeap.add(num);

        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.remove());
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.remove());
        }

        size++;

    }

    public double findMedian() {

        if((size % 2 != 0))
            return (maxHeap.size() > minHeap.size()) ? maxHeap.peek() : minHeap.peek();
        else
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;

    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
