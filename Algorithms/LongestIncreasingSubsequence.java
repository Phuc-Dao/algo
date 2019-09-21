// Brute force
class Solution {
    public int lengthOfLIS(int[] nums) {
        return getLIS(nums, 0, Integer.MIN_VALUE);
    }
    
    private int getLIS(int[] nums, int curr, int prev){
        if(curr >= nums.length){
            return 0;
        }
        if(nums[curr] > prev){ 
            return Math.max(1 + getLIS(nums, curr + 1, nums[curr]), getLIS(nums, curr + 1, prev));  
        }
        else{
            return getLIS(nums, curr + 1, prev);
        }
    }
}
// Topdown memoization O(n^2) space and time
class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return getLIS(nums, 0, -1, memo);
    }
    
    private int getLIS(int[] nums, int currPos, int prevPos, Integer[][] memo){
        if(currPos == nums.length){
            return 0;
        }
        else if(prevPos > -1 && memo[currPos][prevPos] != null){
            return memo[currPos][prevPos];
        }
        else if(prevPos == -1){
            int with = 1 + getLIS(nums, currPos + 1, currPos, memo);
            int without = getLIS(nums, currPos + 1, prevPos, memo);
            memo[currPos][0] = Math.max(with, without);
            return memo[currPos][0];
        }
        else if( nums[currPos] > nums[prevPos]){
            int with = 1 + getLIS(nums, currPos + 1, currPos, memo);
            int without = getLIS(nums, currPos + 1, prevPos, memo);
            memo[currPos][prevPos] = Math.max(with, without);
            return memo[currPos][prevPos];
        }
        else{
            memo[currPos][prevPos] = getLIS(nums, currPos + 1, prevPos, memo);
            return memo[currPos][prevPos];
        }
    }
}
// Bottom up dp (O^n2) time O(n) space
class Solution{
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int globalMax = 1;
        dp[0] = 1;
        for(int i = 1; i< dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            globalMax = Math.max(dp[i], globalMax);
        }
        for(int i = 0; i < dp.length; i++){
            System.out.println(dp[i]);
        }
        return globalMax;
    }
}