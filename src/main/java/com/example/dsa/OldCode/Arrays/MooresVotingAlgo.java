package OldCode.Arrays;

public class MooresVotingAlgo {

    public static void findMajority(int[] arr) {
        int elemIndex = 0;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            count = (arr[i] == arr[elemIndex]) ? count + 1 : count - 1;
            if (count == 0) {
                elemIndex = i;
                count = 1;
            }
        }
        int newCount = 0;
        for (int elem : arr)
            if (arr[elem] == arr[elemIndex])
                newCount += 1;

        if (newCount >= (arr.length) / 2) {
            System.out.println(arr[elemIndex] + " is has the max count");
        } else System.out.println("no number found");

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 1};
        findMajority(arr);
    }
}
