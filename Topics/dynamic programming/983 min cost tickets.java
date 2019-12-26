class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] isTravel = new boolean[366];
        for(int i = 0; i < days.length; i++){
            isTravel[days[i]] = true;
        }

        int[] dp = new int[days[days.length - 1] + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            if(isTravel[i]){
                int ticket1 = costs[0] + dp[i - 1];
                int ticket2 = i - 7 <= 0 ? costs[1] : costs[1] + dp[i - 7];
                int ticket3 = i - 30 <= 0 ? costs[2] : costs[2] + dp[i - 30];
                dp[i] = Math.min(Math.min(ticket1, ticket2), ticket3);
                
            }else {
                dp[i] = dp[i - 1];
            }
        }
        
        return dp[dp.length - 1];
    }
}