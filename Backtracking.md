# Backtracking

## Generating strings using Backtracking
If a problems asks you to generate strings then chances are it might be a backtracking problem. In these problems we will use a `buffer` to keep track of the string we are currently working on. Then we will add to the buffer, recurse, and then remove.

### 22. Generate Parentheses

`Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.`

We know that a valid parenthesis will have the same number of left and right parens. We can only put down the same number of left parens as right parens. Right parens we can place down as much as we want. We will use curr as our `buffer`

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), n, n);
        return res;
    }

    // Curr is the buffer that we will use to save the current
    void backtrack(List<String> res, StringBuilder curr, int left, int right){
        if(left < 0 || right < 0 || right < left) return;
        if(left == 0 && right == 0) res.add(curr.toString());
        curr.append("(");
        backtrack(res, curr, left - 1, right);
        curr.deleteCharAt(curr.length() - 1);
        curr.append(")");
        backtrack(res, curr, left, right - 1);
        curr.deleteCharAt(curr.length() - 1);
    }
}
```