class Solution:
    """
    518 coin change 2
    The choices we have to make are to either use the ith coin or to not use it. This
    breaks the solution space into two sets and thus we do not over-count, and so we can add the two recursive subproblems together
    1. If we use the ith coin then our amount is going to decrease by coin[i]
    2. If we don't use the ith coin then the amount stays the same, but we now consider coin[i - 1]
    dp[i][j] = dp[i - coins[i]][j] + dp[i][j - 1]
    where dp[i][j] = the number of ways to make coin i using coin j  
    """
    def change(self, amount: int, coins: List[int]) -> int:
        return self.helper(amount, len(coins) - 1, coins, {})
    def helper(self, amount, curr_coin, coins, memo):
        if amount == 0:
            return 1
        elif curr_coin < 0:
            return 0
        elif (curr_coin, amount) in memo:
            return memo[(curr_coin, amount)]
        else:
            use_coin = 0
            dont_use_coin = 0
            if coins[curr_coin] <= amount:
                # If we use the coin then amount decreases but we still consider the curr_coin
                use_coin = self.helper(amount - coins[curr_coin], curr_coin, coins, memo)
            # We always consider the case when we dont use the coin
            dont_use_coin = self.helper(amount, curr_coin - 1, coins, memo)
            memo[(curr_coin, amount)] = use_coin + dont_use_coin
            return use_coin + dont_use_coin