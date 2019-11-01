import java.util.*;
class LongestSSLengthK{

    static List<String> longest(String s, int k){
        List<String> res = new ArrayList<>();
        HashSet<String> unique = new HashSet<>();
        int[] frequency = new int[26];
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            frequency[curr - 'a']++;
            while(frequency[curr - 'a'] == 2){
                char leftLetter = s.charAt(left);
                frequency[leftLetter - 'a']--;
                left++;
            }
            if(i - left + 1 == k){
                String ss = s.substring(left, i + 1);
                if(!unique.contains(ss)){
                    res.add(ss);
                    unique.add(ss);
                }
                frequency[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return res;
    }
    public static void main (String[] args){
        System.out.println(longest("awaglknagawunagwkwagl", 4));
    }
}
["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]