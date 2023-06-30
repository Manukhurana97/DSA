package OldCode.BitManuplation1;

import java.util.ArrayList;
import java.util.Collections;

public class bitManipulationInterviewBit {


    // https://www.interviewbit.com/problems/number-of-1-bits/
    // count number if 1 in a number bit
    public int numSetBits(long a) {
        int count = 0;
        while (a != 0) {
            count += (a & 1);
            a >>>= 1;
        }

        return count;
    }

//--------------------------------------------------------------------------------------------


    // https://www.interviewbit.com/problems/trailing-zeroes/
    // number of zeros before any one
    public static int solve(int A) {
        // 18 : 10010
        // 8 : 1000
        int zeros = 0;
        while (A != 0) {
            if ((A & 1) == 1)
                return zeros;
            zeros++;
            A >>>= 1;
        }

        return zeros;
    }

//--------------------------------------------------------------------------------------------

    public long reverse(long a) {

        long newNo = 0;
        int i = 31;
        while (a != 0) {
            newNo += (a & 1) | (1<<i--);
            a >>>= 1;
        }

        return newNo;
    }

//--------------------------------------------------------------------------------------------

    public static int divide(int x, int y) {
// 5/2
//        int count=0;
//        while(x>=y){
//            x-=y;
//            count++;
//        }
//
//        return count; // 2


        // 5/2 : 2^n+1 : 2^2+1
        // 43/8 : 8*2^n: 8*2^2 + 8*2^0 + 3

        if (y == 0) return Integer.MAX_VALUE;
        if (x == 0 || (x < y && x > 0)) return 0;

        if (y == 1) return x;

        boolean flag = ((x > 0 && y < 0) || (x < 0 && y > 0)); //checking for negative

        long a = Math.abs((long) x); // making all positive
        long b = Math.abs((long) y);

        long ans = 0, temp = 1;


        for (int i = 31; i >= 0; i--) {
            if ((temp + ((long) b << i)) <= a) {
                temp += ((long) b << i);
                ans += (1L << i); // calculate divisor 8*x+3=43 // leaving the remainder  (creating binary and than adding it to result)
            }
        }

        if (flag) ans = -ans;
        if ((ans > Integer.MAX_VALUE) || (ans < Integer.MIN_VALUE)) return Integer.MAX_VALUE;
        return (int) ans;

    }


//--------------------------------------------------------------------------------------------

/*
    count the number of  ones in each please for all 31 bis for each number
    eg: [1,3,5]
    f(1,1) + f(1,3) + f(1,5)  => 0+1+1
    f(3,1) + f(3,3) + f(3,5)  => 1+0+2
    f(5,1) + f(5,3) + f(5,5)  => 1+2+0  >> 8

    as we see the  (x=y) will always be zero and first is the mirror image of second
    we will calculate for half and * by 2

    func: count the number of 1 for all the 3 and subtract from len we will get the difference

 */
    public int cntBits(ArrayList<Integer> arr) {
        long count = 0, len = arr.size();
        for (int i = 0; i < 32; i++) {
            long count1 = 0;
            for (int j = 0; j < len; j++) {
                count1 += (arr.get(j) >>> i) & 1; // get last element and perform & operation,
            }

            count += (count1 * (len - count1));  // number of zero (count1) * number of ones (len-count1) to get all the pairs

        }
        return (int) ((count * 2) % 1000000007);
    }

//--------------------------------------------------------------------------------------------



    public static int countSetBit(int A) {
        //10:: 2^3: 8: 8-1 : 3 digit till 7 + 2^1
        // 10:: p*(2^p)/2 + n-(2^p)+1 + recursion(n-2^p)


//        int p = 0;
//        int result = 0;
//        while (Math.pow(2, p) < A) {
//            p++;
//        }
//        p--;
//        result = p * Math.pow(2, p) / 2 + (A - Math.pow(2, p)) + solve((A - Math.pow(2, p)));
//
//        result %= 1000000007;
//        return result;

        long count = 0;
        for (int i = 1; i <= A; i++) {
            int z = i;
            while (z != 0) {
                count += (z & 1);
                z >>>= 1;
            }
        }
        return (int) count % 1000000007;
    }

//--------------------------------------------------------------------------------------------

    public int findMinXor(ArrayList<Integer> A) {

        // time complexity : O(nlogn)
        Collections.sort(A); // nlog n
        int minmor = Integer.MAX_VALUE;

        int val = A.get(0);
        for (int i = 1; i < A.size(); i++) { // n
            if ((val ^ A.get(i)) < minmor) minmor = (val ^ A.get(i));
            val = A.get(i);
        }
        return minmor;

    }


    //Given x and y find a number have same number of bits (1) as y and minimize the
    public static int minXor(int x, int y) {

        if (x == 0 || y == 0 || (x == y)) return -1;


        // calculate the number of bits of y
        int yy = y;
        int noOfBits = 0;
        while (yy != 0) {
            if ((yy & 1) == 1) noOfBits += 1;
            yy >>>= 1;
        }


        // create the array with x (decimal to binary)
        int[] arr = new int[32];
        int xx = x, j = 31;
        while (xx != 0) {
            arr[j--] = (xx & 1);
            xx >>>= 1;
        }


        // check the number of 1 in the x array with the count of y bits
        int no = 0;
        for (int i = 0; i < 32; i++) {
            if (arr[i] == 1) {
                no += (1 << 31 - i);
                if (--noOfBits == 0) break;
            }
        }


        // if any count bit of y left , add 1 from last
        int z = 0;
        while (noOfBits != 0) {
            if (arr[z] != 1) {
                no += (1 << z);
            }
            z++;
            j--;
        }


        System.out.println("old number " + y);
        System.out.println("new number " + no);
        System.out.println("old number XOR " + x + "^" + y + " " + (x ^ y));
        System.out.println("new number XOR " + (x ^ no));

        return no;
    }


//    https://www.interviewbit.com/problems/count-total-set-bits/

//    public int solve(int A) {
//
//        //10:: 2^3: 8: 8-1 : 3 digit till 7 + 2^1
//        //10:: p*(2^p)/2 + n-(2^p)+1 + recursion(n-2^p)
//
//        // p*2(p-1)
//
//        if(A==0) return 0;
//
//        int p = 0;
//        int result = 0;
//        while (Math.pow(2, p) < A) {
//            p++;
//        }
//        p--;
//        result = p * Math.pow(2, p) / 2 + (A - Math.pow(2, p)) + solve((A - Math.pow(2, p)));
//
//        result %= 1000000007;
//        return result;
//    }


    public static int brianKernighan(int n) {
        int count = 0;

        // removing the last bit by doing the and operation with the last bit
        while (n != 0) {
            n &= --n;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
//        int a = numSetBits(11);
//        System.out.println(a);

//        int a = solve(18);
//        System.out.println(a);

//        System.out.println("divide " + divide(43, 8));


//        minXor(11, 9);
    }
}

