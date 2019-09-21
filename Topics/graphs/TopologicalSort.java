import java.util.*;
class Solution{
    // Cracking the coding interview dependency
    public List<String> build(String[][] dependency, String[] projects){
        Stack<String> build = new Stack<>();
        HashMap<String, List<String>> graph = buildGraph(dependency);
        HashSet<String> visited = new HashSet<>();
        System.out.println("The graph is " + graph);
        
        for(String p : projects){
            topoSort(p, graph, visited, build);
        }
        
        //Print out the stack
        while(!build.isEmpty()){
            System.out.println(build.pop());
        }
        return build;
    }

    private void topoSort(String current, HashMap<String, List<String>> graph, HashSet<String> visited, Stack<String> result){
        if(!visited.contains(current)){
            visited.add(current);
            List<String> neighbors = graph.get(current);
            for(String n : neighbors ){
                topoSort(n, graph, visited, result);
            }
            result.push(current);
        }
    }

    //Helper function to build the adjacency list
    private HashMap<String, List<String>> buildGraph(String[][] dependency){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String[] dep : dependency){
            map.putIfAbsent(dep[0], new ArrayList<>());
            map.putIfAbsent(dep[1], new ArrayList<>());
            map.get(dep[0]).add(dep[1]); //Add the values to the map
        }
        return map;
    }

    public static void main(String[] args){
        String[][] dep = {{"a" , "b"}, {"a" , "c"}};
        String[] build = {"a", "b", "c"};
        Solution sol = new Solution();
        sol.build(dep, build);
    }
}