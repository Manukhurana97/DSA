package OldCode.Heap;

public class Heapify {

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i;
        int r = 2 * i + 1;

        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void heapsort(int[] arr, int n) {

 // creating heap
        for (int i = n / 2; i >= 0; i--)
            heapify(arr, n, i);


// heap sort
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0); // we are creating heapify, arrange the heap
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 1, 3, 9, 7};
        heapsort(arr, arr.length);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
