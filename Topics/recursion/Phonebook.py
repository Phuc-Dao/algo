class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if(len(digits) == 0):
            return []
        
        phoneMap = {
            "2" : ["a" , "b" , "c"],
            "3" : ["d" , "e" , "f"],
            "4" : ["g" , "h" , "i"],
            "5" : ["j" , "k" , "l"],
            "6" : ["m" , "n" , "o"],
            "7" : ["p" , "q" , "r", "s"],
            "8" : ["t" , "u" , "v"],
            "9" : ["w" , "x" , "y", "z"],
        }
        result = []
        self.helper(0, result, phoneMap, [], digits)
        return result
    def helper(self, n, result, phoneMap, current, digits):
        if(n == len(digits)):
            result.append(''.join(current))
        else:
            possibleChar = phoneMap[digits[n]]
            for c in possibleChar:
                current.append(c)
                self.helper(n + 1, result, phoneMap, current, digits)
                current.pop()