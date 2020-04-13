# Backtracking solution
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.helper(nums, 0, [], res)
        return res
    def helper(self, nums, idx, curr, res):
        res.append(list(curr))
        if(idx == len(nums)):
            return
        for i in range(idx, len(nums)):
            curr.append(nums[i])
            self.helper(nums, i + 1, curr, res)
            curr.pop()