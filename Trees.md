# Binary Tree's

## Notes on Trees
* Understand Tree Serialization. Serialization can be used as a unique identifier or to reconstruct a tree to and array or vice versa
    - 103 construct binary tree from inorder and preorder traversal
    - Serialize and deserialize a binary tree
* Inorder traversal with bst is very powerful You can use inorder traversal with binary search tree's and check if it is sorted.
    - 99 recover binary search tree
    - Morris's traversal can do inorder traversal in constant space
    - bst iterator
* num unique bst
    - Consider n = 5, if we let the root node be 3, then the number of nodes on the left is 2 (1,2), and the number of nodes on the right side is 2 (4,5). So we multiply these two recursions. Do this for every possible configuration of the root nodes
    - G(n) = \sum_i=0^n G(i - 1) * G(n - i)
* Understand divide and conquer on tree's. Sometimes you need to solve the left subtree and right subtree and combine them together in the end.

### Other useful tips
* Be careful how you define your base case, sometimes you don't want to recurse all the way to the null children. Sometimes you want to stop at the leaf.
    - For example in finding the sum to every path from root to leaf, we keep a running sum and add it to the total global variable at the end.

```
// The correct way is to add it to the running sum when we are at a leaf
int runningSum = 0;
void totalPathSum(Node root, int currentSum){
    if(root == null) return;
    currentSum = currentSum + root.value;
    if(root is leaf){
        runningSum += currentSum;
        return;
    }
    totalPathSum(root.left, currentSum);
    totalPathSum(root.right, currentSum);
}

// This is incorrect because each leaf had two children, so it will add the total path twice
int runningSum = 0;
void totalPathSum(Node root, int currentSum){
    // Add the total sum when we are at a null node
    if(root == null){
        runningSum += currentSum;
    }
    currentSum = currentSum + root.value;
    totalPathSum(root.left, currentSum);
    totalPathSum(root.right, currentSum);
}

```



### The basics
* Use these sources to refresh on tree's and binary tree's
    - https://medium.com/basecs/leaf-it-up-to-binary-trees-11001aaf746d
    - https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/trees.html
* Traversal in a regular binary tree takes O(n) time where n is the number of nodes
* Search in a binary search tree takes O(logn) time
* Recursion takes O(logn) space or O(h) where h is the height of the tree. This is because in each recursion we process the left and right subttree at the same time

###  Comparing Trees
* If a problem involves comparing two tree's you can do a traversal on both of them at the same time. By passing in two root values.
    - 617 Merge Two Binary Trees
    - 100 same tree
    - Symetric Tree

### Global variable in recursion
* Sometimes we need to use a global variable when doing tree recursion to keep track of the max or total sum path. Important is to understand that global variables values stay the same throughout the recursion. Note objects are passed by reference so they are essentially global variables
    - 124 Max Path Sum 
    - Find the total path sum from root to leaf 

### Flattening a Tree
* Understand that when you flatten a tree into an array (using pre, post or inorder traversal) what the regions in the array represents. For example in inorder traversal, if the tree is

