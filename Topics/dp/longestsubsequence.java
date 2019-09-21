//Solution on geeks for geeks
//Todo
class longestsubsequence{

public static int lss(String s1, String s2){
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    for(int i =0; i <= s2.length(); i++){
        for(int j = 0; j <= s1.length(); j++){
            //Base case is if either of their lengths are zero
            if(i ==0 || j == 0){
                dp[i][j] = 0;
            }
            else if(s1.charAt(i -1) != s2.charAt(j-1)){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
            else{
                dp[i][j] = dp[i-1][j-1];
            }
        }
    }
    return dp[s1.length() + 1][s2.length() + 1];
    }
    public static void main(String[] args){
        System.out.println(lss("cat", "tac"));
    }
}