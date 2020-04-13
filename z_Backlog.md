1. Insert delete get random
# Word Ladder ii
* I thought that I should create the graph first and then do bfs, but you can use a get neighbor function as you go and not have to construct a graph initallu
* Initally to get the next neighbor of a word, I would take that word anc compare it to every other word and then compare each individual character to
see if it was off by one character
    - To optimize for this we can add every word to a set initally, and then change each character with every word in the alphabet and see if 
        that word exists
    - This is O(k*26)

* Construct a parent graph so we can use backtracking to find every path from the end back to the inital node
* Only create a link if a node is on the next level, 
* Do bakcktracking to generate each path

2. Reorganize string
* This problem is very similar to task schedular
* This problem is also similar to rearange strings k distance apart
* Initally thought it was backtracking,
* Go through every possible permutation and when we reach the end, then we are done
    -   This will work but we are doing an unecissary work
* Notice how in a valid solution that the letters with the highest count always come first, followed by second highest count, follow by third.
* Here we can use greedy

3. Decode string
* Got appraoch both recursively and with a stack but to lazy to implement

4. Maximum width of binary tree
* Naive approach is to do level order traversal and add null nodes as well
* This cause tle
* Use that fact that it is a full binary tree. Index of left child is 2*(parent) and right child is 2*(parent) + 1
* So now we just have to store the offset of the parent somewhere (hashmap)

5. Queue reconstruction by height
- Did not realize it was greey. The trick is to guess greedy. When you do greedy there is some kind of an invariant of using the tallest or shortest that holds
that helps you solve the problem 