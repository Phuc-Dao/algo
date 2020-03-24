// The general approach is the same as the longest increasing subsequence. 
// Instead of an array we will use a hashmap to optomize the loockup
class Solution {
    public int longestStrChain(String[] words) {
        if(words.length == 0) return 0;
        // Sort because it will make it easier
        Arrays.sort(words, (String a, String b) -> {
            return a.length() - b.length();
        });
        int GlobalMax = 1;
        // This is the equivalence of our basecase
        int minLen = words[0].length(); // The minimum value
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            // basecase
            if(words[i].length() == minLen){
                map.put(words[i], 1);
            }
            else{
                //Remove a single character and check if it exists in the hashmap
                String curr = words[i];
                int max = 0;
                for(int j = 0; j < curr.length(); j++){
                    String ss = removeCharacter(curr, j);  
                    if(map.containsKey(ss)){
                        max = Math.max(max, map.get(ss));
                    }
                }
                map.put(curr, max + 1);
                GlobalMax = Math.max(GlobalMax, max + 1);
            }
        }
        return GlobalMax;
    }
    
    // Used to remove each character one by one from the string
    private String removeCharacter(String s, int i){
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, i));
        for(int j = i + 1; j < s.length(); j++){
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}