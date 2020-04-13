"""
135. Candy
"""
class Solution:
    """
    My sorting solution. Process the children with the lowest ratings first. 
    """
    def candy(self, ratings: List[int]) -> int:
        sorted_ratings = []
        candies = 0
        count = [0 for i in range(len(ratings))]
        
        # Add tuples so we can sort by values, and then by number of elements that are greater, and then by index
        for idx, elem in enumerate(ratings):
            num_greater = 0
            if idx != 0 and ratings[idx - 1] >= elem:
                num_greater += 1
            if idx != len(ratings) - 1 and ratings[idx + 1] >= elem:
                num_greater += 1
            sorted_ratings.append((elem, num_greater, idx))
            
        # Sort the actual tuples
        sorted_ratings.sort()
        
        # Iterat through the sorted elements
        for elem in sorted_ratings:
            # Number of candies the left neighbor has
            left_candies = 0
            # Number of candies the right neighbor has
            right_candies = 0
            if elem[2] != 0 and elem[0] > ratings[elem[2] - 1]:
                left_candies = count[elem[2] - 1]
            if elem[2] != len(ratings) - 1 and elem[0] > ratings[elem[2] + 1]:
                right_candies = count[elem[2] + 1]
            count[elem[2]] =  1 + max(left_candies, right_candies)
            candies += count[elem[2]]
        return candies
    
    """
    O(n) two-pass solution. First pass only look at elements to the left
    second pass only look at elements from the right.
    Example
    """
    def candy(self, ratings):
        candies = [1 for i in range(len(ratings))]
        candy_sum = 0
        #First pass
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1]:
                candies[i] = 1 + candies[i-1]
        #Second pass
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i + 1] + 1, candies[i])
            candy_sum += candies[i]
        candy_sum += candies[len(candies) - 1]
        return candy_sum
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        