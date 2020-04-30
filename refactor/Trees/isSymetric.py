# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    #Approach: we make two traversals, one to the left and one to the right. And compare if they are the same
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.compare(root, root)
    def compare(self, left, right):
        if(left is None and right is None):
            return True
        elif(left == None or right == None):
            return False
        return left.val == right.val and self.compare(left.right, right.left) and self.compare(left.left, right.right)