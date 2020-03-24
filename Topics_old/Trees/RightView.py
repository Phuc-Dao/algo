# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#Perform level order traversal and keep track of the last element popped
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        #Edge case
        if root is None:
            return []
        q = collections.deque()
        q.append(root)
        result = []
        numAdded = 1
        while q:
            lastPopped = None #TreeNode type
            children = 0
            for i in range(0, numAdded):
                lastPopped = q.popleft()
                if(lastPopped.left != None):
                    q.append(lastPopped.left)
                    children += 1
                if(lastPopped.right != None):
                    q.append(lastPopped.right)
                    children += 1
            if lastPopped != None:
                result.append(lastPopped.val)
            numAdded = children
        return result            
        