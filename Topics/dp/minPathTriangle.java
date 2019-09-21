import java.util.*;

/*
 * Leetcode problem and epi
 * Approach start from the bottom up starting at the second to last level
 * The value of the array is going to be the minimum of its two children
 * return the top level
 */
class minPathTriangle{
    public static int minPath(List<List<Integer>> triangle){
        //Starting from the n - 1 row and working bottom up
        for(int i = triangle.size() - 2; i >= 0; i--){
            List<Integer> currList = triangle.get(i);
            List<Integer> prevList = triangle.get(i+1);
            
            //Iterate through every element on the current level and find the min path
            for(int j = 0; j < currList.size(); j++){
                //Add the current item to the minimum between the children
                int itemToSet = currList.get(j) + Math.min(prevList.get(j), prevList.get(j+1));
                currList.set(j, itemToSet);
            }
        }
        return triangle.get(0).get(0);
    }
    

    public static void main(String[] args){
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(4,4));
        list.add(Arrays.asList(8,5,6));
        list.add(Arrays.asList(4,2,6,2));
        list.add(Arrays.asList(1,5,2,3,4));
        
        System.out.println(minPath(list));
        

        

    }
}