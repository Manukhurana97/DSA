package OldCode.Searching;

public class AllocateMinPages {

    private static int minPages(int[] arr, int students) { // O(nlogn)+ O(n)
        int min = Integer.MAX_VALUE;
        int maxSum = 0;
        int res = 0;

        for (int i : arr) { //O(n)
            min = Math.min(min, i);
            maxSum += i;
        }

        while (min <= maxSum) {  // O(log n)
            int mid = (min + maxSum) / 2;
            if (validateMin(arr, mid, students)) { // O(n)
                res = mid;
                maxSum = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }

    private static boolean validateMin(int[] arr, int mid, int students) {
        int student = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > mid) {
                student++;
                sum = arr[i];
            } else sum += arr[i];
        }
        return (student <= students);
    }

    public static void main(String[] args) {
        int[] arr = {10, 10, 20, 30};
        int result = minPages(arr, 2);
        System.out.println("result (2 student) : " + result);

        result = minPages(arr, 3);
        System.out.println("result (3 student): " + result);
    }
}
