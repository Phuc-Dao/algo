
/*
 * define dp(i) to be the maximum product subarray ending at index i
 * Two choices
 * 1. Include it to the previous subarray.:  A[i] * dp(i - 1)
 * 2. Don't include it and create a new subarray: A[i]
 * So we take max(A[i] , A[i]*dp(i-1))
 *
 * However we run into a problem when we get a case like [-2,3,-2] because multiplying 
 * two negative number gives us a positive number, so to combat this we have another 
 * dp array that holds the minimum subarray up to index i. That way we also take into 
 * account negative numbers
 */
class Solution {
    public int maxProduct(int[] nums) {
        int[] maxDp = new int[nums.length + 1];
        int[] minDp = new int[nums.length + 1];
        maxDp[0] = 1;
        minDp[0] = 1; 
        int maxVal = Integer.MIN_VALUE;
        
        for(int i = 1; i < maxDp.length; i++){
            int curr = nums[i - 1];
            int minPrev = minDp[i - 1];
            int maxPrev = maxDp[i - 1];
            maxDp[i] = Math.max(Math.max(curr, curr * minPrev), curr* maxPrev);
            minDp[i] = Math.min(Math.min(curr, curr * minPrev), curr* maxPrev);
            // We have to keep track of the largest value because dp(i) only tells us the largest ending at index i
            maxVal = Math.max(maxVal, maxDp[i]);
        }
        return maxVal;
    }
}