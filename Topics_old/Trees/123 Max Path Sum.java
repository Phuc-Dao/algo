/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxVal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathHelper(root);
        return maxVal;
    }
    
    // Helper method to get the max value of everything in the list
    public int getMaxHelper(List<Integer> list){
        int max = list.get(0);
        for(int i : list){
            max = Math.max(max, i);
        }
        return max;
    }
    
    public int maxPathHelper(TreeNode root){
        if(root == null) return 0;
        int left = maxPathHelper(root.left);
        int right = maxPathHelper(root.right);
        /* Get the max between
         * 1. The current max
         * 2. just the root value
         * 3. root + left
         * 4. root + right
         * 5. left + root + right
         */
        maxVal = getMaxHelper(Arrays.asList(maxVal, root.val, root.val + left, root.val + right, root.val + left + right));
        /* return the max single branch by taking the max between
         * 1. The root
         * 2. THe root + the left branch
         * 3. THe root + the right branch
         */
        return getMaxHelper(Arrays.asList(root.val, root.val + left, root.val + right));
        // Return the max single Path
    }
    
}
