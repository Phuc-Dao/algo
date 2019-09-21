class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++){
            int currentMin = Integer.MAX_VALUE;
            //Iterate through all the coins
            for(int coin : coins){
                // We ignore all results that are -1, and take the min
                if(i - coin >= 0 && dp[i - coin] != -1){
                    currentMin = Math.min(currentMin, dp[i - coin]);
                }
                // If all the results were -1 then we return -1, otherwise we increment the value by 1
                dp[i] = currentMin == Integer.MAX_VALUE ? -1 : 1 + currentMin;
            }
        }
        return dp[amount];
    }
}