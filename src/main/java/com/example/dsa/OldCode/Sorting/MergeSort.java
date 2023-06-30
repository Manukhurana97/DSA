package OldCode.Sorting;

public class MergeSort {

    static void merge(int[] arr, int start, int mid, int end) {
        int m = mid - start + 1;
        int n = end - mid;

        int[] l = new int[m];
        int[] r = new int[n];


        for (int i = 0; i < m; i++) l[i] = arr[start + i];

        for (int i = 0; i < n; i++) r[i] = arr[mid + i + 1];

        int i = 0, j = 0, k = start;
        while (i < m && j < n) arr[k++] = (l[i] < r[j]) ? l[i++] : r[j++];

        while (i < m) arr[k++] = l[i++];

        while (j < n) arr[k++] = r[j++];


    }

    static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);

            merge(arr, start, mid, end);

        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        sort(arr, 0, arr.length - 1);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
