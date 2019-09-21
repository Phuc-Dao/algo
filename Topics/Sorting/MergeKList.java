// Approach use min heap to keep the track of the least node, when you pop an element, add the next
// We have access to the next item in the list because it is a linked list
// First implementation I did something retarded trying to search for the element, when I have access to the
// next item, just add it
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);
        // Dummy node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // intially add the head at each index
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            current.next = queue.poll();
            current = current.next;
            
            // Add the next item of the element just popped
            if (current.next!=null)
                queue.add(current.next);
        }
        return dummy.next;
    }
}

// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
        
//         ListNode dummy = new ListNode(-1);
//         ListNode curr = dummy;
//         PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
//         for(int i = 0; i < lists.length; i++){
//             if(lists[i] != null){
//                 pq.offer(lists[i]);
//             }
//         }
//         // Pop the first element from the priority queue
//         while(!pq.isEmpty()){
//             ListNode top = pq.poll();
//             curr.next = top;
//             curr = curr.next;
//             for(int i = 0; i < lists.length; i++){
//                 if(lists[i] != null){
//                     if(lists[i].val == top.val && lists[i].next != null){
//                         pq.offer(lists[i].next);
//                         lists[i] = lists[i].next;
//                         break;
//                     }
//                     else if(lists[i].val == top.val){
//                         lists[i] = lists[i].next;
//                         break;
//                     }
//                 }
//             }
//         }
//         return dummy.next;
//     }
// }
