class DistinctIsland {
    public int numIslands(char[][] grid) {
        int numIsland = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    numIsland++;
                }           
            }
        }
        return numIsland;
    }
    
    public static void printGrid(char[][] grid){
       for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
               System.out.println(grid[i][j]);  
            }
        }
    }
    
    public static void dfs(int row, int col, char[][] grid){
        if(row < 0 || col < 0){
            return;
        }
        else if(row >= grid.length || col >= grid[0].length){
            return;
        }
        else if(grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        //recurse up
        dfs(row, col - 1, grid);
        //Recurse down
        dfs(row, col + 1, grid);
        //Recurse left
        dfs(row - 1, col, grid);
        //Recurse right
        dfs(row + 1, col, grid);
    }
}