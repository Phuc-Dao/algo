class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String curr = tokens[i];
            int first;
            int second;
            switch (curr){
                case "+":
                    first = s.pop();
                    second = s.pop();
                    s.push(second + first);
                    break;
                case "-":
                    first = s.pop();
                    second = s.pop();
                    s.push(second - first);
                    break;
                case "*":
                    first = s.pop();
                    second = s.pop();
                    s.push(second * first);
                    break;
                case "/":
                    first = s.pop();
                    second = s.pop();
                    s.push(second / first);
                    break;
                default:
                    s.push(Integer.parseInt(curr));
            }               
        }
        return s.pop();
    }
}