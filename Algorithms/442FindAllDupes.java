class Solution {
    // Since the array is between 1 to n, then each index will map to another index
    // Mark the mapped element as negative and if we ever encount a negative number then
    // add it to the result
    // Lesson: Use the existing array to save space
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i]) - 1] < 0){
                res.add(Math.abs(nums[i]));
            }
            else{
                nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;
            }
        }
        return res;
    }
}