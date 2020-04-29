"""
417 Pacific atlantic water flow
Do two seperate dfs from each of the ends from pacific to atlantic, and from atlantic to pacifc
then try to find the intersection of the two visited set.
"""
class Solution:
    def __init__(self):
        self.dir = [[0,1],[0,-1],[1,0],[-1,0]]
    def pacificAtlantic(self, matrix):
        if len(matrix) == 0:
            return []
        rows = len(matrix) 
        cols = len(matrix[0])
        pacific = set()
        atlantic = set()
        
        for i in range(rows):
           # search for atlantic from the pacifc
            self.search(i, cols - 1, matrix,atlantic)
            self.search(i, 0, matrix, pacific)
        for j in range(cols):
            self.search(0, j, matrix, pacific)
            self.search(rows - 1, j, matrix, atlantic)
            
        res = []
        for elem in pacific:
            if elem in atlantic:
                res.append([elem[0], elem[1]])
        return res
    
    # Reach all possible reachable nodes
    def search(self, row, col, matrix, visited):
        visited.add((row, col))
        for n in self.getNeighbors(row, col, matrix, visited):
            self.search(n[0], n[1], matrix, visited)
    
    # returns List(List[int])
    def getNeighbors(self, row, col, matrix, visited):
        res = []
        for d in self.dir:
            new_row = row + d[0]
            new_col = col + d[1]
            if new_row >= 0 and new_row < len(matrix) and new_col >= 0 and new_col < len(matrix[0]) and (new_row, new_col) not in visited and matrix[new_row][new_col] >= matrix[row][col]:
                res.append((new_row, new_col))
        return res