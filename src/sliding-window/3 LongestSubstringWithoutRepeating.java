class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] map = new int[256];
        int longest = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            // Process character
            map[s.charAt(i)]++;
            
            // while constraints not met
            while(map[s.charAt(i)] > 1){
                map[s.charAt(left)]--;
                left++;
            }
            longest = Math.max(longest, i - left + 1);
        }
        return longest;
    }
}