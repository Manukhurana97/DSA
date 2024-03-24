from ast import List
import sys

class MiniminCoins :
     
     def coinChange(self, coins: List[int], amount: int) -> int:
     #    result =  self.coinChangeRecursion(len(coins)-1, coins, amount)
        
        dp =  [[0] * (amount+1) for _ in range(len(coins))];  
        result =  self.coinChangeMemoization(len(coins)-1, coins, amount, dp)
        return -1 if result>1e9 else result


     def coinChangeRecursion(self, ind: int, coins: List[int], amount: int):
        if(amount == 0): return 0
        if(amount< 0 or ind<0): return 1e9;L̥
          

        take =  1 + self.coinChangeRecursion(ind, coins, amount - coins[ind]) if ( coins[ind] <= amount) else 1e9;
        notTake = self.coinChangeRecursion(ind-1, coins, amount);
        return min(take, notTake);


     def coinChangeMemoization(self, ind: int, coins: List[int], amount: int, dp: List[List[int]]):
        if(amount == 0): return 0
        if(amount< 0 or ind<0): return 1e9
          
        if dp[ind][amount] !=0: return dp[ind][amount];  

        take =  1 + self.coinChangeRecursion(ind, coins, amount - coins[ind]) if ( coins[ind] <= amount) else 1e9;
        notTake = self.coinChangeRecursion(ind-1, coins, amount);

        dp[ind][amount] = min(take, notTake)
        return min(take, notTake)


obj = MiniminCoins();
coins = [1, 2, 5]
amount = 11
print(obj.coinChange(coins, amount))