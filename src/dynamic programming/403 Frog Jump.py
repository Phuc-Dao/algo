class Solution:
    """
    Memoization approach. do dfs and store (val, hops) in a dictionary
    """
    def canCross(self, stones: List[int]) -> bool:
        return self.dfs(0, 0, set(stones), stones[-1], {})
    
    def dfs(self, val, hops, nums, target, memo):
        if hops < 0:
            return False
        if val == target:
            return True
        if (val, hops) in memo:
            return memo[(val,hops)]
        # These are the three possbile steps we can take
        can_reach = False
        first = val + hops - 1
        second = val + hops 
        third = val + hops + 1
        if first in nums and first != val:
            can_reach = can_reach or self.dfs(val + (hops - 1), hops - 1, nums, target, memo)
        if (second in nums) and (second != val):
            can_reach = can_reach or self.dfs(val + (hops), hops, nums, target, memo)
        if (third in nums) and (third != val):
            can_reach = can_reach or self.dfs(val + (hops + 1), hops + 1, nums, target, memo)
        memo[(val, hops)] = can_reach
        return can_reach

    """
    At each index in the dp array store a hashset of all possible hops to get to that cell
    
    """
    def canCross(self, stones: List[int]) -> bool:
        dp = [set() for i in range(len(stones))]
        dp[0].add(0)
        for i in range(1, len(stones)):         
            for j in range(i - 1, -1, -1):
                to_jump = stones[i] - stones[j]
                if (to_jump - 1) in dp[j] or to_jump in dp[j] or (to_jump + 1) in dp[j]:
                    dp[i].add(to_jump)
        if not dp[-1]:
            return False
        return True