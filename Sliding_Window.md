# Sliding window
Sliding window is a technique used to turn O(n^2) solutions to O(n). This technique is used on String and Array problems where the problem asks you to find a "substring" or "subarray" that meets some kind of criteria

## Sliding window to find substrings
Sliding window can be used to solve many substring problems. Anytime you have to find a substring that meets some kind of criteria chances are you can use the sliding-window technique to sovle it. Here is a basic template to solve string problems using sliding window

```
1   procedure(String S):
2       leftBound = 0
3       for character in S:
4           process character
5           while constraint not satisfied:
6               increment leftBound
7               check if constraint satisied
8           process substring
```

An example of applying the template algorithm to finding the longest substring without repeating characters

```java
public int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() == 0) return 0;
    int[] map = new int[256];
    int longest = 0;
    int left = 0;
    for(int i = 0; i < s.length(); i++){
        // Process character
        map[s.charAt(i)]++;
            
        // while constraints not met
        while(map[s.charAt(i)] > 1){
            map[s.charAt(left)]--;
            left++;
        }
        // Process substring
        longest = Math.max(longest, i - left + 1);
    }
    return longest;
}
```

Good Problems to do
1. Longest substring with unique characters
2. Minimum window substring
3. Fruits in a basket