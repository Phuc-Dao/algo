// Brute Force Approach: Iterate through every index and count the up, down, left, and right
// Observation: 1. Each column will see the same amount of enemies in the row up to a wall
//              2. We only have to recompute the row when the previous column is a wall
//              3. We can store each column in an array and recompute whenever we see a W
//Optimization: Compute the row and column before hand, and only update when we encounter a wall
//Lessons: You can optimize by store previous results and only recompute when you have to
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        
        if(grid == null || grid.length == 0 ||  grid[0].length == 0) return 0;
        int row = 0;
        int max = 0;
        int[] col = new int[grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // If we are in the first column, or if the previous col was a W, then calculate the entire row for that column
                if(j == 0 || grid[i][j - 1] == 'W') row = countEnemyRow(grid, i,j);
                // If we are the first row or the previous row has a W, then recount the column
                if(i == 0 || grid[i-1][j] == 'W') col[j] = countEnemyCol(grid, i,j);
                // We can only put bombs at an empty cell as per description
                if(grid[i][j] == '0') max = Math.max(max, row + col[j]);  
            }
        }
        return max;
    }
    
    // Count the number of killed enemies for the row
    private int countEnemyRow(char[][] grid, int i, int j){
        int num = 0;
        while(j <= grid[0].length-1 && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') num++;
            j++;
        }
        return num;
    }
    
    //Count the number of killed enemies for the column
    private int countEnemyCol(char[][] grid, int i, int j){
        int num = 0;
        while(i <= grid.length -1 && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') num++;
            i++;
        }
        return num;
    }
}