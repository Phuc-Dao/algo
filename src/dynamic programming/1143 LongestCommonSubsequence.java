
/* Define dp(i,j) = the longest common subsequence between s1[0 : i] and s2[0 : j]
 * Basecase: if i == 0 or j == 0 then return 0
 * Recurance relation (Case analysis):
 *      case1: s1[i] == s2[j]
 *               Then add 1 and recurse on i - 1 and j - 1
 *       case2: s1[i] != s2[j]:
 *               Then the only two options are to move i - 1 or j - 1, take the max between the two
 *
 */
class Solution {   
    // Dynamic programming approach
    public int longestDP(String text1, String text2){
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                // basecase
                if(i == 0 || j == 0) dp[i][j] = 0;
                // case 1
                else if(t1[i - 1] == t2[j - 1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                // case 2
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
    
    
    // Top-down memoization approach
    public int longestHelper(String text1, String text2, int i, int j, Integer[][] memo){
        if(i == 0 || j == 0) return 0;
        if(memo[i][j] != null) return memo[i][j];
        //Case 1: The strings at i j match
        if(text1.charAt(i-1) == text2.charAt(j-1)) return memo[i][j] = 1 + longestHelper(text1, text2, i - 1, j - 1, memo);
        return memo[i][j] = Math.max(longestHelper(text1, text2, i - 1, j, memo), longestHelper(text1, text2, i, j-1, memo));
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        //return longestHelper(text1, text2, text1.length(), text2.length(), new Integer[text1.length() + 1][text2.length() + 1]);
        return longestDP(text1, text2);
    }
}