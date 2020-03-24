class PickUpCoins{
    //Recurrance relation: F(a,b) = Max( c, d)
    //c = coins[c] + min(f(a+2,b), f(a-1,b-1))
    //d = coins[d] + min(f(a. b-2), f(a-1,b-))1
    
    public static PickupCoins(int[] coins){
        
    }
    public static int helper(int[] coins, int left, int right, int firstPlayerScore, int secondPLayerScore){
        if(left > right){
            return 0;
        }
        if(right - left == 1){
            return Math.max(coins[left, coins[right]]);
        }
        else{
            //Player 1 picks the left and player two picks left
            int leftleft = coins[left] + helper(coins, left + 2, right);
            int leftright = coins[left] + helper(coins, left + 1, right - 1);
            int rightright = coins[right] + helper(coins, left, right - 2);
            int rightleft = coins[right] + helper(coins, left + 1, right -1);
            int leftMax = Math.max(leftleft, leftright);
            int rightMax = Math.max(rightleft, rightright);
            return Math.max(leftMax, rightMax);
        }
    }
}