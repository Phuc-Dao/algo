//Leetcode robbers 1: Easy. 
class robber{

    //bottom up dynamic programming
    //O(n) space O(n) time
    //Can be optimized for constant space
    public static int rob(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];     
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1] , nums[i-1] + dp[i-2]);
        }
        return dp[dp.length - 1];
    }

    //O(1) space O(n) time
    public static int optimized(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return nums[0];
        }
        
        //Only hold the previous two values
        int prevprev = 0;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = prev;
            prev = Math.max(nums[i] + prevprev, prev);
            prevprev = temp;
        }        
        return prev;
        }    
    }

}