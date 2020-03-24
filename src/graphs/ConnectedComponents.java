import java.util.*;
class ConnectedComponents{

    //Get the connected compopnents by doing dfs on each of the nodes
    //If we find a node that we have seen already the n
    public static int numConnected(int n, int[][] connection){
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < n; i++){
            g.put(i, new ArrayList<>());
        }

        //Iterates over the connections and adds them to the map
        for(int j = 0; j < connection.length; j++){
            g.get(connection[j][0]).add(connection[j][1]);
        }

        //Used to represent our queue
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        
        int numConnected = 0;
        //Perform dfs and count the connected components
        for(int i = 0; i < n; i++){
            if(!set.contains(i)){
            q.add(i);
            //While the queue is not empty
            while(q.peek() != null){
            int curr = q.poll();
            if(!set.contains(curr)){
                set.add(curr);
                for(int child : g.get(curr)){
                    q.add(child);
                }
            }
            }
            numConnected++;
        }  
        }
        return numConnected;
    }
    public static void main(String[] args){
       
        int[][] connection = {{0,1},{1,0},{1,2}, {3,4}, {4,3}};
        System.out.println(numConnected(5, connection));    
        boolean[] b = new boolean[2];
        System.out.println(b[0]);
        
    }
}