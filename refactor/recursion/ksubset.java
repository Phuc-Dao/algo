import java.util.*;
//Start at n = 0 and at each level we choose to either use the nth element or we choose
//to not use it. If we choose to then we append, if we dont choose then we pass in the original array
 
class ksubset{
    public static void helper(int n, int end, int k, List<Integer> list, List<List<Integer>> res){
        if(n == end) {
            return;
        }
        if(list.size() == k){
            System.out.println(list);
            res.add(new ArrayList<>(list));
            return;
        }
        else{
            list.add(n);
            //Use the nth element
            helper(n + 1, end, k, list, res);
            list.remove(list.size() - 1);
            //Dont use the nth element
            helper(n + 1, end, k, list, res);
        }
    }

    public static List<List<Integer>> solution(int n, int k){
        List<Integer> solution = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(0, 5, 3, solution, res );
        return res;
    }

    public static void main(String[] args){
        System.out.println(solution(5, 3));
    }
}