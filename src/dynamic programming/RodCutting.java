
class RodCutting {
    //Each index of p is mapped to the price for that length of rod
    //For example p[0] = price of rod length 0
    //Note sometimes the price of rod length 0 is not included so p[n] = rod of length n-1 so adjust accordingly
    public static int cutRod(int[] p, int n){
        int dp[] = new int[n + 1]; //Create size n=1 because we want to go to index n
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int max = Integer.MIN_VALUE;
            //We take the min of every subproblem to the currents
            for(int j = 0; j < i; j++){
                max = Math.max(max, p[i-j-1] + dp[j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args){
        int[] p = {1,4,1,1,1};
        System.out.println(cutRod(p, 5));
    }
}