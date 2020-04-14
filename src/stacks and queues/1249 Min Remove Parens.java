//Approch, keep the index of the parentheses that we are to remove
// Keep a hashset of values we are trying to remove
class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> toRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else if(c == ')' && !stack.isEmpty()){
                stack.pop();
            }
            else if(c == ')'){
                toRemove.add(i);
            }
        }
        
        
        //Remove everything from the stack
        while(!stack.isEmpty()){
            toRemove.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!toRemove.contains(i)) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}