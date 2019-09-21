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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        int numAdded = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        numAdded++;
        while(q.peek() != null){
            int children = 0;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < numAdded; i++){
                TreeNode top = q.poll();
                list.add(top.val);
                //Add the children of top
                if(top.left != null){
                    q.add(top.left);
                    children++;
                }
                if(top.right != null){
                    q.add(top.right);
                    children++;
                }
            }
            res.add(list);
            numAdded = children;
        }
        return res;
    }
}
