class longestPalindromicSubsequence{
    public static int longest(String s1){
        int dp = new int[s1.length() + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp.length; j++){
                if(i < j){
                    dp[i][j] = 0;
                }
                else if(i == j){
                    dp[i][j] = 1;
                }
                else if(s1[i - 1] == s2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(s1[i - 1] ! = s1[j - 1]){
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s1.length()];
    }
}