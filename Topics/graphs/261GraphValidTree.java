class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map =  generateGraph(n, edges);
        HashSet<Integer> visited = new HashSet<>();
        // Iterate through every edge and check if there is a cycloe
        if(detectCycles(map, visited, -1, 0)) return false;;
        
        //Check if every node has been visited
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)) return false;
        }
        
        return true;
    }
    
    // Using dfs for cycle detection
    boolean detectCycles(HashMap<Integer, List<Integer>> map, HashSet<Integer> visited, int parent, int curr ){
        if(visited.contains(curr)) return true; //Check if it has already been visited
        visited.add(curr); //Mark current node as visited
        List<Integer> neighbor = map.get(curr);
        for(Integer n : neighbor){
            // If the neighbor is not the parent and 
            //if((visited.contains(n) && n != parent) || (n != parent && detectCycles(map, visited, curr, n))) return true;
            if(n != parent){
                if(detectCycles(map, visited, curr, n)) return true;
            }
        }
        return false;
    }
    
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