// We first need to find the inflection point
// 1. If the right bound is less than middle element then the inflection point is in the right half
// 2. else inflection point is in the left half
class Solution{    
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }
    
    public int findMin(int[] nums, int l, int h) {
        // One element so we will return that element
        if (l >= h) {
            return nums[l];
        }
        //Get the middle element
        int mid = (h+l)/2;
        if (nums[mid] > nums[h]) {
            return findMin(nums, mid+1, h);
        }
        return findMin(nums, l, mid);
    }
}