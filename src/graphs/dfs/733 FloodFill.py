class Solution:
    def __init__(self):
        self.direction = [[0,1], [0,-1],[1,0],[-1,0]]
        self.visited = set()
        
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.newColor = newColor
        self.oldColor = image[sr][sc]
        self.dfs(image, sr, sc)
        return image
    
    # return void
    def dfs(self, image, sr, sc):
        # Checks out of bounds
        if sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]): 
            return
        # Checks for ending conditions
        if image[sr][sc] != self.oldColor or (sr,sc) in self.visited:
            return
        self.visited.add((sr,sc))
        image[sr][sc] = self.newColor
        for d in self.direction:
            self.dfs(image, sr + d[0], sc + d[1])
        
            
        