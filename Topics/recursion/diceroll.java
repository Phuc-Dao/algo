import java.util.*;
//at each step of the recursion tree, we append then we remove
//See notes for recursion tree
class diceroll{
    public static void diceHelper(int n, List<Integer> list){
        if (n == 0) {
            System.out.println(list);
        }
        else{
            //Iterate through the possible dice numbers
            for(int i = 1; i <= 6; i++){
                //we choose
                list.add(i);
                //we explore
                diceHelper(n - 1, list);
                //we unchoose
                list.remove(list.size() - 1);
            }
        }
    }
    
    public static void printDice(int n){
        List<Integer> list = new ArrayList<>();
        diceHelper(n, list);
    }

    public static void main(String[] args){
        printDice(2);
    }
}