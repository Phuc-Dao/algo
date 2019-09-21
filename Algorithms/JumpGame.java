/*
 * Leetcode 55:
 * Approach: First intuition is to do DP but on closer inspection, we can see that if we 
 * maintain a max reachable square and if at that max index is a zero, then we cannot advance
 * What I learned: 
 * 1. Using the i index as an offset i can just take the max and I dont have to maintain two pointers
 * 2. Don't automatically default to dynamic programming, sometimes there is a greedy approach
 */
class Solution{
    // Greedy approach
    public boolean canJump(int[] nums){
        int max = 0;
        // Iterate to the end of the array
        for(int i = 0; i < nums.length; i++){
            // If we find a zero and we are at the max reachable index then we cannot advance
            if(nums[i] == 0 && i == max && i != nums.length - 1){
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}