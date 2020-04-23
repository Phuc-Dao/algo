'''
526 contiguous arrays
* The approach is to keep the running sum of the array. Everytime we encounter a 0 we decrement by 1
and if we encounter a 1 we increment by 1. At each index we store the sum so far in a hashmap
* That way when we encounter a a non-zero we know what we need to slice off from the beginning to make it zero
* Example
01001
-----------------
idx = 0
cum_sum = -1
map = {-1: 0}
-----------------
idx = 1
cum_sum = -1 + 1 = 0
map = {-1: 0}
Since cum_sum is 0, we take the global max
-----------------
idx = 2
cum_sum = -1 + 1 - 1 = -1
since cum_sum is -1 we need to get rid of a zero to make the cum_sum zero, so we check in our
map. There is a zero at idx 0, so we slice it off and take the max
'''
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        prefix = {}
        count = 0
        max_val = 0
        for idx, value in enumerate(nums):
            if(value == 1):
                count += 1
            else:
                count -= 1
            
            if(count == 0):
                max_val = max(max_val, idx + 1)
            elif (count in prefix):
                max_val = max(max_val, idx - prefix[count])
            
            if count not in prefix:
                prefix[count] = idx
        return max_val

        