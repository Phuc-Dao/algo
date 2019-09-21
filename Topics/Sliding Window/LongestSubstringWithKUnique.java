class LongestSubstringWithKUnique{
    
    // This method will find the longest substring with k unique characters
    static public String findsubstring(String s, int k){
        
        int low = 0;
        int high = 0;
        
        int[] map = new int[26];
        int count = k;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(map[curr - 'a'] == 0){
                count--;
            }
            map[curr - 'a']++;
            
            while(count < 0){
                map[s.charAt(left) - 'a']--;
                if(map[s.charAt(left) - 'a']  == 0){
                    count++;
                }
                left++;
            }

            // Check the maximums
            if(count == 0 && (i - left) > (high - low) ){
                low = left;
                high = i;
            }
        }
        return s.substring(low, high + 1);
    }
    public static void main(String[] args){
        System.out.println(findsubstring("aabbccc", 2));
    }
}