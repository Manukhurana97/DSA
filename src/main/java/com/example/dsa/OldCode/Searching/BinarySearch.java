package OldCode.Searching;

/***
 * If the array is sorted
 * Allocate things in contiguous fashion.
 */

public class BinarySearch {

    static int get(int[] arr, int element) {
        int low = 0, high = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == element) return mid;
            else if (mid > element) high = mid - 1;
            else low = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 4, 4, 11};
        System.out.println(get(arr, 0));
    }
}
