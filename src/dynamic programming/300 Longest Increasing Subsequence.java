class longestIncreasingSub{
    
    // Dynamic programming implementation
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int globalMax = 1;
        for(int i = 1; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) max = Math.max(max, dp[j]);
            }
            dp[i] = 1 + max;
            globalMax = Math.max(dp[i], globalMax);
        }
        return globalMax;  
    }

    //Recursive implamentation
    public static int longest(int[] nums, int n){
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        int maxVal = 1;
        //Iterate through every element 
        for(int i = 0 ; i <= n; i++){
            if(nums[i] < nums[n]){
                maxVal =  Math.max(maxVal, 1 + longest(nums, i));
            }
        }
        return maxVal;
    }

    public static void main(String[] args){
        int [] nums = {1,2,3,4,3,2,4,5,6,1};
        System.out.println(longest(nums, nums.length - 1));
    }
}