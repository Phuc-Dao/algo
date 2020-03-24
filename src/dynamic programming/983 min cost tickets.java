/*
 * Define f(i) to be the minimum cost of tickets to travel on day i.
 * Case analysis:
 * Case 1:If day i is not a travel day then we do nothing and recurse on i - 1. This is because if it is not a travel day we wait so we do nothing.
 * Case 2: We buy ticket 1. This coveres our travels for today. So we recurse on i - 1
 * Case 3: We buy ticket 2. so this covers all our travels for the previous 7 days, so we recurse on i - 7
 * Case 4: We buy ticket 3. This covers all our travels for the previous 30 days so we recurse on i - 30
 * Base case: we don/t travel on day 0 so return 0. 
 * We take the max of case 2, 3, and 4
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        Integer[] memo = new Integer[366];
        for(int i = 0; i < days.length; i++){
            set.add(days[i]);
        }
        return mincost(set, days[days.length - 1], costs, memo);
    }
    
    public int mincost(HashSet<Integer> days, int day, int[] costs, Integer[] memo){
        if(day <= 0) return 0;
        if(memo[day] != null) return memo[day];
        // Case 1
        if(!days.contains(day)) return mincost(days, day - 1, costs, memo);
        // Reccurance relation
        int first = costs[0] + mincost(days, day - 1, costs, memo);
        int second = costs[1] + mincost(days, day - 7, costs, memo);
        int third = costs[2] + mincost(days, day - 30, costs, memo);
        return memo[day] = Math.min(Math.min(first, second), third);
    }
    
}
// Iterative solution
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