package com.example.dsa.NewCode.DP.DP1;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobbers {
    public int robbingHouseReccustion(int n, int[] house) {
        if (n == 0)
            return house[n];
        if (n < 0)
            return 0;

        int rob = robbingHouseReccustion(n - 2, house) + house[n];
        int notRob = robbingHouseReccustion(n - 1, house);

        return Math.max(rob, notRob);
    }

    public static int robbingHouseConstantSpace(int[] nums) {
        int n = nums.length;

        int current = 0;
        int prev = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {

            result = Math.max(nums[i] + prev, current);

            prev = current;
            current = result;
        }

        return result;
    }

    public int robbingHouse(int[] house) {
        int[] first = Arrays.copyOfRange(house, 0, house.length - 1);
        int[] last = Arrays.copyOfRange(house, 1, house.length);

        int fR = robbingHouseConstantSpace(first);
        int lR = robbingHouseConstantSpace(last);
        return Math.max(fR, lR);
    }

    public static void main(String[] args) {

    }
}
