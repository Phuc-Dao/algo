/*
 * Approach: Backtracking iterate through the possible permutations
 * Note: A common pitfall would be to not include a start variable. However, this will allow it to have duplicates. 
 * By including a start variable we are limiting the search space to the first possible occurance
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, new ArrayList<Integer>(), res, 0);
        return res;
    }
    
    void helper(int[] candidates, int target, ArrayList<Integer> currList, List<List<Integer>> res, int start){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(currList));
        }
        for(int i = start; i < candidates.length; i++){
            currList.add(candidates[i]);
            // Important by including this start variable we are limiting the search space to not have anything prior to i
            helper(candidates, target - candidates[i], currList, res, i);
            currList.remove(currList.size() - 1);
        }
    }
}