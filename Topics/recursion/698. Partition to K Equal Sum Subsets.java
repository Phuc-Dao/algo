/*
 * Approach: Use backtracking, and have a counter for the subsets and the current total
 * When the total reaches the target, then we decrement the subsets count
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        int target = 0;
        for(int i = 0; i < nums.length; i++){
            target += nums[i];
        }
        if(target % k != 0) return false;
        target = target/k;
        return dfs(0, 0, target, k, visited, nums);
    }
    
    private boolean dfs(int start, int total, int target, int k, boolean[] visited, int[] nums){
        if(total > target) return false;
        if(k == 0) return true;
        if(total == target) return dfs(0, 0, target, k - 1, visited, nums);
        for(int i = start; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(dfs(start + 1, total + nums[i], target, k, visited, nums)) return true;
                visited[i] = false;
            }
        }
        //If we are at the end, then we visited everything so return false
        return false;
    }   
}