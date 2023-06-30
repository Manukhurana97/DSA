package OldCode.Sorting;

public class BubbleSort {

     static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapFlag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapFlag = true;
                }
            }
            if(!swapFlag) return;
        }

    }

     static void display(int[] arr){
        for(int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 6, 5};
        sort(arr);
    }
}
