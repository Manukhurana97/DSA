package OldCode.Sorting;

public class SelectionSort {

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int small = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[small] > arr[j]) {
                    small = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[small];
            arr[small] = temp;
            display(arr);

        }
    }

    static void display(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 5, 9, 2};
        sort(arr);
    }
}
