# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

"""
277. Find the celebrity
Brute force approach. A celebrity knows 0 people and n-1 people know them.
Count the number of people that they know and the number of people that knows them
"""
class Solution:
    def findCelebrity(self, n: int) -> int:
        for i in range(n):
            # Number of people the celebrity knows
            a_knows_b = 0
            # Number of people that know that celebrity
            b_knows_a = 0
            for j in range(n):
                if i == j:
                    continue
                else:
                    if knows(i,j):
                        a_knows_b += 1
                    if knows(j,i):
                        b_knows_a += 1
            if a_knows_b == 0 and b_knows_a == (n - 1):
                return i
        return -1
"""
O(n) Solution.  
"""
class Solution:
    def findCelebrity(self, n):
        candidate = 0;
        for i in range(1,n):
            if(knows(candidate, i)):
                candidate = i;
        for i in range(n):
            if i == candidate:
                continue
            if not knows(i, candidate) or knows(candidate, i):
                return -1
        return candidate
            
    