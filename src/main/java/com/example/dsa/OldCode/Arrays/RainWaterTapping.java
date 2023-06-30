package OldCode.Arrays;

import java.util.ArrayList;

public class RainWaterTapping {

    public static int storageCapacity(int[] arr) {

        int n = arr.length;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int leftMax = 0;
        int rightMax = 0;

        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            left[i] = leftMax;

            rightMax = Math.max(rightMax, arr[n - i - 1]);
            right[n - i - 1] = rightMax;
        }

        int capacity = 0;
        for (int i = 0; i < n; i++)
            capacity += (Math.min(left[i], right[i]) - arr[i]);

        return capacity;
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int sum=0;
            for(int j=0;j<arr.length;j++){
                sum+=arr[i];
                if(sum==s){
                    lst.add(i);
                    lst.add(j+1);
                    return lst;
                }
            }
        }
        return lst;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 0, 1, 3, 2};
        System.out.println("capacity : " + storageCapacity(arr));
    }
}
