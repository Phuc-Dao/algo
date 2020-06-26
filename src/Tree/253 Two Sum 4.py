# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: TreeNode, k: int) -> bool:
        count = defaultdict(int)
        # self.traverse(root, count)
        # return self.findPair(root, count, k)
        return self.findPairBetter(root, set(), k)
    def traverse(self, root, count):
        if root is None:
            return
        count[root.val] += 1
        self.traverse(root.left, count)
        self.traverse(root.right, count)
        
    def findPair(self, root, count, target):
        if root is None:
            return False
        count[root.val] -= 1
        if count[root.val] == 0:
            del count[root.val]
        if (target - root.val) in count:
            return True
        return self.findPair( root.left, count, target) or self.findPair(root.right, count, target)
    
    """
    This is the optimized version, we don't need to traverse twice
    """
    def findPairBetter(self, root, visited, target):
        if root == None:
            return False
        if (target - root.val) in visited:
            return True
        visited.add(root.val)
        return self.findPairBetter(root.left, visited, target) or self.findPairBetter(root.right, visited, target)