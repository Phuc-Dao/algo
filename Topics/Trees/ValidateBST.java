// Approach: Failed the first approach because did not take into account that every element in the left subtree has to
// be less than the root. Work around for this is to pass in leftLimit and rightLimit and each call restrict the range
// Another approach could be to use inorder traversal and print out the tree inorder
// Runtime: 
// Worstcase: O(n) run time to iterate through all the tree, O(n) to store the nodes
class Solution {
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
    public boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE );
    }
    
    public boolean isValidBST(TreeNode root, long leftLimit, long rightLimit) {
        if(root == null){
            return true;
        }
        if(root.val <= leftLimit || root.val >= rightLimit){
            return false;
        }
        return isValidBST(root.left, leftLimit, root.val) && isValidBST(root.right, root.val, rightLimit);
    }
 }
}