# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

"""
366 Find Leaves of Binary Tree
Notice how all the leaves are at the same depth from the bottom.
So we take a bottom approach and count the depth of the tree from the bottom. 
(This works because recursively counting the height starts from the bottom)
Then add the value to that index. Note we could also have used 
a map but then we would have to iterate over it in the end

Initial approach: My initial approach was to do dfs until we visit all the nodes
but this was super expensive because we needed to call it dfs multiple times

"""
class Solution:   
    def findLeaves(self, root: TreeNode) -> List[List[int]]:
        res = []
        self.dfs(root, res)
        return res
    def dfs(self, root, res):
        if not root:
            return 0
        # Get the current depth
        depth = 1 + max(self.dfs(root.left,res), self.dfs(root.right, res))
        # If the current depth exceeds the result array, then we have to add a new array
        if len(res) < depth:
            res.append([])
        res[depth - 1].append(root.val)
        return depth