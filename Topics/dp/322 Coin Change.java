// Backtracking approach
// Falls under the category of if you know n - 1 how can you use to solve for n
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int res = coinChange(coins, amount - coins[i]);
            if(res != -1) min = Math.min(res, min);
        }
        if(min == Integer.MAX_VALUE) return -1;
        else return min + 1;
    }
}

//Dynamic programming appraoch
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i < dp.length; i++){
            int min =  Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                // Checks if we are still within the bounds
                if(i - coins[j] >= 0){
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            if(min == Integer.MAX_VALUE) dp[i] = min;
            else dp[i] = 1 + min;
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }
}