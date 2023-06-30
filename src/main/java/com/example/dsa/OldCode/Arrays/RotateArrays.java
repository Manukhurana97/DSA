package OldCode.Arrays;

public class RotateArrays {
    static void rotateArr(int arr[], int d, int n)
    {
        // for(int i=0;i<d;i++){
        //     int temp = arr[0];
        //     for(int j=1;j<n;j++){
        //         arr[j-1] = arr[j];
        //     }
        //     arr[n-1] = temp;
        // }

        d %= n;
        rotate(arr, 0, d-1);
        rotate(arr, d, n-1);
        rotate(arr, 0, n-1);

    }

    static void rotate(int[] arr, int start, int end){

        while(start< end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end -= 1;
            start += 1;
        }
    }
}
