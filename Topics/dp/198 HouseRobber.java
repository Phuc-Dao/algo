
class Solution {
    // Dynamic programming using O(n) space
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            dp[i + 1] = Math.max(dp[i ], nums[i] + dp[i - 1]);
        }
        
        return dp[nums.length];
    }
    
    //We can optimize for space because we only need to store the previous 2 results
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        // Store the n - 2 result
        int first = 0;
        // Stores the n - 1 result
        int second = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = Math.max(nums[i] + first, second);
            first = second;
            second = temp;
        }
        return second;
    }
}