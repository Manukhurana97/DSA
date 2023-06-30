package OldCode.Searching;

public class BinarySearchRotatedArray {

    static int search(int[] arr, int element) {

        int low = 0, high = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == element) return mid;

            if (arr[low] < arr[mid]) { // sorted (low to mid)
                if (element >= arr[low] && element < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else { // not sorted
                if (element > arr[mid] && element <= arr[high]) {
                    low = mid + 1;
                } else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {12, 13, 4, 5, 6, 7, 8, 9, 10, 11};
        search(arr, 6);
    }

}
