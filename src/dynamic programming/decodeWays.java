class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1]; // +1 for empty string
        dp[0] = 1; // empty string has 1 solution
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
          int lastDigit = s.charAt(i - 1) - '0';
          int prevDigit = s.charAt(i - 2) - '0';
          int sum = prevDigit * 10 + lastDigit;
    
          if (sum == 0 || lastDigit == 0 && prevDigit >= 3) { // two consecutive zeros or something like 30, 40
            return 0;
          } else if (lastDigit == 0) { // dp["123"] = dp["12320"]
            dp[i] = dp[i - 2];
          } else if (prevDigit != 0 && sum <= 26) { // dp["123"] = dp["1"] + dp["12"] 
            dp[i] = dp[i - 1] + dp[i - 2];
          } else { // dp["1234"] = dp["123"]
            dp[i] = dp[i - 1]; 
          }
        }  
        return dp[dp.length - 1];
    }
}