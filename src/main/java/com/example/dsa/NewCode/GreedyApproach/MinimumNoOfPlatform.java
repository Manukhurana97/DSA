package com.example.dsa.NewCode.GreedyApproach;

import java.util.*;

public class MinimumNoOfPlatform {

    public class Node {
        int startTime;
        int endTime;

        Node(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public int findPlatform(int[] start, int[] end, int n) {
        List<Node> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) lst.add(new Node(start[i], end[i]));

        lst.sort(Comparator.comparingInt((Node n2) -> n2.startTime));

        int noOfStations = 0;
        int currentTime = 0;
        List<Node> currentStrainsOnStations = new ArrayList<>();


        for (Node i : lst) {
            if (i.startTime > currentTime) {
                currentTime = i.startTime;
                List<Node> trainToDepart = new ArrayList<>();

                for (var trains : currentStrainsOnStations) {
                    if (trains.endTime <= currentTime) {
                        trainToDepart.add(trains);
                    }
                }

                currentStrainsOnStations.removeAll(trainToDepart);
            }

            currentStrainsOnStations.add(i);
            noOfStations = Math.max(noOfStations, currentStrainsOnStations.size());

        }

        return noOfStations;
    }


    public int findPlatform1(int[] start, int[] end, int n) {
        List<Node> trains = new ArrayList<>();
        for (int i = 0; i < n; i++) trains.add(new Node(start[i], end[i]));

        trains.sort(Comparator.comparingInt((Node n2) -> n2.startTime));

        PriorityQueue<Integer> currentTrainsOnStations = new PriorityQueue<>();

        int noOfStationsRequired = 0, currentTime = 0;
        for (var train : trains) {
            currentTime = train.startTime;
            while (!currentTrainsOnStations.isEmpty() && currentTime >= currentTrainsOnStations.peek()) {
                currentTrainsOnStations.remove();
            }
            currentTrainsOnStations.add(train.endTime);
            noOfStationsRequired = Math.max(noOfStationsRequired, currentTrainsOnStations.size());


        }

        return noOfStationsRequired;
    }

    public int findPlatform2(int[] arrival, int[] departure, int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int noOfPlatform = 0, result = 1, i = 0, j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                noOfPlatform++;
                i++;
            }else{
                noOfPlatform--;
                j++;
            }

            result = Math.max(result, noOfPlatform);

        }

        return result;
    }

    public static void main(String[] args) {
        MinimumNoOfPlatform noOfPlatform = new MinimumNoOfPlatform();
        System.out.println(noOfPlatform.findPlatform(new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000}, 6));
        System.out.println(noOfPlatform.findPlatform1(new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000}, 6));
        System.out.println(noOfPlatform.findPlatform2(new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000}, 6));
    }
}
