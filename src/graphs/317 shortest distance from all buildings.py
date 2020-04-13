from collections import deque
"""
317. Shortest distance from all buildings
Approach:

Do bfs from each of the buildings each time you visit a 0 sqaare, add the number of iterations it took to get to that square.
Then at the end, iterate through the grid and find the square with the minimum distance that was touched by all buildings

"""

class Solution:
    # @param grid -> [[Int]]
    def shortestDistance(self, grid):
        # 0 = num_visited
        # 1 = total
        length_grid = defaultdict(lambda : (0,0))
        num_buildings = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    self.bfs(i, j, set(), length_grid, grid)
                    num_buildings += 1
                    
        # Get the minimum distance of all 0 squares
        min_dist = float("inf")
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0 and length_grid[(i,j)][0] == num_buildings:
                    min_dist = min(min_dist, length_grid[(i,j)][1])
        if min_dist == float("inf"):
            return -1
        return min_dist

    def bfs(self, row, col, visited, length_grid, grid):
        q = deque()
        q.append((row, col))
        num_added = 1
        iteration = 0
        while q:
            to_add = 0
            for i in range(num_added):    
                top = q.popleft()
                # Mark in the length grid
                if grid[top[0]][top[1]] == 0 and (top[0], top[1]) not in visited:
                    elem = length_grid[(top[0], top[1])]
                    length_grid[(top[0], top[1])] = (elem[0] + 1, elem[1] + iteration)
                visited.add(top)
                neighbors = self.getDir(top[0], top[1], visited, grid)
                for d in neighbors:
                    q.append(d)
                to_add += len(neighbors)
            num_added = to_add
            iteration += 1

    def getDir(self, row, col, visited, grid):
        coord = [[0,1],[0,-1],[1,0],[-1,0]]
        res = []
        for c in coord:
            new_row = row + c[0]
            new_col = col + c[1]
            if new_row >= 0 and new_row < len(grid) and new_col >= 0 and new_col < len(grid[0]) and (new_row, new_col) not in visited and grid[new_row][new_col] == 0:
                res.append((new_row, new_col))
        return res