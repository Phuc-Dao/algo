
class Solution {
    // Approach: Notice that all we have to do is detect a cycle in the graph
    // Use an extra set to maintain the nodes that we are still currently exploring
    // Look at geeks for geeks on cycle detection
    // runtime O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        // External set that we use to keeptrack of node we are still visiting
        HashSet<Integer> rec = new HashSet<>();
        
        // Init the initial map
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);   
        }
        // Checks for cycles on each of the number of courses
        for(int i = 0; i < numCourses; i++){
            if(detectCycle(i, graph, visited, rec)){
                return false;
            }
        }
        return true;
    }
    
    private boolean detectCycle(int i, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited, HashSet<Integer> rec){
        rec.add(i);
        visited.add(i);
        for(Integer n : graph.get(i)){
            if(rec.contains(n)){
                return true;
            }
            // Dfs only process nodes that have not been visisted
            if(!visited.contains(n)){
                // Recursively call the function
                if(detectCycle(n, graph, visited, rec)){
                    return true;
                }   
            }
        }
        // We are done exploring so we can remove the edge from the currently exploring
        rec.remove(i);
        // We return false here becasuse we have explored all the edges and found no cycle
        return false;
    }    
}