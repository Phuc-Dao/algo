# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#Runtime is O)n)
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        return self.sortedHelper(nums, 0, len(nums) - 1)
    def sortedHelper(self, nums, left, right):
        if(left > right):
            return None
        mid = (left + right) // 2
        node = TreeNode(nums[mid])
        node.left = self.sortedHelper(nums, left, mid - 1)
        node.right = self.sortedHelper(nums, mid + 1, right)
        return node