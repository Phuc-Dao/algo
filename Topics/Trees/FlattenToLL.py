# Approach: Flatten the left child, flatten the right child then append the right child to the end of the right child
# First Apprach: I was thinking of all these edge cases, you do not have to make it that complicated, just
# work on left subtree and then right subtree and then combine the two subtrees together
class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if(root == None):
            #do nothing
            return
        else:
            # Flatten the left side and flatten the right side first
            self.flatten(root.left)
            self.flatten(root.right)
            
            # Store a temp pointer to the right node, because we will have to append
            # This to at the very end
            temp = root.right
            # Make this the right child
            root.right = root.left
            current = root
            # Go to the very end of the right child
            while current.right != None:
                current = current.right
            current.right = temp
            # Make the lft Null
            root.left = None

    # Wrong Approach            
    # def flattenHelper(self, root: TreeNode) -> TreeNode:
    #     if(root == None):
    #         return None
    #     if(root.left == None and root.right == None):
    #         return root
    #     if(root.left == None):
    #         self.flattenHelper(root.right)
    #     if(root.right == None):
    #         root.right = self.flattenHelper(root.left)
    #     else:
    #         leftNode = self.flattenHelper(root.left)
    #         rightNode = self.flattenHelper(root.right)
    #         current = leftNode
    #         while current.right != None:
    #             current = current.right
    #         current.right = rightNode
    #         root.right = current
    #         root.left = None
    #         return root