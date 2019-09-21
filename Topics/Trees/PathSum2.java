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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        pathSum(root, sum, new ArrayList<>(), result);
        return result;
    }
    
    private void pathSum(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result){
        if(root.left == null && root.right == null & root.val == sum){
            current.add(root.val);
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
            return;
        }
        else if(root.left == null && root.right == null){
            return;
        }
        else{
            current.add(root.val);
            if(root.left != null){
                pathSum(root.left, sum - root.val, current, result);
            }
            if(root.right != null){
                pathSum(root.right, sum - root.val, current, result);
            }
            current.remove(current.size() - 1);
        }
    }
}