/*
 * iterate backwards and append then do a reverse
 * StringBuilder offers constant time insert at the end
 * so insert takes O(n) and it takes linear time to reverse so
 * O(2n) 
 */
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder("");
        int j = 0;
        for(int i = S.length() - 1; i >= 0; i--){
            if(S.charAt(i) != '-'){
                if(j == K){
                    sb.append('-');
                    j = 0;
                }   
                sb.append( S.charAt(i));
                j++;
                
            }
        }
        return sb.reverse().toString().toUpperCase();
}