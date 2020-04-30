
class Solution {
    /*
     * Approach: There are three cases
     * 1. root.left has one node and root.right has another node. In this case return root
     * 2. root.left has one node and root.right is does not, return root left
     * 3. root.right has one node and root.left does not, return root.right
     * Understand the order of things getting visited when doing preorder traversal
     * It helps to look at a really simple case
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        else if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //If left and right not null return the root
        if(left != null && right != null){
            return root;
        }
        //if left is not null return left otherwise return right
        return left != null ?  left : right;
    }
}