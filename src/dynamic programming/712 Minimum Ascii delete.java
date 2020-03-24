/* 
 *This problem is similar to edit distance and longest common subsequence 
 *This is similar to edit distance and longest common subsequence
 * Consider the ith and jth character of strings S1 and S2, 
 * Basecase: if i or j is null, then we return the ascii sum 
 * Case1: If i == j then we have to match then recurse on i - 1, j - 1
 * Case2: if i != j then there are two subcases
 *      subcase a: We delete i, so we add the ascii value of i and recurse on i - 1
 *      subcase b: we delete j, so we add the ascii value of j and recurse on j - 1
 */
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        Integer[][] memo = new Integer[s1.length() + 1][ s2.length() + 1];
        int s1Prefix = 0;
        int s2Prefix = 0;
        
        // Prefilling the memo table
        for(int i = 0; i < s1.length(); i++){
            s1Prefix += s1.charAt(i);
            memo[i + 1][0] = s1Prefix;
        }
        
        for(int j = 0; j < s2.length(); j++){
            s2Prefix += s2.charAt(j);
            memo[0][j + 1] = s2Prefix;
        }
        
        return recurse(s1, s2, s1.length(), s2.length(), memo);  
    }
    
    public int recurse(String s1, String s2, int i, int j, Integer[][] memo){
        if(i == 0 && j == 0) return 0;
        if(memo[i][j] != null) return memo[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)) return recurse(s1, s2, i - 1, j - 1, memo);
        int deleteS1 = (int) s1.charAt(i - 1)  + recurse(s1, s2, i - 1, j, memo);
        int deleteS2 = (int) s2.charAt(j - 1) + recurse(s1, s2, i, j - 1, memo);
        return memo[i][j] = Math.min(deleteS1, deleteS2);
    }
}