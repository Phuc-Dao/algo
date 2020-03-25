//Find all elements in t and then trim left substring to smallest possible
class Solution {
    // Using two pointers 
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        int left = 0, right = 0, count = 0, minLength = Integer.MAX_VALUE;
        int[] map = new int[256];
        String ss = "";
        for(char c : t.toCharArray()){
            map[c]++;
        }
        
        while(right < s.length()){
            // If a character is > 0 then it is in t, so we inccrement count
            if(map[s.charAt(right)] > 0){
                count++;
            }
            map[s.charAt(right)]--;
            right++;
            // when we count all t elements, then 
            // trim down the window from the left side to find the first
            // element that was in map
            while(count == t.length()){
                // If non-negative number then it was one of the elements in t
                if(map[s.charAt(left)] >= 0){
                    count--;
                }
                map[s.charAt(left)]++;
                int currLength = right-left;
                // Check against the new substring
                if(currLength < minLength){
                    minLength = currLength;
                    ss = s.substring(left, right);
                }
                left++;
            }
        }
        return ss;
    }
}