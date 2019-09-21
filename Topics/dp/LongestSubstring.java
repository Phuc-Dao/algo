import java.util.*;
/**
 * Leetcode 3. Longest substring without repeating characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Explanation: 
 */
class LongestSubstring{
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] arr = new int[128];
	HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, i = 0, j = 0;
        while (j < n) {
            // try to extend the range [i, j]
            if (arr[s.charAt(j)] == 0){
                arr[s.charAt(j)] = 1;
                j++;
                ans = Math.max(ans, j - i);
            }
            else {
                arr[s.charAt(i)] = 0;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
	System.out.println(lengthOfLongestSubstring(""));
    }

}
