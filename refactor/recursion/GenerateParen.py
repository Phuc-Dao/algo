class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        self.helper(n, n, res, "")
        return res
    
    def helper(self, leftParen, rightParen, result, current):
        #If the right paren is equal to zero then we have no more elements to add
        if rightParen == 0:
            #Do something here
            result.append(current)
        else:
            #Our choices are we either put the left or the right paren
            #Our constraint is how many left and right parens we have left
            #our goal is to use up all the prenthesis
            if leftParen >= rightParen:
                #We cannot place a right paren if we have the same amount of left paren
                self.helper(leftParen - 1, rightParen, result, current + "(")
            elif leftParen == 0:
                #If we only have right paren we cannot place any left
                self.helper(leftParen, rightParen - 1, result, current + ")") 
            elif leftParen < rightParen:
                #If we have less left then right then we have two possibilities, place left and place right
                self.helper(leftParen - 1, rightParen, result, current + "(")
                self.helper(leftParen, rightParen - 1, result, current + ")")
        