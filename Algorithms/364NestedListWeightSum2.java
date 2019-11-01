
class Solution {
    int total = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int max = getMaxDepth(nestedList);
        
        for(NestedInteger n : nestedList){
            getWeightSum(n, max);
        }
        return total;
    }
    
    private void getWeightSum(NestedInteger n, int depth){
        if(n.isInteger()) total = total + (n.getInteger()*depth);
        for(NestedInteger i : n.getList()){
            getWeightSum(i, depth - 1);
        }
    }    
        
    private int getMaxDepth(List<NestedInteger> item){
        int max = 0;
        for(NestedInteger n : item){
            max = Math.max(max, helper(n));
        }
        return 1 + max;
    }
    
    private int helper(NestedInteger n ){
        if(n.isInteger()) return 0;
        int max = 0;
        for(NestedInteger items : n.getList()){
            max = Math.max(max, helper(items));
        }
        return 1 + max;
    }
}