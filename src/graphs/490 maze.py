"""
490. Maze
Simple dfs or bfs solution
"""
class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        self.maze = maze
        self.visited = set()
        self.target_row, self.target_col = destination
        return self.dfs(start[0], start[1])
        
    def dfs(self, row, col):
        if row == self.target_row and col == self.target_col:
            return True
        reachable = False
        self.visited.add((row, col))
        for n in self.getNeighbors(row, col):
            if n not in self.visited:
                reachable = reachable or self.dfs(n[0], n[1])
        return reachable
        
    def getNeighbors(self, row, col):
        res = []
        curr_row = row
        curr_col = col
        # Get the top neighbor
        while curr_row >= 0 and self.maze[curr_row][col] != 1:
            curr_row -= 1
        if (curr_row + 1, col) not in self.visited:
            res.append((curr_row + 1, col))
         
        # Get the bottom neighbor
        curr_row = row
        while curr_row < len(self.maze) and self.maze[curr_row][col] != 1:
            curr_row += 1
            
        if (curr_row - 1, col) not in self.visited:
            res.append((curr_row - 1, col))
        
        # Get the left neighbor
        curr_row = row
        while curr_col >= 0 and self.maze[row][curr_col] != 1:
            curr_col -= 1
        if (curr_row, curr_col + 1) not in self.visited:
            res.append((curr_row, curr_col + 1))
        
        curr_col = col
        while curr_col < len(self.maze[0]) and self.maze[row][curr_col] != 1:
            curr_col += 1
        if (curr_row, curr_col - 1) not in self.visited:
            res.append((curr_row, curr_col - 1))   
        return res