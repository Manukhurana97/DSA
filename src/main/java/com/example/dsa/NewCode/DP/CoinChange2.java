package com.example.dsa.NewCode.DP;

/* 
 * min coin after exchange 
 * we have inf supply of each coin
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        // return changeRecurssion(coins.length - 1, amount, coins);

        // int[][] dp = new int[coins.length][amount+1];
        // return changeMemoization(coins.length - 1, amount, coins, dp);

        return changeTabulation(amount, coins);
    }

    public int changeRecurssion(int ind, int amount, int[] coins) {
        if (amount == 0)
            return 1;
        if (ind < 0)
            return 0;

        int take = coins[ind] > amount ? 0 : changeRecurssion(ind, amount - coins[ind], coins); // index not reduced
        int notTake = changeRecurssion(ind - 1, amount, coins);

        return take + notTake;
    }

    public int changeMemoization(int ind, int amount, int[] coins, int[][] dp) {
        if (amount == 0)
            return 1;
        if (ind < 0)
            return 0;

        if (dp[ind][amount] != 0)
            return dp[ind][amount];

        int take = coins[ind] > amount ? 0 : changeRecurssion(ind, amount - coins[ind], coins);
        int notTake = changeRecurssion(ind - 1, amount, coins);

        dp[ind][amount] = take + notTake;

        return take + notTake;
    }

    public int changeTabulation(int amount, int[] coins) {

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int ind = 0; ind <= coins.length; ind++)
            dp[ind][0] = 1;

        for (int ind = 1; ind <= coins.length; ind++) {
            for (int amt = 0; amt <= amount; amt++) {
                int notTake = dp[ind - 1][amt];
                int take = coins[ind - 1] > amt ? 0 : dp[ind][amt - coins[ind - 1]];

                dp[ind][amt] = take + notTake;
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5 };
        System.out.println(change(5, arr));

    }
}
