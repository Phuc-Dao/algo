# Sliding window
Sliding window is a technique used to turn O(n^2) solutions to O(n). This technique is used on String and Array problems where the problem asks you to find a "substring" or "subarray" that meets some kind of criteria

## Sliding window to find substrings
Sliding window can be used to solve many substring problems. Anytime you have to find a substring that meets some kind of criteria chances are you can use the sliding-window technique to sovle it

```
1   procedure(String S):
2       leftBound = 0
3       for character in S:
4           process character
5           while constraint not satisfied:
6               increment leftBound
7               check if constraint satisied
```