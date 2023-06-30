package OldCode.Arrays;


/***
 * we have given the stocks and we have to find the
 */

public class StockMarket {


    /* using the aux space  */
    public static int buyStockSpace(int[] arr) { // O(n), O(n) // time & space
        int[] aux = new int[arr.length];
        int localMax = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            localMax = Math.max(localMax, arr[i]);
            aux[i] = localMax;
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxProfit = Math.max(maxProfit, (aux[i] - arr[i]));
        }

        return maxProfit;
    }


    /* Using 2 pointer approach*/
    //{3, 1, 4, 8, 7, 2, 5};
    public static int buyStock(int[] arr) { // O(n) & O(1)
        int minValue = arr[0], maxProfit = 0;

        for (int i = 1; i < arr.length; i++) {
            minValue = Math.min(minValue, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minValue);

        }

        return maxProfit;
    }


    /* we can buy / sell the stock multiple time , but after buy call we can only sell the stocks we cannot buy the stock again*/
    public static int buySellMultipleStock(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > arr[i - 1])
                profit += (arr[i] - arr[i - 1]);


        return profit;
    }


    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 8, 7, 2, 5};
        int[] arr1 = {500, 400, 300, 200, 100};
        System.out.println("max Profit ( with space ) :" + buyStockSpace(arr));
        System.out.println("max Profit ( without space ) :" + buyStock(arr));

        int[] arr2 = {5, 2, 7, 3, 6, 1, 2, 4};
        System.out.println(" Profit after multiple transaction :" + buySellMultipleStock(arr2));


    }
}
