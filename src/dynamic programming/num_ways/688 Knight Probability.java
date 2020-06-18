/* From the starting position we could move to 8 possible locations.
 * So for each possible postition i,j that we can move, the probability of picking that move is 1/8. So its 1/8 * f(i,j, k - 1). Note we   *have to decrease the amount of steps that we have taken
 * Recurrance: The states are the row, column, and number of steps taken
 * dp[r][c][k] = \sum 0.125 * dp[i][j][k-1] for every j,k that are reachable from r,c
 * Base case: If we leave the board then probabilty is zero, if we run out of steps then probability is 1
 */
class Solution {
    int[][] dir = {{1,2},{1,-2},{-1,-2},{-1,2},{2,1},{-2,-1},{-2,1},{2,-1}};
    public double knightProbability(int N, int K, int r, int c) {
        Double[][][] memo = new Double[N][N][K + 1];
        return knightProbabilityHelper(N, K, r, c, memo );
    }
    
    public double knightProbabilityHelper(int N, int K, int r, int c, Double[][][] memo) {
        if(r < 0 || r > N-1 || c < 0 || c > N - 1) return 0;
        if(K == 0) return 1;
        if(memo[r][c][K] != null) return memo[r][c][K];
        double sum = 0;
        for(int[] d : dir){
            sum += 0.125 * knightProbabilityHelper(N, K - 1, r + d[0], c + d[1], memo);
        }
        return memo[r][c][K] = sum;
    }     
}