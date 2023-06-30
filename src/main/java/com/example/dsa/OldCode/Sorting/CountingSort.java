package OldCode.Sorting;

public class CountingSort {

    static int[] sort(int[] arr, int n) {
        int output[] = new int[n];
        int max = arr[0];
        int min = arr[0];

        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int[] count = new int[max - min + 1];

        // count the number of time element exist in a list.
        for (int i = 0; i < n; i++) count[arr[i] - min]++;

        // sumc(prev + current)
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];

        // traverse the list in reverse order
        // get the element from the count list and decrement by 1
        // create the new array (result array) of same size of orignal array and then add the value
        for (int i = 0; i < n; i++)
            output[--count[arr[i] - min]] = arr[i];

        for (int i : output)
            System.out.print(i + " ");

        return output;

    }

    public static void main(String[] args) {
        int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10};
        sort(arr, arr.length);

    }
}
