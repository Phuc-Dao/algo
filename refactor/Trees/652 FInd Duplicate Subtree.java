// THis is retarded why doesnt this work?
class Solution {   
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<Integer, TreeNode> dupe = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        traverse(root, dupe, res, new HashSet<Integer>());
        return res;
    }
    
    boolean checkDupes(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.val != r2.val) return false;
        return checkDupes(r1.left, r2.left) && checkDupes(r1.right, r2.right);
    }
    
    void traverse(TreeNode root, HashMap<Integer, TreeNode> dupes, List<TreeNode> res , HashSet<Integer> visited ){
        if(root == null) return;
        if(dupes.containsKey(root.val) && checkDupes(root, dupes.get(root.val)) && !visited.contains(root.val)){
            res.add(root);
            visited.add(root.val);
        }
        else{
            dupes.put(root.val, root);
        }
        traverse(root.left, dupes, res, visited);
        traverse(root.right, dupes, res, visited);
    }
}