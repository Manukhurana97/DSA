/**
 * https://www.interviewbit.com/courses/programming/bit-manipulation/
 *
 * */

import java.util.*;
import java.lang.Math;


public class InterviewBitsManipulation {



	/* https://www.interviewbit.com/problems/number-of-1-bits/ */
	public static int noOfSetBits(int n) {

		int count = 0;

		while (n != 0) {
			n = n & (n - 1);
			count++;
		}

		return count;
	}



	/* https://www.interviewbit.com/problems/trailing-zeroes/ */
	public static int trailingZeros(int n) {
		int count = 0;

		while (n != 0) {
			if ((n & 1) == 1) return count;
			count++;
			n >>>= 1;
		}

		return count;
	}



	/* https://www.interviewbit.com/problems/reverse-bits/ */
	public static long reverseBit(long n) {


		long r = 0;
		int i = 31;

		while (n != 0) {
			r += (n & 1) * 1 << i--;

			n >>>= 1;
		}

		return r;
	}


	/**
	 *
	 * divide  -> 43/8 -> 8*5 + 3 -> 8*2^2 + 8*2^1 + 3: 8*2^n
	 *
	 *
	 * */

	/* https://www.interviewbit.com/problems/divide-integers/ */
	public static int divide(int x, int y) {

		int total = 0;
		int quetient = 0;

		if (y == 0) return Integer.MAX_VALUE;
		if (y == 1) return x;
		if (x == 0 || (x < y &&  x > 0))  return 0;

		boolean negFlag = ((x > 0 && y < 0) || (x < 0 && y > 0));

		long a = Math.abs( (long) x);
		long b = Math.abs( (long) y);


		for (int i = 31; i >= 0; i--) {
			if ((total + (b << i)) < a) {
				total += b << i;
				quetient += 1l << i;

			}
		}


		if (negFlag) quetient *= -1;
		if (quetient > Integer.MAX_VALUE || quetient < Integer.MIN_VALUE) return Integer.MAX_VALUE;
		return (int) quetient;
	}



	/**
	 *
	 * https://www.interviewbit.com/problems/different-bits-sum-pairwise/
	 * (1-> 31) get all once of each and multiply with non once
	 *
	 *
	 * */
	public static int cntBits(ArrayList<Integer> arr) {
		long total = 0;
		for (int i = 0; i < 32; i++) {
			long count = 0;
			for ( int j : arr) {
				count += ((j >>>= i) & 1);
			}
			total += count * (arr.size() - count);

		}


		return (int)((2 * total) % 1000000007);

	}


	/**
	 * https://www.interviewbit.com/problems/count-total-set-bits/
	 *
	 * */
	public static int totalSetBit(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++)
			sum += countSetBits(i);

		return sum;
	}

	private static int countSetBits(int n) {
		int count = 0;

		if (n == 0) return count;

		return 1 + countSetBits(n & (n - 1));
	}


	// public static int totalSetBit1(int n) {
	// 	int p = 0;
	// 	int result = 0;

	// 	if (n == 0) return 0;
	// 	while (Math.pow(2, p) < n)
	// 		p++;

	// 	p--;

	// 	result = p * Math.pow(2, p) / 2 + (n - Math.pow(2, p)) + totalSetBit1(n - Math.pow(2, p));

	// 	result %= 1000000007;
	// 	return result;

	// }






	public static void main(String[] args) {
		// System.out.println(noOfSetBits(11));
		// System.out.println(trailingZeros(8));
		// System.out.println(reverseBit(3));
		// System.out.println(divide(43, 8));

		// ArrayList<Integer> arr = new ArrayList<>();
		// arr.add(2);
		// arr.add(3);
		// System.out.println(cntBits(arr));
		System.out.println(totalSetBit(3));
	}
}