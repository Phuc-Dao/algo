import java.util.*;
/*
 * 6.2 Increment a single precision number
 */


class incrementNumber{

    public static List<Integer> convert(List<Integer> list){
        int end = list.size() - 1;
        while(end != -1){
            if(list.get(end) != 9){
                break;
            }
            else{
                end--;
            }
        }
                
        list.set(end, list.get(end) + 1); //Increment the list element by one

        if(end == 0 ){
            list.insert(0, 1);
        }        
        
        //Loop through the lest of the list and change the 9's to zero
        for(int i = end + 1; i < list.size(); i++){
            list.set(i, 0);
        }
        
        //Return the list
        return list;
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(9);
        list.add(9);
        System.out.println(convert(list));

    }

}
