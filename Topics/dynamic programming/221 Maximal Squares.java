/* Define dp(i,j) to be the maximal length of the square with the right corner at matrix[i][j]
 * Basecase:  dp[i][j] = matrix[i][j] == '1' ? 1 : 0; for i == 0 or j == 0
 * Recurance relation (Case Analysis):
 * Case 1: if matrix[i][j] = 0 then the largest square with corner ending at matrix[i][j] = 0
 * Case 2: if matrix[i][j] = 1 
 *  Subcase 2a: if left, top, top-left in matrix is zero => then dp[i][j] = 1
 *  Subcase 2b: if they are all 1, then dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) ** This is the tricky part see the 
 * diagram
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    max = Math.max(max, dp[i][j]);
                    continue;
                }
                if(matrix[i][j] == '1'){

                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }       
        return max * max;
    }
}