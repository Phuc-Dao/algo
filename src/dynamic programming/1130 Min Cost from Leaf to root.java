// See dc notes
class Solution {
    public int mctFromLeafValues(int[] arr) {
        return helper(arr, 0, arr.length - 1, new Integer[arr.length][arr.length]);
    }
    
    public int helper(int[] arr, int left, int right, Integer[][] memo){
        if(left == right) return 0;
        if(memo[left][right] != null) return memo[left][right];
        int minValue = Integer.MAX_VALUE;
        for(int i = left; i < right; i++){
            // Recurse on the left half of i
            int leftSubtree = helper(arr, left, i, memo);
            // Recurse on the right half of i
            int rightSubtree = helper(arr, i + 1, right, memo);
            // Get max leaf on left subtree and right subtree
            int maxLeft = getMaxLeafValue(arr, left, i);
            int maxRight = getMaxLeafValue(arr, i + 1, right);
            
            // We wannt the min over all these values
            minValue = Math.min(maxLeft * maxRight + leftSubtree + rightSubtree , minValue);
                
        }
        return memo[left][right] = minValue;
    }
    
    public int getMaxLeafValue(int[] arr, int left, int right){
        int max =0;
        for(int i = left; i <=right; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    
    
}