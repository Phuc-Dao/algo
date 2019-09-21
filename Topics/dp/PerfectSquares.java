class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0){
                min = Math.min(min, dp[i - j*j]);
                j++;
            }
            dp[i] = 1 + min;
        }
        return dp[n];
    }
}