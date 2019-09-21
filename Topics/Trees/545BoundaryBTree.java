// The approach is to get the left boundary, the leaves of the left subtree, the leaves of right subtree 
// and right boundary seperately
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        list.add(root.val);
        getLeftSubtree(root.left, list );
        getChildren(root.left, list);
        getChildren(root.right, list);
        getRightSubtree(root.right, list);
        return list;
    }
    
    private void getLeftSubtree(TreeNode root, List<Integer> list){
        // if we are a children node then ignore
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        list.add(root.val);
        if(root.left != null){
            getLeftSubtree(root.left, list);
        }
        else{
            getLeftSubtree(root.right, list);
        }    
    }  
    
    // Get the children Nodes
    private void getChildren(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null ){
            list.add(root.val);
            return;
        }
        getChildren(root.left, list);
        getChildren(root.right, list);
    }
    
    private void getRightSubtree(TreeNode root, List<Integer> list){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }      
        if(root.right != null){
            getRightSubtree(root.right, list);
        }
        else{
            getRightSubtree(root.left, list);
        }
        // needs to be reversed so we add at the end
         list.add(root.val);
    }
}