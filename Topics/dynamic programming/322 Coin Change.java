/*
 * Define dp(i) to be the min coins to make amount i
 * Basecase: dp(0) = 0 => When we have 0 change there is zero ways to make it
 * Recurrance relation: dp(i) = min( dp(i - c_j) ) for all coins c_j that are less than or equal to i
 * See images for diagram
 */

// Backtracking approach
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

// Memoization approach
class Solution {
    public int coinChange(int[] coins, int amount){
        int val = memoization(coins, amount, new Integer[amount + 1]);
        if(val == Integer.MAX_VALUE) return -1;
        return val;
    }
    
    public int memoization(int[] coins, int amount, Integer[] memo){
        if(amount == 0) return 0;
        if(memo[amount] != null) return memo[amount];
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= amount){
                minVal = Math.min(minVal, memoization(coins, amount - coins[i], memo));
            }
        }
        if(minVal == Integer.MAX_VALUE) return memo[amount] = minVal;
        return memo[amount] = 1 + minVal;
    }    
}


// //Dynamic programming appraoch
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