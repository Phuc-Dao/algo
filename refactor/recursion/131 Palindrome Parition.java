// Backtracking solution
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, s, new ArrayList<String>(), res);
        return res;
    }
    
    private void backtrack(int start, String s, List<String> currList, List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(currList));
            return;
        }
        else{
            // For loop constructs the first layeer
            // For input aab the first level of dfs will construct {a} and {a,a}
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    // Do something here
                    currList.add(s.substring(start, i + 1));
                    backtrack(i + 1, s, currList, res);
                    currList.remove(currList.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

// Wrong Approach: The wrong approach is to think about depth first. The for loop should construct all possible first elements
// public List<List<String>> partition(String s) {
//     List<List<String>> res = new ArrayList<>();
//     if(s == null || s.length() == 0) return res;
//     List<String> currentList = new ArrayList<>();
//     currentList.add(Character.toString(s.charAt(0)));
//     backtrack(1, currentList, s, res);
//     return res;
// }

// private void backtrack(int currentIndex, List<String> currentList, String s,List<List<String>> res){
//     if(currentIndex == s.length()){
//         res.add(new ArrayList<>(currentList));
//         return;
//     }
//     if(!isPalindrome(currentList.get(currentList.size() - 1))) return;
//     for(int i = currentIndex; i < s.length(); i++){
//         //1. Add letter at current index to the last list element
//         //2.Recurse
//         //2. Remove last character from last list element
//         //3. Create new list element with the new character
//         char currentLetter = s.charAt(i);
//         int lastIndex = currentList.size() - 1;
//         String lastString = currentList.get(lastIndex);
//         StringBuilder sb = new StringBuilder(currentList.get(lastIndex)).append(currentLetter);
//         currentList.set(lastIndex, sb.toString());
//         backtrack(currentIndex + 1, currentList, s, res);
//         currentList.set(lastIndex, lastString);
//         currentList.add(Character.toString(currentLetter));
//     }    
// }