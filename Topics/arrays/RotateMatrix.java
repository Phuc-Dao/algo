class Solution {
    public void rotate(int[][] matrix) {
        int c1 = 0;
        int c2 = matrix.length -1;
        int r1 = 0;
        int r2 = matrix.length - 1;
        
        int len = matrix.length - 1;
        // Outer loop determines the offset
        for(int i = 0; i < (matrix.length + 1)/2; i++){
            for(int j = 0; j < matrix.length/2; j++){
                int topLeft = matrix[i][j]; //Good
                int topRight = matrix[j][len - i];
                int botRight = matrix[len - i][len - j];
                int botLeft = matrix[len - j][i];
                
                int temp = matrix[i][j];
                //Topleft = botLeft
                matrix[i][j] = matrix[len - j][i];
                // Botleft = BotRIght
                matrix[len - j][i] = matrix[len - i][len - j];
                // BotRIght = topRight
                matrix[len - i][len - j] = matrix[j][len - i];
                //Top Right = temp
                matrix[j][len - i] = temp;
                
            }    
        }
    }
}