# This repo will be used to review for algorithms

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

# TODO
0. Arrays
    a. sliding window
    b. prefix sum
1. Linked Lists
    a. Reverse a Linked List
    b. sliding window 
    c. slow and fast pointer
2. Stacks/Queues
    a. Pattern: Stacks are used when you operate on a previous element immediately before the current element.
        i. 753 asteroid collision
        ii. Basic Calculator 2
3. Binary Trees
    a. Inorder traversal
    b. postorder traversal
    c. preorder traversal
    d. binary search trees
4. Heaps
5. Sorting
6. Binary search
7. Graphs
    a. bfs
    b. dfs
    c. reducing problem down to graph problem
8. Backtracking
    a. Tip: Think of the entire level at a time
        i. 131 Palindrome Partition
    a. 698 Partition to K Equal Sum Subsets
9. Dynamic programming
    a. we either include or exclude the nth element
        1. 0/1 knapsack
    b. If we knew the answer to all of the previous n- 1, then how do we sovle n?
        1. Longst increasing subsequence
        2. longest string chain
        3. 322 coin change
10. Greedy Algorithms
11. Divide and conquor
12. Design Problems
    a. LRU cache
13. Invariants (Tricky part is recognizing invariants)
13. String/character manipulations
14. Other leetcode problems that are good

#Java Syntax
1. How to give custom sorting function for sort and heaps using lambda and collections
2. Regular expressions (replace all instances of a letter)
3. Converting characters to numbers in java

#Others
These are good to have 
1. Kruskals/primms algorithm for minimum spanning tree
2. Trie data structure
3. How to implment quicksort, mergesort
4. Bit manipulation
5. Disjoin set (union find)
6. Djikstra/floyd warshall algorithm
