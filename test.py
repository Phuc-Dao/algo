class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        self.helper(s, 0, "", 0, "", res)
        return res
    
    def helper(self, s, idx, prev, num_dots, curr, res):
        if(num_dots > 3) or len(prev) > 3 or (prev != "" and int(num_dots) > 255):
            return
        if(idx == len(s) and num_dots == 3):
            if(len(prev) > 3):
                return
            res.append(curr)
            return
        if(idx == len(s)):
            return
        print(prev)
        curr = curr + s[idx];
        prev = prev + s[idx]
        self.helper(s, idx + 1, "", num_dots + 1, curr + ".", res)
        self.helper(s, idx + 1, prev, num_dots, curr, res)