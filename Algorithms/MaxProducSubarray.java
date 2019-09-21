class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        int globalMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = min;
            min = Math.min( nums[i], Math.min(min*nums[i], max * nums[i]));
            max = Math.max( nums[i], Math.max(temp*nums[i], max * nums[i]));
            globalMax = Math.max(globalMax, max);
        }
        return globalMax;
    }
}