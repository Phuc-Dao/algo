/*
 * Intuition: At first glance
 *
 *
 *define dp(i,j) to be the maximum coins bursted on the interval (i,j). 

		    i= 0, j= 5
		   [1,3,1,5,8,1]
            ^         ^
		    i         j
	f(i,j) = max( arr[i] * arr[k] * arr[j] + f(i, k) + f(k, j)
	for all k on the interval (i, j)

Working backwards
------------------
How does this handle the boundary issues we were having? Because we define k
to be the last balloon bursted. Then we know that all possible second to last
balloon bursts will be adjacent to k.

Why do we take the maxVal?
--------------------------
Because we have the option of bursting any of the balloons on the interval i,j we don't know which one will be
the most optimal so we take the max of all possibilities


 */
class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        // Creating new array with 1 at the ends
        for(int i = 0; i < nums.length; i++){
            newNums[i + 1] = nums[i];
        }
        return maxCoins(newNums, 0, newNums.length - 1, new Integer[newNums.length][newNums.length]);
    }
    
    
    public int maxCoins(int[] nums, int left, int right, Integer[][] memo){
        if(left == right) return 0;
        if(memo[left][right] != null) return memo[left][right];
        int maxCoins = 0;
        for(int k = left + 1; k < right; k++){
            int leftSubproblem = maxCoins(nums, left, k, memo);
            int rightSubproblem = maxCoins(nums, k, right, memo);
            // We multiply the current coins by the left and right boundary, because we know that the last balloon will be adjacent to the boundaries
            int coinsGained = nums[k] * nums[left] * nums[right];
            // We take the max because these are our possible options to take
            maxCoins = Math.max(maxCoins, leftSubproblem + rightSubproblem + coinsGained);
        }
        return memo[left][right] = maxCoins;
    }
}