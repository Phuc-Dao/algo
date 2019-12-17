class Solution {
    /* 
     * Base case explanation: 
     * If word1 is the empty string, it takes n insetions to make it equal to word2
     * and if word2 is empty we need to make n deletions to make word1 equal to word 2
     * Reccurance relation explantion: 
     * remove: If we remove a character w1 then thats the same as recursing on m - 1 and n (n doesnt change)  
     * add: If we add a character then that is the same as recursing m and n - 1 (since we assume the character we sub in will be the same we can ignore the last character of w2) Example: w1 = co w2 = cog -> we put in g at the end of w1 and we recurse on co and co
     * If we replace a character then we move m and n down one because we assume we replace the correct character
     * If they are the same character then we do nothing and recurse on m-1 and n-1
     * Let m be current index of word 1, and n be the current word index of word 2
     * if word1[m] == word2[n] -> A[m][n] = A[m-1][n-1]
     * A[m][n] = 1 + minimum(A[m-1][n], A[m-1][n-1], A[m][n -1]);
     */
    
    public int helper(Integer[][] dp, String word1, String word2, int m, int n){
        if(m == 0) return n;
        if(n == 0) return m;
        if(dp[m][n] != null) return dp[m][n];
        if(word1.charAt(m - 1) == word2.charAt(n - 1)) return dp[m][n] = helper(dp, word1, word2, m- 1, n -1);
        int remove = helper(dp, word1, word2, m - 1, n);
        int replace = helper(dp, word1, word2, m - 1, n - 1);
        int add = helper(dp, word1, word2, m, n - 1);
        return dp[m][n] = 1 + Math.min(Math.min(remove, replace), add);            
    }
    
    public int minDistance(String word1, String word2) {
        return helper(new Integer[word1.length() + 1][word2.length() + 1], word1, word2, word1.length(), word2.length());
    }
}