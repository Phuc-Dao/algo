
/* See Notes for recurrance Relation
 * Approach: Check every  possible prefix of that string in the dictionary of
 * words, if it is found in the dictionary, then the recursive function is called 
 * for the remaining portion of that string. And, if in some function call it 
 * is found that the complete string is in dictionary, then it will return true.
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
    }

    // Using top down dynamic programming 
    public boolean helper(String s, int start, HashSet<String> dict, Boolean[] dp){
        if(start == s.length()) return true;
        if(dp[start] != null) return dp[start]; //Add check to see if the solution is cached
        for(int i = start; i < s.length(); i++){
            String currSubstring = s.substring(start, i + 1);
            if(dict.contains(currSubstring) && helper(s, i + 1, dict, dp)){
                dp[start] = true;
                return dp[start];
            }
        }
        dp[start] = false;
        return dp[start];
    }    
}

// Backtracking approach
public boolean helper(String s, int start, HashSet<String> dict, Boolean[] dp){
    if(start == s.length()) return true;
    for(int i = start; i < s.length(); i++){
        String currSubstring = s.substring(start, i + 1);
        if(dict.contains(currSubstring) && helper(s, i + 1, dict, dp)){
            return dp[start];
        }
    }
    dp[start] = false;
    return dp[start];
}    