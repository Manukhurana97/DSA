package OldCode.Arrays;

public class MaxIndex {

    static int maxIndexDiff(int arr[], int n) {

//        int maxIndex = 0;
//
//        for (int i = 0; i < n; i++)
//            for (int j = i; j < n; j++)
//                if (arr[i] <= arr[j] && maxIndex < (j - i))
//                    maxIndex = j - i;
//
//        return maxIndex;

        int[] aux = new int[n];
        int max = 0;
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                index = i;
                max = arr[i];
            }
            aux[i] = index;
        }

        int i = 0, j = n;
        while (i < j) {
            if (aux[i] != i) {

            }
        }

        return 10;

    }

    public static void main(String[] args) {
//        int[] arr = {97, 65, 24, 84, 10, 82, 2, 51, 1, 91, 62, 59, 80, 76, 26, 66, 11};
        int[] arr = {82, 63, 44, 74, 82, 99, 82};
        int result = maxIndexDiff(arr, arr.length);
//        System.out.println("result " + result);
    }
}


