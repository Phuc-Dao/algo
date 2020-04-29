/*Approach: A Graph is a tree if it meets the following requirments
 * 1. There are no cycles
 * 2. All Nodes are reachable
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map =  generateGraph(n, edges);
        HashSet<Integer> visited = new HashSet<>();
        
        // Use dfs to check if there are any cycles starting from node 0
        if(detectCycles(map, visited, -1, 0)) return false;;
        
        //Check if every node has been visited
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)) return false;
        }
        
        return true;
    }
    
    // Using dfs for cycle detection
    boolean detectCycles(HashMap<Integer, List<Integer>> map, HashSet<Integer> visited, int parent, int curr ){
        // Check if the node has already been visited. 
        if(visited.contains(curr)) return true;
        // Mark current node as visited
        visited.add(curr);
        List<Integer> neighbor = map.get(curr);
        for(Integer n : neighbor){
            if(n != parent){
                if(detectCycles(map, visited, curr, n)) return true;
            }
        }
        return false;
    }
    
    // Helper function that creates the adjacency list
    private HashMap<Integer, List<Integer>> generateGraph(int n, int[][] edges){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }
}