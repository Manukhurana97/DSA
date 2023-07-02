package OldCode.Arrays;

public class DNF {

    public static int[] swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
        return arr;
    }

    public static void sort012(int arr[], int n) {
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0)
                swap(arr, low++, mid++);
            else if (arr[mid] == 1)
                mid++;
            else
                swap(arr, mid, high--);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 0};
        sort012(arr, arr.length);

        for (var a : arr)
            System.out.println(a);
    }
}
