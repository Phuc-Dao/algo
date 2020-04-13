"""
268. Missing number
"""
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        """
        count = 0
        for i in range(len(nums) + 1):
            count += i
        for elems in nums:
            count -= elems
        return count
        """
        # We can optimize the above by doing addition and sub in one pass
        count = 0
        for i in range(len(nums)):
            count += i - nums[i]
        return count + len(nums)