package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
        int lar = arr[0];
        int slar = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > lar) {
                slar = lar;
                lar = arr[i];
            } else {
                if (arr[i] < lar && arr[i] > slar) {
                    slar = arr[i];
                }
            }
        }
        return slar;
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
        int last = n - 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (arr[last] != 0) {
                    swap(arr, i, last);
                    last -= 1;
                } else {
                    while (last != i && arr[last] == 0) {
                        last -= 1;
                    }
                    if (last > i && arr[last] != 0) {
                        swap(arr, i, last);
                        last -= 1;
                    }
                }
            }
            n = last;
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



        return maxOnce;
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
*/

        int[] arr = {1, 1, 0, 1, 1, 1, 1, 0};
        System.out.println(maxConsecutiveOnce(arr, arr.length));
    }
}
