package com.example.dsa.NewCode.SlidingWIndow.StaticK;

public class binarySubArraysWithSum {

//    public int numSubarraysWithSum(int[] nums, int goal) {
//         int sum=0, res=0;
//         Map<Integer, Integer> map = new HashMap<>(nums.length);
//         map.put(0, 1);

//         for(int i: nums){
//             sum+= i;

//             if(map.containsKey(sum-goal)){
//                 res += map.get(sum-goal);
//             }

//             map.put(sum, map.getOrDefault(sum, 0)+1);
//         }

//         return res;
//     }

        // to get k element . at most element till k - at most element with k-1 , will give exact no of element with k

        public static int numSubarraysWithSum(int[] nums, int goal) {
            return atMost(nums, goal) - atMost(nums, goal-1);
        }


        public static int atMost(int[] nums, int k) {

            int i=0,j=0,n=nums.length, sum = 0, noOfElement=0;

            while(j<n){
                sum += nums[j];

                while(i<=j && sum>k){
                    sum-=nums[i++];
                }

                noOfElement += (j-i+1);
                j++;
            }

            return noOfElement;
        }


    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(arr, 2));
    }

}
