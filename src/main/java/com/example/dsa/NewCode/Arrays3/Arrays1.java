package com.example.dsa.NewCode.Arrays3;

import java.util.*;

public class Arrays1 {

    private static int largestElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


    //    private static int secondLargest(int[] arr){
//       int lar = largestElement(arr);
//       int slar = -1;
//
//       for(int i=0;i<arr.length;i++){
//           if(arr[i]<lar && arr[i]>slar){
//               slar = arr[i];
//           }
//       }
//       return slar;
//    }
    private static int secondLargest(int[] arr) {
        int largest = arr[0];
        int secondLargest = -1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else {
                if (arr[i] < largest && arr[i] > secondLargest) {
                    secondLargest = arr[i];
                }
            }
        }
        return secondLargest;
    }


    private static int[] removeDuplicate(int[] arr) {
        /*1 1 2 2 2 3 3 */
        int index = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == arr[i - 1] && arr[i + 1] != arr[i]) {
                arr[++index] = arr[i + 1];
            }
        }

        int newarr[] = new int[index + 1];
        for (int i = 0; i <= index; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }

    public static int removeDuplicates(ArrayList<Integer> arr, int n) {
        int index = 0;
        for (int i = 1; i < arr.size() - 1; i++) {
            if (arr.get(i) == arr.get(i - 1) && arr.get(i + 1) != arr.get(i)) {
                arr.add(++index, arr.get(i + 1));
            }
        }
        return index;
    }


    private static int[] leftShift(int[] arr, int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++) arr[i - 1] = arr[i];

        arr[n - 1] = temp;

        return arr;
    }

    private static int[] leftShift(int[] arr, int n, int k) {
        k = k % n;
        for (int i = 0; i < k; i++) {
            leftShift(arr, n);
        }
        return arr;
    }

    public static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    private static int[] moveZerosToEnd(int[] arr, int n) {
        int lastNonZeroIndex = n - 1;

        for (int i = 0; i <= lastNonZeroIndex; i++) {
            if (arr[i] == 0) {
                if (arr[lastNonZeroIndex] != 0) {
                    swap(arr, i, lastNonZeroIndex);
                    lastNonZeroIndex -= 1;
                } else {
                    while (lastNonZeroIndex != i && arr[lastNonZeroIndex] == 0) {
                        lastNonZeroIndex -= 1;
                    }
                    if (lastNonZeroIndex > i && arr[lastNonZeroIndex] != 0) {
                        swap(arr, i, lastNonZeroIndex);
                        lastNonZeroIndex -= 1;
                    }
                }
            }

        }
        return arr;
    }

    public static Set<Integer> unionSortedArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) set.add((arr1[i] < arr2[j] ? arr1[i++] : arr2[j++]));
        while (i < arr1.length) set.add(arr1[i++]);
        while (j < arr2.length) set.add(arr2[j++]);


        return set;
    }

    public static Set<Integer> intersectionSortedArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                set.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[2]) i++;
            else j++;
        }

        return set;
    }

    public static int findMissing(int[] arr, int n) {

        /*for (int i = 0; i < n-1; i++) {
            if(arr[i]+1 != arr[i+1]) return arr[i]+1;

        }*/

        /*int expected = (n*(n+1)/2);

        for (int i = 0; i < n-1; i++) {
            expected-=arr[i];
        }*/

        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor2 ^= arr[i];
            xor2 ^= (i + 1);
        }
        xor2 ^= n;

        return xor2 - xor1;
    }


    private static int maxConsecutiveOnce(int[] arr, int n) {
        int maxOnce = 0;

       /* for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                int localMax = 1;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] == 1) {
                        localMax += 1;
                    } else {
                        maxOnce = Math.max(localMax, maxOnce);
                        i = j;
                        break;
                    }
                }

            }
        }*/

        int localMax = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                localMax += 1;
            } else {
                maxOnce = Math.max(localMax, maxOnce);
                localMax = 0;
            }
        }

        return maxOnce;
    }


    public static int nonDuplicateInDuplicateList(int[] arr) {
        int xor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }
        return xor;
    }


    public static List<List<Integer>> largestSumSubarray(int[] arr, int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

//        for (int i = 0; i < arr.length; i++) {
//            int sum = 0;
//
//            for (int j = i; j < arr.length; j++) {
//                sum += arr[j];
//                if(sum==k){
//                    List<Integer> list = new ArrayList<>();
//                    for (int z = i; z <= j; z++) list.add(arr[z]);
//                    result.add(list);
//                    break;
//                }
//                else if ((sum + arr[j]) > k) break;
//            }
//
//        }

//
//        Map<Integer, Integer> map = new HashMap<>();
//        int sum = 0;
//        int len = 0;
//        for (int i = 0; i < n; i++) {
//            sum += arr[i];
//            if (sum == k) {
//                len = Math.max(len, i + 1);
//            }
//
//            int rem = sum - k;
//            if (map.containsKey(rem)) {
//                int mlen = i - map.get(rem);
//                len = Math.max(len, mlen);
//            }
//            if (!map.containsKey(rem))
//                map.put(sum, i);
//
//        }


        int i = 0, j = 0, sum = 0;
        while (i < n) {
            sum += arr[i];
            while (sum > k && i >= j) {
                sum -= arr[j];
                j++;
            }
            if (sum == k) {
                System.out.println(j + " " + i);
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
/*
        System.out.println(largestElement(new int[]{3,2,1,5,2}));

        System.out.println(secondLargest(new int[]{3,2,1,5,2}));

        int[] arr = {1, 1, 2, 2, 2, 3, 3};
        arr = removeDuplicate(arr);
        for (int i : arr)
            System.out.print(i + " ");

        int[]  arr = {1,2,3,4,5};
        arr = leftShift(arr, arr.length, 7);
        for (int i : arr)
            System.out.print(i + " ");


        int[] arr = {1, 2, 0, 0, 3, 4, 5, 0};
        arr = moveZerosToEnd(arr, arr.length);
        for (int i : arr)
            System.out.print(i + " ");

        int arr1[] = {1, 2, 2, 3, 4, 5, 6};
        int arr2[] = {1, 3, 4, 4, 7};

        var sData = unionSortedArray(arr1, arr2);
        System.out.println(sData);


        int arr1[] = {1, 2, 2, 3, 4, 5, 6};
        int arr2[] = {1, 3, 4, 4, 7};

        var sData = intersectionSortedArray(arr1, arr2);
        System.out.println(sData);

        int arr[] = {1, 2, 3, 4, 6};
        System.out.println(findMissing(arr, arr.length));

        int[] arr = {1, 1, 0, 1, 1, 1, 1, 0};
        System.out.println(maxConsecutiveOnce(arr, arr.length));

        int[] arr = {1, 1, 2, 3, 3,4, 4, 5, 5};
        System.out.println(nonDuplicateInDuplicateList(arr));


        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        var data = largestSumSubarray(arr, arr.length, 4);
        for (var lst : data) {
            System.out.println(lst);
        }*/

        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        var data = largestSumSubarray(arr, arr.length, 4);
        for (var lst : data) {
            System.out.println(lst);
        }

    }
}
