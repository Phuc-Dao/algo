/*
 * Lay out all the possible edge cases first and handle them in your base cases
 * Do I put the recursive solution first
 * The trick is to think of every possible edge case
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

