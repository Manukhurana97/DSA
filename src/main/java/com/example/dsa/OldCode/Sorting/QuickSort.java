package OldCode.Sorting;

public class QuickSort {

    static int getPivot(int[] arr, int start, int end) {
        int pivot = arr[end], j = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        int temp = arr[j];
        arr[j] = pivot;
        arr[end] = temp;
        return --j;
    }

    static void sort(int[] arr, int start, int end) {
        if (start < end) {

            int midIndex = getPivot(arr, start, end);

            sort(arr, start, midIndex - 1);
            sort(arr, midIndex + 1, end);
        }
    }

    static void display(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        sort(arr, 0, arr.length-1);
        display(arr);
    }
}
