import java.util.*;
// This is an implementation of Fleurys algorithm
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ret = new LinkedList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        Stack<String> stack = new Stack<String>();
        
        // Construct the adjacency list
        for(List<String> t : tickets){
            String from = t.get(0);
            String to = t.get(1);
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }

        stack.push("JFK");
        while(!stack.empty()){
            String next = stack.peek();
            PriorityQueue<String> neighbors = map.get(next);
            System.out.println("Peeking at " + next + " the neighbors are " + neighbors);
            if(map.containsKey(next) && neighbors.size() > 0) {
                String toPoll = neighbors.poll();
                System.out.println("map contains " + next + " and size is greater than zero, pushing: " + toPoll);
                stack.push(toPoll);
            }
            else {
                System.out.println("adding " + next + "To the result");
                ret.addFirst(stack.pop());
            }
            System.out.println("The current stack is " + stack);
            System.out.println("The current result is " + ret);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }     
        return ret;
    }
}

    public static void main(String[] args){
        Solution sol = new Solution();
        String[][] iter = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        System.out.println(sol.findItinerary(iter));
        System.out.println("res");
    }
}