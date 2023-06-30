package OldCode.Arrays;

public class MaximumIndex {
    static int maxIndexDiff(int A[], int n) {


        int[] nle = new int[n]; // min element from left
        int[] nre = new int[n]; // max element from right
        int lmin = Integer.MAX_VALUE;
        int rmax = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            lmin = Math.min(lmin, A[i]);
            nle[i] = lmin;
        }
        for (int i = n - 1; i >= 0; i--) {
            rmax = Math.max(rmax, A[i]);
            nre[i] = rmax;
        }


//        34 8 8 3 2 2 2 2 1
//        80 80 80 80 80 80 33 33 1


        int i = 0, j = 0, res = -1;
        while (i < n && j < n) {
            if (nle[i] <= nre[j]) {
                res = Math.max(j - i, res);
                j++;
            } else {
                i++;
            }
        }

        return res;
    }

    static int maxIndexDiff(int[] A) {
        int n = A.length, m = 0, i = 0, j = n - 1;
        while (i <= j) {
            if (A[i] <= A[j]) {
                m = Math.max(m, j - i);
                i++;
                j = n - 1;
            } else
                j--;
        }
        return m;
    }

    public static void main(String[] args) {
        int[] A = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        maxIndexDiff(A, A.length);
//        int a = maxIndexDiff(A);
//        System.out.println("result " + a);
    }
}
