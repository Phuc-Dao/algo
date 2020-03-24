import java.util.*;

class deadlock {
    public static boolean canFinish(int numCourses, int[][] prerequisites){
        //Generate a map of the relationship
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }
        for(int[] pairs : prerequisites){
            map.get(pairs[1]).add(pairs[0]);
        }

        //Keeps track of all the nodes that we are currently visiting
        Set<Integer> visiting = new HashSet<>();
        //Keepts track of all nodes that we have completely explored
        Set<Integer> finished = new HashSet<>();
        //Stack to perform our dfs
        Stack<Integer> stack = new Stack<>(); 

        //For loops that iterates over every node in the graph
        for( int i = 0; i < numCourses; i++){
            stack.push(i);
            //pop from the stack
            while(!stack.empty()){
                //Gets the current node and get its children from the graph
                int currentNode = stack.pop();
                if(!finished.contains(currentNode)){
                    finished.add(currentNode);
                    visiting.add(currentNode);
                    for(int neighbor : map.get(currentNode)){
                        if(visiting.contains(neighbor)){
                            return false;
                        }
                        else{
                            stack.push(neighbor);
                        }
                    }
                }
            }
            visiting.clear();
        }

        return true;
    }

     public static void main(String[] args){
        int[][] sampleInput = {{1,0}};
        System.out.println(canFinish(2, sampleInput));
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
          //Generate a map of the relationship
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }
        for(int[] pairs : prerequisites){
            map.get(pairs[1]).add(pairs[0]);
        }

        //Keeps track of all the nodes that we are currently visiting
        Set<Integer> visiting = new HashSet<>();
        //Keepts track of all nodes that we have completely explored
        Set<Integer> finished = new HashSet<>();
        //Stack to perform our dfs
        Stack<Integer> stack = new Stack<>(); 

        //For loops that iterates over every node in the graph
        for( int i = 0; i < numCourses; i++){
            stack.push(i);
            //pop from the stack
            while(!stack.empty()){
                //Gets the current node and get its children from the graph
                int currentNode = stack.pop();
                if(!finished.contains(currentNode)){
                    visiting.add(currentNode);
                    int numAdded = 0;
                    for(int neighbor : map.get(currentNode)){
                        if(visiting.contains(neighbor)){
                            return false;
                        }
                        else if(!finished.contains(neighbor)){
                            stack.push(neighbor);
                            visiting.add(neighbor);
                            numAdded++;
                        }
                    }
                    //If no neighbors were added then we no nodes were reachable so we move to blackset
                    if(numAdded == 0){
                        visiting.remove(currentNode);
                        finished.add(currentNode);
                    }
                }
            }
        }

        return true;   
    }
}