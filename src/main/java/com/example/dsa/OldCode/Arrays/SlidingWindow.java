package OldCode.Arrays;

import java.util.ArrayList;

public class SlidingWindow {

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // ArrayList<Integer> lst = new ArrayList<>(); // O(n^2)
        // for(int i=0; i<arr.length; i++){
        //     int sum=0;
        //     for(int j=i;j<arr.length;j++){
        //         sum+=arr[j];
        //         if(sum>s) break;
        //         if(sum==s){
        //             lst.add(i+1);
        //             lst.add(j+1);
        //             return lst;
        //         }
        //     }
        // }
        // if (lst.size()==0) lst.add(-1);
        // return lst;



        //------------------------------------------ Sliding window ----------------------------------------------------


        int start = 0, end = 0, sum = 0;
        ArrayList<Integer> lst = new ArrayList<>();

        if (s==0) {
            lst.add(-1);
            return lst;

        }

        while ( end <n) { // O(n)
            if(sum<s)
                sum += arr[end++];

            if(sum>s)
                while (sum > s)
                    sum -= arr[start++];

            if(sum==s) {
                if(start>end) break;
                lst.add(start + 1);
                lst.add(end );
                return lst;
            }

        }
        if (lst.isEmpty()) lst.add(-1);
        return lst;
    }

    public static void main(String[] args) {
        int[] a = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        ArrayList<Integer> arr = subarraySum(a, 42, 468);
        for (int i : arr)
            System.out.print(i+" ");
    }
}
