package OldCode.Hashing;

import java.util.HashMap;

public class SubArrayWithGivenSum {

    public static void subArray(int[] arr, int k) {
        int currSum = 0, startIndex = 0, endIndex = -1;

        // we will store the currentSum as a key and in current index as a value
        // we will check if map contain (current - sum) the start index value index from (current-sum) and end index is currentIndex or i;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == k) {
                startIndex = 0;
                endIndex = i;
                break;
            }

            if (map.containsKey(currSum - k)) {
                startIndex = map.get(currSum - k) + 1;
                endIndex = i;
                break;
            }

            map.put(currSum, i);
        }

        if (endIndex == -1) System.out.println("Not Found");
        else System.out.println("Found at : " + startIndex + " " + endIndex);

    }


    // sub array with equal number of zero//
    // 1 1 0 1 1 0 0

    public static void equalCount(int[] arr) {
        // convert zero to -1 to make total sum to zero;

        for (int i = 0; i < arr.length; i++)
            arr[i] = (arr[i] == 0) ? -1 : 1;


        int currentSum = 0;
        int endIndex = -1;
        int maxLen = 0;

        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == 0) {
                maxLen = i + 1;
                endIndex = i;
            }

            // 1 2 1 2 3 2 1

            if (map.containsKey(currentSum)) {
                if (maxLen < i - map.get(currentSum)) {
                    maxLen = i - map.get(currentSum);
                    endIndex = i;
                }

            }else
                map.put(currentSum, i);
        }

        if (endIndex == -1) System.out.println("No Pair");
        else System.out.println("Pair Found " + (endIndex - maxLen + 1) + " " + endIndex);
    }


    public static void main(String[] args) {
//        int[] arr = {10, 15, -5, 15, -10, 5};
//        subArray(arr, 5);

        int[] arr1 = { 1, 1 , 0, 1, 1, 0, 0 };
        equalCount(arr1);
    }
}
