   //Leetcode: friends circle
   //Approach: Find the number of connected components from the adjacency matrix
   //bug: adding the value at the index rather than the index them selves
   class FriendsList{
   public static int findCircleNum(int[][] M) {
        int numGroups = 0;
        boolean[] visited = new boolean[M.length]; //This will be our set 
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < M.length; i++){
            //Check if it has been visisted before
            if(visited[i] == false){
                numGroups++;
                q.add(i);
                //Continue to pop when the queue is not empty
                while(q.peek() != null){
                    int currNode = q.poll();
                    if(visited[currNode] == false){
                        visited[currNode] = true;
                        int[] neighbors = M[currNode];
                        //Add the neighbors to the queue
                        for( int j = 0; j < neighbors.length; j++){
                            if(neighbors[j] == 1){
                                q.add(j);
                            }
                        }
                    }
                }
            }
        }
        return numGroups;
    }
   }   