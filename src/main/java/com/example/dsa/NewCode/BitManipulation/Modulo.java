
/**
 * Module: %
 * Modulo return remainder
 *
 * (a + b) % n ->  (a%n + b%n)%n
 *
 * */

public class Modulo {


	public static int fastPower(int a, int b) {

		int res = 1;

		while (b > 0) {
			if ((b & 1) == 1) res *= a;

			a *= a;
			b >>>= 1;
		}

		return res;

	}

	public static long fastPower(int a, int b, int mod) {
		long res = 1;

		while (b > 0) {
			if ((b & 1) == 1) res = ((res % mod) * (a % mod)) % mod;

			a = ((a % mod) * (a % mod))  % mod;
			b >>>= 1;
		}

		return res;
	}


	public static int gcd(int a , int b) {

		int min = Math.min(a, b);

		while (min > 0) {
			if (a % min == 0 && b % min == 0) return min;
			min--;
		}

		return 1;
	}

	public static int gcdR(int a, int b){

		if(b==0)
			return a;

		return gcdR(b, a%b);
	}


	public static void main(String[] args) {
		// System.out.println(fastPower(3978432, 5, 1000000007));
		System.out.println(gcdR(16, 36));

	}
}