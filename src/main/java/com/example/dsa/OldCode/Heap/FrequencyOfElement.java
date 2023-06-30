package OldCode.Heap;

public class FrequencyOfElement {

    static void frequency(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            arr[i] -= 1;

        for (int i = 0; i < n; i++)
            arr[arr[i] % n] = arr[arr[i] % n] + n;

        for (int i = 0; i < n; i++) {
            if (arr[i]/n > 0)
                System.out.println(i + 1 + " " + arr[i]/n);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 3, 5};
        frequency(arr, arr.length);
    }
}
