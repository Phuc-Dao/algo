/*
 * Runtime: O(V + E) 
 */
class Asana{
    // Coordinates of up down left and right from the current coordinate
    static final int[][] coordinates = {{-1, 0} , {0, 1} , {0, -1}, {1,0}};
    static int getCarrots(int[][] matrix){
        //Get the center of the matrix
        int[] start = getStart(matrix);
        return traverseGarden(matrix, start[0], start[1]);

    }
    
    // Perform dfs on the garden greedily choosing the largest value
    static int traverseGarden(int[][] matrix, int row, int col){
        // If we reach a visited or out of bounds return 0;
        if(row >= matrix.length  || row  < 0 || col  >= matrix[0].length || col  < 0 || matrix[row][col] == -1){
            return 0;
        }
        int max = 0;
        int temp = matrix[row][col];
        // Mark as visited
        matrix[row][col] = -1;
        // Move up down left and right
        for(int i = 0; i < coordinates.length; i++){
            max = Math.max(max, traverseGarden(matrix, row + coordinates[i][0], col + coordinates[i][1]));
        }
        return max + temp;
    }

    // Get the starting coordinates from the matrix
    static int[] getStart(int[][] matrix){
        int row = matrix.length / 2;
        int col = matrix[0].length / 2;
        int[] res = new int[2];
        // If even legnth then get the max between mid and - 1
        if(matrix.length % 2 == 0 && matrix[row - 1][col] > matrix[row][col]){
            row = row - 1;
        }
        if(matrix[0].length % 2 == 0 && matrix[row][col - 1] > matrix[row][col]){
            col = col - 1;
        }
        res[0] = row;
        res[1] = col;
        return res;
    }

    public static void main(String[] args){
        System.out.println("hello world");
        int[][] matrix = {{1,2,3, 5}, {4,5,6, 12} , {7,8,9, 13}};
        System.out.println(getCarrots(matrix));
    }
    
}