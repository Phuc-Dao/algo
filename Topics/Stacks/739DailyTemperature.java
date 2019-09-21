/* 
 * Say we are trying to find T[0]. If we remembered T[10] = 50, knowing T[20] = 50 
 * wouldn't help us, as any T[i] that has its next warmer ocurrence at T[20] would have it  
 * at T[10] instead. However, T[20] = 100 would help us, since if T[0] were 80, then T[20]
 * might be its next warmest occurrence, while T[10] couldn't. 
 * Pattern: Notice how numbers less than 
 * T[i] are obscured because T[i] would be the closest increasing temp.
 * With this patter we can maintain a stack
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            // While loop used to maintain our invariant
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}