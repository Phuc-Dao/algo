import java.util.*;
class StringPermutation{
    public static void helper(String set, String result){
        if(set.length() == 0){
            //do something
            System.out.println(result);
        }
        else{
            for(int i =0; i < set.length(); i++){
                StringBuilder sb = new StringBuilder(set);
                char c = set.charAt(i);
                sb.deleteCharAt(i); 
                helper(sb.toString(), result + sb.toString());
                sb.insert(i, c);
            }
        }
    }
    public static void permuateString(String set){
        helper(set, "");
    }

    public static void main(String[] args){
        permuateString("cat");
    }
}