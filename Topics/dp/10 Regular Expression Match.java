/*
 * Lay out all the possible edge cases first and handle them in your base cases
 * The trick is to think of every possible edge case
 * TODO: Come up with bottom up solution:
 */
class Solution{
    public boolean helper(String s, String p, int sidx, int pidx, Boolean[][] dp){
        if(dp[sidx][pidx] != null) return dp[sidx][pidx];
        if(sidx == s.length() && pidx == p.length()){
            return true;
        }
        else if(pidx == p.length()){
            return false;
        }
        else if(sidx == s.length()){
            if(pidx <= p.length() - 2 && p.charAt(pidx + 1) == '*'){ 
                dp[sidx][pidx] = helper(s,p, sidx, pidx + 2, dp);
                return dp[sidx][pidx];
            }
            else {
                return false;
            }
        }
        else if(sidx == s.length()){
            return false;
        }
        else if(pidx == p.length() - 1){
            if(s.charAt(sidx) == p.charAt(pidx) || p.charAt(pidx) == '.'){ 
                dp[sidx][pidx] = helper(s, p, sidx + 1, pidx + 1, dp);
                return dp[sidx][pidx];
            }
            else{
                return false;
            }
        }
        char first = p.charAt(pidx);
        char second = p.charAt(pidx + 1);
        // If it some character followed by a star
        if(second == '*'){
            if(first == '.' || first == s.charAt(sidx)){
                dp[sidx][pidx] = helper(s, p, sidx + 1, pidx, dp) || helper(s, p, sidx, pidx + 2, dp);
                return dp[sidx][pidx];
            }
            else{
                dp[sidx][pidx] = helper(s,p, sidx, pidx + 2, dp);    
                return dp[sidx][pidx];
            }
        }
        // If the second character isnt a star then it is a letter
        else{
            if(first == '.' || first == s.charAt(sidx)){
                dp[sidx][pidx] = helper(s, p, sidx + 1, pidx + 1, dp);  
                return dp[sidx][pidx];
            } 
            else{
                return false;
            }
        }
    }
    
    public boolean isMatch(String s, String p){
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return helper(s,p,0,0, dp);   
    }   
}




/*
 * Recursive Solution
 */
class Solution{
    public boolean helper(String s, String p, int sidx, int pidx){
        boolean res = false;
        if(sidx == s.length() && pidx == p.length()) return true;
        if(pidx == p.length()) return false;
        if(sidx == s.length()){
            if(pidx <= p.length() - 2 && p.charAt(pidx + 1) == '*') return helper(s,p, sidx, pidx + 2);
            return false;
        }
        if(sidx == s.length()) return false;
        if(pidx == p.length() - 1){
            if(s.charAt(sidx) == p.charAt(pidx) || p.charAt(pidx) == '.') return helper(s, p, sidx + 1, pidx + 1);
            return false;
        }
        char first = p.charAt(pidx);
        char second = p.charAt(pidx + 1);
        // If it some character followed by a star
        if(second == '*'){
            if(first == '.' || first == s.charAt(sidx)){
                return helper(s, p, sidx + 1, pidx) || helper(s, p, sidx, pidx + 2);
            }
            return helper(s,p, sidx, pidx + 2);
        }
        // If the second character isnt a star then it is a letter
        else{
            if(first == '.' || first == s.charAt(sidx)) return helper(s, p, sidx + 1, pidx + 1);
            return false;
        }
        
    }
    
    public boolean isMatch(String s, String p){
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return helper(s,p,0,0);   
    }
    
    
}

