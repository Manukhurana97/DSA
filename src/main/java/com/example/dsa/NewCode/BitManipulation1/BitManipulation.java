package com.example.dsa.NewCode.BitManipulation1;

public class BitManipulation {


    /**
     * swap 2 number using xor
     * a = 10, b=20
     * a = a ^ b : 01010 | 10100 :- 11110 {30}
     * b = a ^ b : 11110 | 10100 : 01010 {10}
     * a = a ^ b : 11110 : 01010 : 10100 {20}
     */
    public static void convert(int a, int b) {

        System.out.println(" a : " + a + ", b: {} " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(" a : " + a + ", b: {} " + b);
    }

    /*-------------------------------------------------------------------------------------------------------------------*/

    /**
     * Find ith bit
     * 100110101
     * 000100000  :  (i <<< nth)
     * 000100000  :  (and operation) if ressult has 1 the one else 0;
     */
    public static boolean findIth(int no, int pos) {

        pos -= 1;
        var i = (1 << pos);
        no = no & i;

        while (pos-- != 0)
            no >>>= 1;


        return ((no & 1) == 1);
    }

    /*-------------------------------------------------------------------------------------------------------------------*/

    /**
     * set ith bit
     * 1001100:
     * 0010000  : (i << nth)
     * 1011100 :  (or operation)
     */
    public static int setIth(int no, int pos) {

        pos -= 1;
        int i = (1 << pos);

        return no | i;
    }


    /*-------------------------------------------------------------------------------------------------------------------*/

    /**
     * clear ith bits :
     * <p>
     * 1011000
     * 0010000 : (1 << i)
     * 1101111 : invert of above
     * 1010000 : ( and operation )
     */

    public static int clearBit(int no, int pos) {

        int i = (1 << --pos);

        return no & (~i);


    }



    /*-------------------------------------------------------------------------------------------------------------------*/

    /**
     * a : 10110
     * b : 11011
     * <p>
     * total : 3 different bit
     * count += ((a ^ b) ==1)
     */
    public static int countDiffBits(int a, int b) {
        int count = 0;

        while (a != 0 && b != 0) {
            count += ((a ^ b) & 1);
            a >>>= 1;
            b >>>= 1;
        }

        while (a != 0) {
            count += (a & 1);
            a >>>= 1;
        }


        while (b != 0) {
            count += (b & 1);
            b >>>= 1;
        }
        return count;
    }



    /*-------------------------------------------------------------------------------------------------------------------*/

    /**
     * find the number of digits
     * <p>
     * n & (n-1)
     * (with >> approach will take logn time )
     */

    public static int countDiffBits1(int a, int b) {

        int temp = a;
        int countA = 0;
        while (a != 0) {
            temp = a & (a - 1);
            a = temp;
            countA++;
        }


        return countA;

    }




    /*-------------------------------------------------------------------------------------------------------------------*/

    /**
     * find non duplicate element from lis of duplicate element
     * <p>
     * N XOR N = 0;
     */

    public static int findNonRepeatingInRepeatingArray(int[] arr) {

        int xor = 0;
        int i = 0;
        while (i < arr.length) xor ^= arr[i++];


        return xor;

    }



    /*-------------------------------------------------------------------------------------------------------------------*/

    /**
     * find 2 non duplicate element from the list of duplicate element
     * xor of all the element
     * find the least set bit  : xor & -xor
     * and make 2 set from that set bits
     */

    public static int[] find2NonRepeatingInRepeatingArray(int[] arr) {

        int xor = 0;
        int i = 0;
        while (i < arr.length) xor ^= arr[i++];


        int pos = xor & -xor;


        int leftXor = 0;
        int rightXor = 0;

        for (int j : arr) {
            if ((j & pos) != 0) leftXor ^= j;
            else rightXor ^= j;

        }


        int[] resp = {leftXor, rightXor};

        return resp;

    }


    /*-------------------------------------------------------------------------------------------------------------------*/


    /**
     * find single non duplicate element in list contain trice duplicate element
     * <p>
     * get the bits and sum all the bits % k (duplicate times)
     */

    public static int findNonDeplicatefrom3RepeatingElement(int[] arr) {


        int[] temp = new int[32];


        for (int num : arr) {
            int i = 0;
            while (num != 0) {
                temp[i++] += (num & 1);
                num >>>= 1;
            }
        }


        int res = 0;
        for (int i = 0; i < temp.length; i++) res += (temp[i] % 3) << i;


        return res;

    }

    public static int findNonDuplicatefrom3RepeatingElement(int[] arr) {

        int k, ans = 0;
        for (int i = 0; i < 32; i++) {
            k = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[i] & (1 << j)) == 0) {
                    k++;
                }
            }
            ans += k % 3 << i;
        }
        return ans;
    }






    /*-------------------------------------------------------------------------------------------------------------------*/


    public static void main(String[] args) {
        // convert(10, 20);
        // System.out.println(findIth(309, 6));
        // System.out.println(setIth(76, 5));
        // System.out.println(clearBit(88, 5));
        // System.out.println(countDiffBits(22, 27));
        // System.out.println(countDiffBits1(22, 27));
        // int[] arr = {5,4,1,4,3,5,1};
        // System.out.println("non duplicate element :- "+ findNonRepeatingInRepeatingArray(arr));
        // int[] arr = {5,4,1,4,3,5,1,2};
        // arr = find2NonRepeatingInRepeatingArray(arr);
        // System.out.println(arr[0]+" "+arr[1]);
        // int[] arr = {5,4,1,5,4,1,2, 5,4,1};
        // System.out.println(findNonDeplicatefrom3RepeatingElement(arr));


    }

}
