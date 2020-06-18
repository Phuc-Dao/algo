"""
304 Range sum Query
The solution to this problem was inspired by bomb enemies and dynamic programming
This problem uses the concept of caching, to store redundant computation. Store the runnign
sum of each subsqare in the matrix. Then when we call sumRegion, we can diff the the subregion
"""
class NumMatrix:
    def __init__(self, matrix):
        self.matrix = matrix
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if i == 0 and j == 0:
                    continue
                elif i == 0:
                    self.matrix[i][j] += self.matrix[i][j - 1]
                elif j == 0:
                    self.matrix[i][j] += self.matrix[i-1][j]
                else:
                    left = self.matrix[i][j - 1]
                    top = self.matrix[i - 1][j]
                    diag = self.matrix[i - 1][j - 1]
                    self.matrix[i][j] += left + top - diag

    def sumRegion(self, row1, col1, row2, col2):
		left, top, diag = 0, 0, 0
		if col1 != 0:
			left = self.matrix[row2][col1 - 1]
		if row1 != 0:
			top = self.matrix[row1 - 1][col2]
		if row1 != 0 and col1 != 0:
			diag = self.matrix[row1 - 1][col1 - 1]
		# since we double subtract we need to add in the diag value because this is 
		# the intersection of left and top, and we double subtracted
		return self.matrix[row2][col2] - left - top + diag


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)
matrix = NumMatrix([[1,2,3],[4,5,6],[7,8,9]])
print(matrix.sumRegion(1,1,2,2))
