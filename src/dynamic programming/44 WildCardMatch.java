/*
 * Using top-down memoization. Pretty much just cache the recursive implementaiton
 * Recursive implementation:
 * Basecase: if string pointer and pattern pointer are at the end, then we are done
 * Basecase: If we have no more pointer characters but we have string character than return false
 * Basecase: If we are are on the last character of String s, check if the remaining patterns are *
 * Basecase: If the computation has already been made then return the result
 * Recursive case: If we reach a question mark and the characters are teh same, then we increment both pointers
 * Recursive case: If we reach a star we have two choices, move the pattern pointer + 1 or move the string pointer + 1
 */
class Solution {
    boolean helper(String s, String p, int sidx, int pidx, Boolean[][] dp){
        boolean res = false;
        if(sidx == s.length() && pidx == p.length()){
            res = true;
        }
        else if(pidx == p.length()){
            res = false;
        }
        else if(dp[sidx][pidx] != null) return dp[sidx][pidx];
        else if(sidx == s.length() && p.charAt(pidx) == '*'){
            res = helper(s, p, sidx, pidx + 1, dp);
        }
        else if(sidx == s.length()) res = false;
        else if(p.charAt(pidx) == '*') res =  helper(s, p, sidx + 1, pidx, dp) || helper(s, p, sidx, pidx + 1, dp);
        else if(s.charAt(sidx) == p.charAt(pidx) || p.charAt(pidx) == '?') res = helper(s, p, sidx + 1, pidx + 1, dp);
        dp[sidx][pidx] = res;
        return dp[sidx][pidx];   
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length()+ 1];
        return helper(s, p , 0, 0, dp);
    }
}

// Recursive implementation'
class Solution {
    boolean helper(String s, String p, int sidx, int pidx, Boolean[][] dp){
        if(sidx == s.length() && pidx == p.length()) return true;
        if(pidx == p.length()) return false;
        if(sidx == s.length() && p.charAt(pidx) == '*') return helper(s, p, sidx, pidx + 1, dp);
        if(sidx == s.length()) return false;
        if(p.charAt(pidx) == '*') return helper(s, p, sidx + 1, pidx, dp) || helper(s, p, sidx, pidx + 1, dp);
        if(s.charAt(sidx) == p.charAt(pidx) || p.charAt(pidx) == '?') return helper(s, p, sidx + 1, pidx + 1, dp);
        return false;
    }
    
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return helper(s, p , 0, 0, dp);
    }
}