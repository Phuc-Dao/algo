class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        maxint = (2 ** 31) - 1
        queue = collections.deque()
        directions = [[0,1], [0,-1], [1,0], [-1,0]]
        visited = set()
        # add all gates as the starting point ot the queue
        for i in range(len(rooms)):
            for j in range(len(rooms[0])):
                if rooms[i][j] == 0:
                    queue.append((i,j, 0))
        
        while queue:
            top = queue.popleft()
            r, c, val = top[0], top[1], top[2]
            visited.add((r,c))
            if rooms[r][c] == maxint:
                rooms[r][c] = val
            # get neighbors
            for d in directions:
                newr, newc = r + d[0], c + d[1]
                if newr >= 0 and newr < len(rooms) and newc >= 0 and newc < len(rooms[0]) and rooms[newr][newc] == maxint and (newr, newc) not in visited:
                    queue.append((newr, newc, val + 1))
        

            
            