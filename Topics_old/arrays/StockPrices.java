import java.util.*;
class StockPrices{

    public static List<Integer> max( List<Integer> list){
       
        if(list.size() <= 1){
            return list;
        }
        List<Integer> noDupes = new ArrayList<>();
        int last = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) != last){
                noDupes.add(list.get(i));
            }
            last = list.get(i); //This is going to get the last 
        }
        return noDupes;
    }

    public static void main(String[] args){
        
    }
    
}
