// This works because the array has no negative, if it did then we would have
// To use the prefix sum method
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int total = 0;
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            while(total >= s){
                minLen = Math.min(minLen, i - left + 1);
                total = total - nums[left];
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}