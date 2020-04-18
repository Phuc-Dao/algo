// Have two pointers and add each number. The integers are already reversed.
// Keep track of remainders
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Sentinal Node so we know where to return from
        ListNode res = new ListNode(-1);
        // Current pointer to the end of the result list
        ListNode curr = res;
        int remainder = 0;
        ListNode firstPointer = l1;
        ListNode secondPointer = l2;
        while(firstPointer != null || secondPointer != null){
            int total = 0;
            // If the first pointer isnt null then add it to the total
            if(firstPointer != null){
                total = total + firstPointer.val;
                firstPointer = firstPointer.next;
            }
            //If the second pointer isnt null then add it to the total
            if(secondPointer != null){
                total = total + secondPointer.val;
                secondPointer = secondPointer.next;
            }
            int toAdd = (total + remainder) % 10;
            int newRemainder =  (total + remainder) / 10;
            curr.next = new ListNode(toAdd);
            // Increment the next pointer
            curr = curr.next;
            remainder = newRemainder;
        }
        //IF there are any remainders left then add it at the end
        if(remainder != 0){
            curr.next = new ListNode(remainder);
        }
        return res.next;
    }
}