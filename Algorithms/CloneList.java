// Clone a list with random next pointer
class Solution {
    public Node copyRandomList(Node head)a {
        HashMap<Node, Node> map = initMap(head);
        map.forEach((k,v) -> {
            v.next = map.get(k.next);
            v.random = map.get(k.random);
        });
        return map.get(head);  
    }
    
    private HashMap<Node, Node> initMap(Node head){
        HashMap<Node, Node> map =  new HashMap<>(); 
        while(head != null){
            map.put(head, new Node(head.val));
            head = head.next;
        }
        return map;
    }
}