// Look at simple case of just three nodes
// See written notes
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode temp = root.right;
        
        flatten(root.left);
        flatten(root.right);
        root.right = root.left;
        root.left = null;
        
        TreeNode curr = root;
        // Get right most node
        while(curr.right != null){
            curr = curr.right;
        }
        curr.right = temp;      
    }
}