class Solution:
    #3 cases, when there is no zeros, one zeros, or multiple zeros
    # If there are multiple zeros then everything is zero
    # If there are one zeroes, then everything except that zero is a zero,
    # If ther are no zeros, then get total and divide in place
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        total = 1
        zeroCount = 0
        # Get the total multiplcation and the number of zeros 
        for i in nums:
            if i != 0:
                total = total * i
            else:
                zeroCount += 1
        
        # If there are multiple zeros, return all zeros
        if zeroCount > 1: 
            for j in range(0, len(nums)):
                nums[j] = 0
            return nums
        
        for j in range(0, len(nums)):
            if zeroCount == 1:
                if(nums[j] is 0):
                    nums[j] = total
                else:
                    nums[j] = 0  
            else:
                nums[j] = total // nums[j]
        return nums
            