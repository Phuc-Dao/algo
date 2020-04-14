// Approach: Iterate through every asteroid, if we encounter a positve then a negative, then delete every number
// before the negative node that is positive and has a less absolute value
// Pattern: When we find a negative number, we iterate backwards and operate on every positve number we see. Since we 
// are operating on the immediate number before it, we can use a stack data structure.
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 0) return new int[]{};
        Stack<Integer> s = new Stack<>();
        s.add(asteroids[0]);
        for(int i = 1; i < asteroids.length; i++){
            int curr = asteroids[i];
            if(!s.isEmpty() && s.peek() >= 0 && curr < 0){
                while(!s.isEmpty() && s.peek() >= 0 &&  Math.abs(s.peek()) < Math.abs(curr)){
                    s.pop();
                }
                // If we reach the end or if we reach a negative number, then we can add the astero0id
                if(s.isEmpty() || s.peek() < 0){
                    s.add(curr);
                }
                // If the value is positive and equal to the current then we destroy both of them
                else if( s.peek() >= 0 && Math.abs(s.peek()) == Math.abs(curr)){
                    s.pop();
                }
            }
            else{
                s.add(curr);
            }
        }
        
        //Add the results to the stack
        int[] res = new int[s.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = s.pop();
        }
        return res;
    }
}