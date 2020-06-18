"""
Fixed sliding window
Note: This is not prefix sum problem although it looks very similar 
"""
class Solution:
    def dietPlanPerformance(self, calories: List[int], k: int, lower: int, upper: int) -> int:
        if len(calories) < k:
            return 0
        
        total = 0
        runningSum = sum(calories[0:k-1]) 
        for i in range(0, len(calories) - k + 1):
            # add the end
            runningSum += calories[i + k - 1]
            total += self.getPoints(runningSum, lower, upper)
            # remove the front 
            runningSum -= calories[i]
        return total

    def getPoints(self, consumed, lower, upper):
        if consumed < lower:
            return -1
        elif consumed > upper:
            return 1
        else:
            return 0
        