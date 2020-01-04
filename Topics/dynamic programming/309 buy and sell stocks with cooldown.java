// See Notes
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] rest = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;
        for(int i = 1; i < prices.length; i++){
            buy[i] = Math.max(buy[i-1], rest[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            rest[i] = Math.max(Math.max(rest[i - 1], sell[i - 1]), buy[i - 1]);
        }
        return sell[sell.length - 1];
    }
}