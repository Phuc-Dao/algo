//Approach: Have a window of size two and add each pair
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy.next;
        ListNode prev = dummy;
        while(curr != null && curr.next != null){
            ListNode temp = curr.next.next;
            prev.next = curr.next;
            prev.next.next = curr;
            curr.next = temp;
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}