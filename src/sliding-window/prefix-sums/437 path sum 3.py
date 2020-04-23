from collections import defaultdict
"""
437 Path Sum 3
This problem is similar to subarray sum equals k and you have to use prefix sums.
The important part is that since we have negative numbers, we can reach the same prefix multiple times,
so we have to keep a count of that in dictionary
"""
class Solution:
    def __init__(self):
        # Counter global variable
        self.count = 0
    
    def pathSum(self, root: TreeNode, sum: int) -> int:
        seen = collections.defaultdict(int)
        seen[0] = 1
        # recursive dfs
        self.helper(root, seen, 0, sum)
        return self.count
    
    def helper(self, root, seen, curr_path, target):
        if root is None:
            return
        curr_path += root.val
        if (curr_path - target) in seen:
            self.count += seen[curr_path - target]   
        seen[curr_path] += 1
        self.helper(root.left, seen, curr_path, target)
        self.helper(root.right, seen, curr_path, target)
        # We need to remove one because prefix is a global variable
        # so we backtrack
        seen[curr_path] -= 1
        
# implementation without the use of global variable
class Solution:
    def pathSum(self, root, sum):
        prefix = defaultdict(int)
        prefix[0] = 1
        return self.helper(root, 0, prefix, sum)
        
    def helper(self, root, running_sum, prefix, target):
        if root is None:
            return 0
        curr_sum = running_sum + root.val
        prefix[curr_sum] += 1
        left = self.helper(root.left, curr_sum, prefix, target)
        right = self.helper(root.right, curr_sum, prefix, target)
        count = left + right
        if (curr_sum - target) in prefix:
            print(prefix)
            count += prefix[curr_sum - target]
        prefix[curr_sum] -= 1
        return count