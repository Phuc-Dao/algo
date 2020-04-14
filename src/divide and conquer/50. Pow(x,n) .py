"""
50. Pow(x,n)
Note: This is a good divide and conquer problem. The pattern is if we can split 
something in half and both halves are the same, then we can just compute one half
 and not compute the over half (cause they are the same)

Brute force: multiply x by iteslf n times O(n) time
Optimization:
Notice that x^n = x*x*x*x .... *x 
If we split it in half both halves will multiply to the same result. Then we only
need to compute half and then multiply it with itself to get the full thing.

Odd case: If n is odd, then we still do the same thing, but just multiply with x one more time
"""
class Solution:
    def myPow(self, x: float, n: int) -> float:
        res = self.helper(x, abs(n))
        if( n < 0):
            res = 1 / res
        return res
    
    def helper(self, x, n):
        if n == 0:
            return 1
        elif n == 1:
            return x
        res = self.helper(x, n // 2)
        res = res * res
        if n % 2 != 0:
            res = res * x
        return res