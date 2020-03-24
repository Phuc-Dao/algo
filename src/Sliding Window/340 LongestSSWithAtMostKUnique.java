class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int count = k, left = 0, longest = 0;
        int[] map = new int[256];
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(map[curr] == 0) count--;
            map[curr]++;
            while(count < 0){
                if(map[s.charAt(left)] == 1){
                    count++;
                }
                map[s.charAt(left)]--;
                left++;
            }
            longest = Math.max( longest, i - left + 1);
        }
        return longest;
    }
}