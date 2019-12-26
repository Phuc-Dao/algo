/* Preorder traversal goes root -> left subtree -> rightsubtree, so we know that index 0 is
 * the root.
 * Preorder traversal will ensure that if there is an element in the left subtree the root will be the next index for 
 * example: preorder: [3,5,6], so the root of the left subtree is a index 1
 *              3
 *             / \
 *            5   6
 * But what if the next element in preorder is in the right subtree?
 * Example: [3,5,6]
 *            3
 *             \
 *              5 
 *               \
 *                6 
 * We can use the inorder traversal to determine how many elements are in the left subtree and skip to the 
 * that number of elements to get the root of the right subtree.
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Map of intergers to indexs in the inorder
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, map, 0, inorder.length - 1);   
    }
    /*
     * int preIdx: The current index in preorder traversal, this is the current root
     * HashMap<Integer, Integer> map, we need to quickly get the index of preIdx in inorder array,
     * so we use a hashmap to quickly get the index
     * int l : This is the left bound of the subarray in inorder
     * int r : This is the irght bound of the subarray in inorder
     * We use the bounds to section off the inorder array
     */
    TreeNode helper(int[] preorder, int[] inorder, int preIdx, HashMap<Integer, Integer> map, int l, int r){
        // If l > r then that means there is no elements in the subarray, so return null
        if(l > r) return null;
        TreeNode root = new TreeNode(preorder[preIdx]);
        // get the index of the root in the inorder traversal
        int inorderIdx = map.get(preorder[preIdx]);
        // Get the number of elements left of the root in inorder traversal
        int numLeft = inorderIdx - l;
        // The root of the left subtree will always be the current index in preorder + 1
        root.left = helper(preorder, inorder, preIdx + 1, map, l, inorderIdx - 1);
        // The root of the right subtree will be however many elements in the left subtree + 1
        root.right = helper(preorder, inorder, preIdx + numLeft + 1, map, inorderIdx + 1, r);
        return root;
    }    
}