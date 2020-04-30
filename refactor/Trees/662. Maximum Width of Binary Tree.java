/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Use the fact that it is a full binary search tree and keep track
// of the parent node index and find the child index
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        HashMap<TreeNode, Integer> offset = new HashMap<>();
        offset.put(root, 1);
        Queue<TreeNode> q = new LinkedList<>();
        int maxWidth = 0;
        int numAdded = 1;
        q.add(root);
        while(!q.isEmpty()){
            int toAdd = 0;
            int left = -1;
            int right = -1;
            for(int i = 0; i < numAdded; i++){
                TreeNode top = q.remove();
                
                // Handles adding the left and right children
                if(top.left != null){
                    toAdd++;
                    q.add(top.left);
                    offset.put(top.left, offset.get(top) * 2);
                }
                if(top.right != null){
                    toAdd++;
                    q.add(top.right);
                    offset.put(top.right, offset.get(top) * 2 + 1);
                }
                
                //Check if it is left or right bound
                if(left == -1) {
                    left = offset.get(top);
                    right = offset.get(top);
                } else{
                    right = offset.get(top);
                }
                offset.remove(top);
                maxWidth = Math.max(maxWidth, (right - left) + 1);
                
            }
            numAdded = toAdd;
        }
        return maxWidth;
    }
}