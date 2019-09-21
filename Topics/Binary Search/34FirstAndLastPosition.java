// Approach 1: My first approach was to find the first instance of target and expand around.
// A better approach is to do two binary searches and look for the left and right endpoints
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0) return res;
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        // If does not equal target then it does not exist
        if(nums[left] != target) return res;
        //Store the left value
        res[0] = left;
        //Set the right right bound to the end of the array
        right = nums.length - 1;
        
        // Perform second binary search to find the end point
        while(left < right){
            int mid = (left + right) / 2 + 1;
            if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid;
            }
        }    
        res[1] = left;
        return res;
    }
}