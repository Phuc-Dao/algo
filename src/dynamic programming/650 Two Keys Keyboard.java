/*
 * Inital thought: 
 * We start with an empty buffer and 1 key on the page. Then we have two choices
 * 1. We copy the page to the buffer
 * 2. We paste the buffer onto the page
 * So we take the max between these two possibilities
 */
class Solution {
    public int minSteps(int n) {
        Integer[][] memo = new Integer[n + 1][n + 1];
        return helper(1, 0, n, memo);
    }
    
    public int helper(int curr, int buff, int target, Integer[][] memo){
        if(curr == target) return 0;
        if(buff == target) return Integer.MAX_VALUE;
        if(curr > target) return Integer.MAX_VALUE;
        if(memo[curr][buff] != null) return memo[curr][buff];
        int paste = buff == 0 ? Integer.MAX_VALUE : helper(curr + buff, buff, target, memo);
        int copy = buff == curr ? Integer.MAX_VALUE : helper(curr, curr, target, memo);
        int min = Math.min(copy, paste);
        if(min == Integer.MAX_VALUE) return memo[curr][buff] = min;
        return memo[curr][buff] =  1 + min;
    }
}
