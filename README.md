# Sliding window
Sliding window is a technique used to turn O(n^2) solutions to O(n). This technique is used on String and Array problems where the problem asks you to find a "substring" or "subarray" that meets some kind of criteria

## Sliding window to find substrings and subarrays
Sliding window can be used to solve many substring problems. Anytime you have to find a substring or subarray that meets some kind of criteria chances are you can use the sliding-window technique to sovle it. Here is a basic template to solve string problems using sliding window. 

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

An example of applying the sliding window algorithm to finding the **longest substring without repeating characters**

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
Here is an  example of using sliding window to solve the subarray problem **Fruits in a Basket** which gets reduced down to "find the longest subarray with at most 2 unique elements

```java
public int totalFruit(int[] tree) {
    int j = 0;
    int count = 0;
    int maxCount = 0;
    HashMap<Integer, Integer> seen = new HashMap<>();
    for(int i = 0; i < tree.length; i++){
        if(!seen.containsKey(tree[i])){
            seen.put(tree[i], 0);
            count++;
        }
        seen.put(tree[i], seen.get(tree[i]) + 1);
        //Keep removing left elements
        while(count > 2){
            seen.put(tree[j], seen.get(tree[j]) - 1);
            if(seen.get(tree[j]) == 0){
                count--;
                seen.remove(tree[j]);
            }
            j++;
        }
        maxCount = Math.max(maxCount, i - j + 1);
    }
    return maxCount;
}
```
**Good Problems to do**
1. Longest substring with unique characters
2. Minimum window substring
3. Fruits in a basket

**Important: Sliding window works on problems that looks to minimize or maximize a contiguous list. It breaks down when you have to find possible sublist. For those types of problems consider using prefix**

# Graph

## Detecting Cycles in undirected graph
For every node Curr, if there is a neighbor node n that is not the parent of curr and already visited then we have a cycle. 
**Note:** We are passing a parent pointer in function call so we dont revisit the parent. We are also checking if it is already visited on line 2 for readability. If we wanted to gain minor performance gains consider adding the check within the for loop instead

```
1   hasCycle(Node curr, visted, Node parent):
2.      if curr already visited return True
3.      add curr to visited set
4.      for Neighbor n of curr :
5.         if n not parent and hasCycle(n, visited, curr):
6.              return True
7.      return False
```

## Detecting Cycles in directed graph
Detecting cycles in a directed graph is a little more involved than an undirected graph. To detect cycles perform standard dfs however, if we revisit a previous node already visited before we visit all of its childrens then there is a cycle

```java
// Rec is a set to remember which nodes we are currently visiting
// Visited is a set to remember which node we already visited
boolean hasCycle(int curr, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited, HashSet<Integer> rec){
        if(rec.contains(curr)) return true;
        visited.add(curr);
        rec.add(curr);
        List<Integer> neighbors = map.get(curr);
        for(int n : neighbors){
            if(hasCycle(n, map, visited, rec)) return true; 
        }
        // Remove the current node from rec because we alreay visited it
        rec.remove(curr);
        return false;
    }
```

## Shortest Path in unweighted graph
If the problem asks for finding the shortest path or minimum number of steps in a grid or in a graph then most likely it is looking for bfs. Implement dfs with a queue.

# Dynamic Programming
Dynamic Programming is a technique used to optimize redundant computation by caching the results(usually into an array or matrix).  
1. **Overlapping subproblems**
2. **Optimal substructure**

## Dynamic programming using Memoization 
Template for solving dynamic programming questions using memoization
```
1   procedure(n):
2       if Basecase then return
3       if n is already computed return cache[n]
4       result = call recursive function 
5       store result in cache
```

# Backtracking
Note 1: Usually Backtracling considers one index at a time 

## Using Dynamic programming to optimize backtracking
Some backtracking problems can be optimized using dynamic programming. This is when the backtracking problems revisits recurring branches. These problems can be easily solved using a top-down cache or a bottom-up dp (Typically harder). Note that not all backtracking problems can be solved with DP. For example N-queens problem has no recurring subproblems
1. **Regular expression matching**
2. **Wild card matching**
3. 
