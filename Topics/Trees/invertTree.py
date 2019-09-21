# Approach: just swap the left and the right.
# Pitfall: The first time I failed because I forgot to return the root. Remember
# You need to return reference to the root
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return None
        else:
            root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
            return root
