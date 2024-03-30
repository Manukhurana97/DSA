from ast import List
import sys

class MiniminCoins :
     
         
     def coinChange(self, coins: List[int], amount: int) -> int:
     #    result =  self.coinChangeRecursion(len(coins)-1, coins, amount)
        
        dp =  [[0] * (amount+1) for _ in range(len(coins))];  
     #    result =  self.coinChangeMemoization(len(coins)-1, coins, amount, dp)
        
     #    result = self.coinChangeTabulation(coins, amount, dp)

        result = self.coinChangeSpaceOptimization(coins, amount)

        return -1 if result>2147483647  else result



     def coinChangeRecursion(self, ind: int, coins: List[int], amount: int):
        if(amount == 0): return 0
        if(amount < 0 or ind<0): return 1e9;L̥
          

        take =  1 + self.coinChangeRecursion(ind, coins, amount - coins[ind]) if ( coins[ind] <= amount) else 1e9;
        notTake = self.coinChangeRecursion(ind-1, coins, amount);
        return min(take, notTake);


     def coinChangeMemoization(self, ind: int, coins: List[int], amount: int, dp: List[List[int]]):
        if(amount == 0): return 0
        if(ind ==0 and amount % coins[ind] == 0): return amount // coins[ind]
        if(amount< 0 or ind<0): return 1e9
          
        if dp[ind][amount] !=0: return dp[ind][amount];  

        take =  1 + self.coinChangeRecursion(ind, coins, amount - coins[ind]) if ( coins[ind] <= amount) else 1e9;
        notTake = self.coinChangeRecursion(ind-1, coins, amount);

        dp[ind][amount] = min(take, notTake)
        return min(take, notTake)
     

     def coinChangeTabulation(self, coins: List[int], amount: int, dp: List[List[int]]):
         
        for ind in range(len(coins)):
            dp[ind][0] = 0 
        for tar in range(0, amount+1):
            dp[0][tar] = tar // coins[0] if tar % coins[0] == 0 else float('inf')


        for ind in range(1, len(coins)):
            for tar in range(0, amount+1):
                take = 1 + dp[ind][tar - coins[ind]] if coins[ind] <= tar else float('inf');
                notTake = dp[ind-1][tar];

                dp[ind][tar] = min(take, notTake)
        return dp[len(coins) -1][amount]
     

     def coinChangeSpaceOptimization(self, coins: List[int], amount: int):
         
        prev = [0] * (amount + 1)
        curr = [0] * (amount + 1)

        for ind in range(len(coins)):
            prev[0] = 0 
        for tar in range(0, amount+1):
            prev[tar] = tar // coins[0] if tar % coins[0] == 0 else float('inf')


        for ind in range(1, len(coins)):
            for tar in range(0, amount+1):
                take = 1 + curr[tar - coins[ind]] if coins[ind] <= tar else float('inf');
                notTake = prev[tar];

                curr[tar] = min(take, notTake)
            prev = curr[:]    

        return prev[amount]

             
     

obj = MiniminCoins();
coins = [1, 2, 5]
amount = 11
print(obj.coinChange(coins, amount))