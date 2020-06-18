class Solution:
    def numRollsToTarget(self, d: int, f: int, target: int) -> int:
        memo = {}
        # return self.recurse(target, d, f, memo) % ((10**9) + 7)
        return self.bottomup(target, d, f)

    def recurse(self, total, dices, f, memo):
        if total == 0 and dices == 0:
            return 1
        if dices == 0 or total < 0:
            return 0
        if (total, dices) in memo:
            return memo[(total, dices)]
        else:
            num_ways = 0
            # iterate through the faces of the dice
            for i in range(1, f + 1):
                num_ways += self.recurse(total - i, dices - 1, f, memo)
            # Store it in the memoization hashtable
            memo[(total, dices)] = num_ways
            return num_ways
        
    # bottom up dp 
    def bottomup(self, total, dices, f):
        # dp(i,j) where i is the number of dices and j is the faces
        # dp[f][d + 1]
        dp = [[0 for j in range(dices + 1)] for i in range(total + 1)]
        dp[0][0] = 1
        for i in range(total + 1):
            for j in range (1, dices + 1):
                num_ways = 0
                for k in range(1, f + 1):
                    if i - k < 0:
                        continue
                    num_ways += dp[i - k][j - 1]
                dp[i][j] = num_ways
        return dp[total][dices] % (10 ** 9 + 7)
        