package com.example.dsa.NewCode.Arrays3;

import java.util.ArrayList;

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
        int last = n ;
        for (int i = 0; i < last; i++) {
            if (arr[i] == 0) {
                if (arr[last-1] != 0) {
                    swap(arr, i, last-1);
                } else {
                    while (last-1 != i && arr[last-1] == 0) {
                        last -= 1;
                    }
                    if(last-1>i && arr[last-1]!=0)
                        swap(arr, i, last-1);
                }
            }
        }
        return arr;
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
*/

        int[] arr = {1,2,0,0,3,4,5,0};
        arr = moveZerosToEnd(arr, arr.length);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
