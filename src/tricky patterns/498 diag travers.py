class Solution:
    def findDiagonalOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []
        up_dir = True
        row, col = 0 , 0
        while row < len(matrix) and col < len(matrix[0]):
            if up_dir:
                # Do something
                while row >= 0 and col < len(matrix[0]):
                    res.append(matrix[row][col])
                    col += 1
                    row -= 1
                prev_row, prev_col = row + 1, col - 1
                up_dir = not up_dir
                if(prev_col + 1 < len(matrix[0])):
                    row = prev_row
                    col = prev_col + 1
                else:
                    col = prev_col
                    row = prev_row + 1
            else:
                # Do something else
                while row < len(matrix) and col >= 0:
                    res.append(matrix[row][col])
                    col -= 1
                    row += 1
                prev_row, prev_col = row - 1, col + 1
                up_dir = not up_dir
                if((prev_row + 1) < len(matrix)):
                    row = prev_row + 1
                    col = prev_col
                else:
                    row = prev_row
                    col = prev_col + 1
        return res                    