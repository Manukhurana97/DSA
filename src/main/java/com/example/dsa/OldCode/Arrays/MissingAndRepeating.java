package OldCode.Arrays;

public class MissingAndRepeating {

    int[] findTwoElement(int arr[], int n) {
        long actualSum = n*(n+1)/2;
        long currentSum = 0;
        int duplicate=0;
        for(int i: arr)
            currentSum +=i;


        for(int i=0; i<n; i++){
            if(arr[Math.abs(arr[i])-1]<0)
                duplicate=Math.abs(arr[i]);


            arr[Math.abs(arr[i])-1]*= -1;
        }


        int[] res = new int[2];
        res[0] = duplicate;
        res[1] = (int) (actualSum - (currentSum-duplicate));
        return res;

    }

}
