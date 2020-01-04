# Dynamic Programming

## Dynamic Programming and Strings
* Edit distance
* Wildcard matching

## Dependent states
In problems where the states are dependent on each other we can use multiple dp arrays to hold the values for each state.
* 714 Best time to buy and sell stocks with transaction fee
* 151 Max product subarray

### 309 Buy and sell stocks with Transaction fee
```
You are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee. Return the maximum profit that you can make.
```

There are two dependent states, sell(i) which is your profit after selling on day i and buy(i) which is your profit after buying on day i. 

#### Recurrance
For day i, we have two situations for each of the states:

* sell state
    - We can sell the stock on day i, then it is going to be the price of our last buy + the price on day i, minus the selling fee
    - We don't sell then it remains the same as the previous sell day
    - We take the max of both of these possibilities
```
sell(i) = max(sell(i - 1), buy(i - 1) + price(i) - fee)
```
* Buy state
    - We can buy the stock on day i, then it is going to be the price of our last sell minus the current day price
    - We do nothing, then sell(i) = sell(i - 1)
    - We take the max of both of these possbilities
```
buy(i) = max(buy(i - 1) , sell(i - 1) - price(i))
```

Note: In the final code we can reduce the space complexity to O(1) because we only rely on the previous state. For the purpose of this example we use an array so the space is O(n). See code file for more efficient version

```java
 public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        // Basecase if we buy on the first day then we have negative money
        buy[0] = -prices[0];
        // We can't sell on the first day so it is zero
        sell[0] = 0;
        for(int i = 1; i < prices.length; i++){
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[sell.length - 1];
    }
```
### 309 Best time to buy and sell stocks with Cooldown

#### Case analysis
On some day i we have 3 possible actions that we can take `Buy`,` Rest` and `Sell`. 
* If we bought the stock on day i, then the profit we have is if we don't buy, or how much we had on the previous rest day + price[i]
    - `buy(i) = max(buy(i - 1) , rest(i - 1) + price[i]) `
* If day i is a sell day, then we have two options, either don't sell, or the profit we had on the previous buy day + price[i] 
    - `sell(i) = max(sell(i - 1), buy(i-1) + price[i]) `
* If day i is a rest day, then we either got here after a buy, sell, or rest day
    - `rest(i) = max(sell(i - 1), buy(i-1), rest(i - 1)) `

#### Code
```java
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
```
