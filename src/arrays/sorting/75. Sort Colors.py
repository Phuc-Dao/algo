"""
75 sort colors
Partition the array into two regions, one for the red and one for the blue
When we encounter a red we swap it into the red region, adn when we encounter a blue we swap it into the blue region.
"""
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        blue_region = len(nums) - 1
        red_region = 0
        i = 0
        while (i <= blue_region):
            # Add to the blue region
            if(nums[i] == 2):
                nums[i], nums[blue_region] = nums[blue_region], nums[i]
                blue_region -= 1
                # If we swap a blue with another blue then we need to process the same i again
                if(nums[i] == 2):
                    continue
            # Swap i into the red region
            if(nums[i] == 0):
                nums[i], nums[red_region] = nums[red_region], nums[i]
                red_region += 1
            i += 1
            