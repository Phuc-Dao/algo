"""
36. Valid sudoku.
This is a tricky problem because you have to follow the rule without repetition
1. Each row must contain the digits 1-9
2. Each col must contain the digits 1-9
3. Each box must contain the digits 1-9
so we have to maintain a set for each of the row, cols, and boxes
"""
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
		# Creata an array of size 9 to index each of the sets
        col = [set() for i in range(9)]
        row = [set() for i in range(9)]
        squares = [set() for i in range(9)]
        for i in range(9):
            for j in range(9):
                curr = board[i][j]
                # Need to do some math to calculate which set the box number is in
                box_number = (i // 3 ) * 3 + j // 3
                if curr != ".":
                    if(curr in col[j]):
                        return False
                    elif(curr in row[i]):
                        return False
                    elif(curr in squares[box_number]):
                       return False
                    col[j].add(curr)
                    row[i].add(curr)
                    squares[box_number].add(curr)
        return True
        
