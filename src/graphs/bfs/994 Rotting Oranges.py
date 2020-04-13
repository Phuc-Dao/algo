"""
Inital Thought: My inital thought was to add all the rotten oranges 
and do a different bfs for each rotten orange(By maintaining a seperate queue for each one)
but that's not necissary because we can just have 1 queue, and add multiple different starting
points. Then start bfs
"""
class Solution:
    def getNeighbors(self, grid, r, c):
        coord = [[-1,0], [1,0], [0, -1], [0,1]]
        neighbors = []
        for d in coord:
            new_r = r + d[0]
            new_c = c + d[1]
            if new_c >= 0 and new_c < len(grid[0]) and new_r >= 0 and new_r < len(grid):
                neighbors.append((new_r, new_c))
        return neighbors
    
    def orangesRotting(self, grid: List[List[int]]) -> int:
        oranges = set()
        q = []
        num_added = 0;
        iteration = 0;
        
        # Loop through the grid and add every orange that is rotten to our queue
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(grid[i][j] == 2):
                    oranges.add((i,j))
                    q.append((i,j))
                    num_added += 1
                elif(grid[i][j] == 1):
                    oranges.add((i,j))
        
        # If we added no oranges then they are all good, return 0
        if not oranges:
            return 0
        
        # This is where our bfs begins
        while oranges:
            to_add = 0;
            for i in range(num_added):
                top = q.pop(0)
                if top in oranges:
                    oranges.remove(top)
                for n in self.getNeighbors(grid, top[0], top[1]):
                    if(n in oranges):
                        to_add += 1
                        q.append(n)
            if(to_add == 0 and oranges): 
                return -1
            num_added = to_add
            iteration += 1
        return iteration - 1;