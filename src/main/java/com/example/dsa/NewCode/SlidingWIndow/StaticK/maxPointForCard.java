package com.example.dsa.NewCode.SlidingWIndow.StaticK;

import java.util.ArrayList;
import java.util.List;

public class maxPointForCard {

    public static int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        List<Integer> lst = new ArrayList<>();

        for (int point : cardPoints) {
            lst.add(point);
        }
        for (int cardPoint : cardPoints) {
            lst.add(cardPoint);
        }


        int left = n - k, right = n - k, nn = n + k, maxPoints = 0, sum = 0;


        while (right < nn) {

            sum += lst.get(right);

            while (left < right && right - left + 1 > k) {
                sum -= lst.get(left);
                left++;
            }

            if (right - left + 1 == k) {
                maxPoints = Math.max(maxPoints, sum);
            }

            right++;
        }

        return maxPoints;
    }

    public static int maxScore1(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int left = n - k, right = n - k, nn = n + k, maxPoints = 0, sum = 0;


        while (right < nn) {

            sum += cardPoints[right % n];

            while (left <= right && right - left + 1 > k) {
                sum -= cardPoints[left % n];
                left++;
            }

            if (right - left + 1 == k) {
                maxPoints = Math.max(maxPoints, sum);
            }

            right++;
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        System.out.println(maxScore1(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        System.out.println(maxScore1(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(maxScore1(new int[]{2, 2, 2}, 2));
        System.out.println(maxScore1(new int[]{100, 40, 17, 9, 73, 75}, 3));
    }

}
