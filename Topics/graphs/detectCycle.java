class detectCycle{
     private static boolean isCycle(List<Integer> adj[], boolean[] visited, boolean[] currentStack, int start){
        visited[start] = true;
        currentStack[start] = true;
        Iterator<Integer> it = adj[start].iterator();
        while(it.hasNext()){
            int temp = it.next();
            if(!visited[temp] && isCycle(adj, visited, currentStack, temp)){
                return true;
            }else if(currentStack[temp]){
                return true;
            }
        }
        currentStack[start] = false;
        return false;
    }
}