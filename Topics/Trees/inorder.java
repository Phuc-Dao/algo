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
    // Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while(!s.isEmpty() || curr != null){
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

