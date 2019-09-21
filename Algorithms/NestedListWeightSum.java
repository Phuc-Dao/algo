class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxD = maxDepth(nestedList);
        return getWeight(nestedList, maxD);
        
    }   
    
    // Get the max depth using dfs
    private int maxDepth(List<NestedInteger> list){
        int max = 0;
        for(NestedInteger l : list){
            // If the list is not an integer than we traverse
            if(!l.isInteger()){
                int depth = maxDepth(l.getList());
                max = Math.max(max, depth);
            }
        }
        return 1 + max;
    } 
    
    private int getWeight(List<NestedInteger> list, int maxDepth){
        int total = 0;
        for(NestedInteger l : list){
            if(l.isInteger()){
                total = total + maxDepth*l.getInteger();
            }
            else{
               total = total + getWeight(l.getList(), maxDepth - 1); 
            }
        }
        return total;
    }  
}