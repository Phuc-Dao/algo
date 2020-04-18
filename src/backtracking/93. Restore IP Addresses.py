'''
93. Restore ip address
We look at every valid subsequence from idx to idx + 4:
If it is valid than add it to curr and recurse on the rest 
'''
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        self.helper(s, 0, [], 0, res)
        return res
    
    # Helper method to check if a subsequence is valid
    def isValid(self, s):
        if(s[0] == "0"):
            return len(s) == 1
        dig = int(s)
        if(dig > 0 and dig <= 255):
            return True
        return False
    
    def helper(self, s, idx, curr, num_dots, res):
        # Basecase occurse when there are 4 segments in curr and the current index is the end
        if(len(curr) == 4):
            if(idx == len(s)):
                res.append(".".join(curr))
            return
        for i in range(idx, min(idx + 3, len(s))):
            ss = s[idx:i+1]
            if self.isValid(ss):
                curr.append(ss)
                self.helper(s, i + 1, curr, num_dots + 1, res)
                curr.pop()
            
        