class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(numRows == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        
        for(int i = 1; i < numRows; i++){
            List<Integer> prev = res.get(res.size() - 1);
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for(int j = 1; j < i; j++){
                newList.add(prev.get(j-1) + prev.get(j));
            }
            newList.add(1);
            res.add(newList);
        }
        return res;
    }
}