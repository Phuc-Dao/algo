/*
 * Method: DP
 * Recurance relation: maxSubArr(arr[i]) = Math.max( maxSubArr(i - 1), maxSubArr(i - 1) + arr[i])
 * Description: Max at index i is the max between not including i which is the subArr(arr[n-1]) and 
  * choosing i, which is the value of i + the subArr(i-1)
 */
class maxSubArray{
    public int maxSubArray(int[] nums) {     
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++){
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;       
    }   
}