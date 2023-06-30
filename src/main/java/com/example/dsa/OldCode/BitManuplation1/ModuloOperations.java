package OldCode.BitManuplation1;

public class ModuloOperations {

    /*
     * find the greatest common factor
     * */
    public static int findGCP(int a, int b) {
        if (b == 0) return a;

        return findGCP(b, a % b);
    }


    /*
     * find the power using the bit operations
     * */
    public static int fastpower(int a, int b) {

        int result = 1;
        while(b!=0) {
            if ((b & 1) == 1) // for odd number
                result *= a;
            a *= a;
            b >>>= 1;
        }

        return result;
    }

    /*
     * find the power using the bit operations
     * */
    public static long fastpower(long a, long b, long n) {

        long result = 1;
        while(b!=0) {
            if ((b & 1) != 0) // for odd number
                result = (result  * a%n)%n; // since we are having the modules of the result then the result will always we less the n that why we are not taking the modules of the result
            a = (a%n * a%n)%n ;
            b >>>= 1;
        }

        return result;
    }


//    catalanNumber, pigeonhole principle, Inclusion Exclusion principle

    public static void main(String[] args) {
//        System.out.println("mod "+findGCP(24, 1024));
//        System.out.println(fastpower(3, 2));
         System.out.println(fastpower(3978432, 5, 1000000007));
    }
}
