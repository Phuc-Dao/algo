public class Solution {
    //Using the template from https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
    // The idea is to look at all substrings of length p and decrement the left window 
    // if the substring of length p doesnt contain all the characters
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256]; //character hash
    //record each character in p to hash
    for (char c : p.toCharArray()) {
        hash[c]++;
    }
    //two points, initialize count to p's length
    int left = 0, right = 0, count = p.length();   
    while (right < s.length()) {
        //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
        if (hash[s.charAt(right)] >= 1) {
            count--;
        }
        hash[s.charAt(right)]--;
        right++;
        //when the count is down to 0, means we found the right anagram
        //then add window's left to result list
        if (count == 0) {
            list.add(left);
        }
        // If we are at p.length then 
        // make left window smaller
        if (right - left == p.length() ) {
            if (hash[s.charAt(left)] >= 0) {
                count++;
            }
            hash[s.charAt(left)]++;
            left++;
        
        }    
    }
        return list;
    }
}