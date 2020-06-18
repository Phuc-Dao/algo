import java.awt.List;

class ks{
    public static int knapsack(int maxWeight, int[] weightList, int[] valList){
        int[][] dp = new int[weightList.length + 1][maxWeight + 1];
        for(int i = 0; i < valList.length + 1; i++){
            for(int j = 0; j < maxWeight + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if(weightList[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(valList[i-1] + dp[i - 1][j - weightList[i-1]], dp[i-1][j]);
                }
            }
        }
        return dp[weightList.length][maxWeight];
    }

    public static void main(String[] args){
        int[] list1 = {1,5,6};
        int[] list2 = {3,1,4};  
        System.out.println(knapsack(5, list2, list1));
    }
}