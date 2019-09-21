/* Approach: Perform inorder traversal and decrement k count. When it reaches zero then we 
 * have found the kth smallest.
 * Pitfalls: 
 * 1. Initially tried to pass down K as an argument, but this is not going to work because 
 * we have to decrement K immediately. We dont want to decrement K untill we visited the entire left subtree
 * that way we start from the lowest element. see failed notes
 */
class Solution {
    static int res = 0;
    static int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.left);
        count--;
        if(count == 0){
            res = root.val;
            return;
        }
        traverse(root.right);
    }
}

// Wrong Solution
// class Solution {
//     static int res;
//     public int kthSmallest(TreeNode root, int k) {
//         count = k;
//         traverse(root, k);
//         return res;
//     }
//     public void traverse(TreeNode root, int k){
//         if(root == null){
//             return;
//         }
//         if(k == 0){
//             res = root.val;
//             return;
//         }
//         traverse(root.left, k - 1);
//         traverse(root.right, k -1);
//     }