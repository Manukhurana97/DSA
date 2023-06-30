package OldCode.Sorting;


public class InsertionSort {

     static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            int aux = arr[i];
            while (j >= 0 && arr[j] > aux) {
                arr[j + 1] = arr[j];
                j--;
            }
            if (j == i) return;;

            arr[j + 1] = aux;
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
