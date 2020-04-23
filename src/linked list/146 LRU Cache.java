/* The idea is to have a doubly Linked list with head and tail pointers
 * and a hashmap that holds a reference to the nodes.
 * The trick is to store a reference to the key in the Node, so you can remove it from the map later.
 */
class LRUCache {
    class Node {
        int value;
        int key;
        Node left;
        Node right;
        public Node(int x, int y){
            left = null;
            right = null;
            key = y;
            value = x;
        }
    }
    
    HashMap<Integer, Node> map;
    final int capacity; 
    Node head;
    Node tail;    
    int numNodes;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.right = tail;
        tail.left = head;
        numNodes = 0;
    }
    
    // Implement the get
    public int get(int key) {
        // put the node at the end of the list
        if(!map.containsKey(key)){
            return -1;
        }
        Node removed = removeNode(key);
        insertNode(removed, tail.left);
        return removed.value;
    }
    
    //Implement the pcut
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(numNodes == capacity){
                Node toBeRemoved = head.right;
                map.remove(toBeRemoved.key);
                removeNode(toBeRemoved);
                numNodes--;
            }
            Node n = new Node(value, key);
            map.put(key, n);
            insertNode(n, tail.left);
            numNodes++;
        }
        else{
            Node n = removeNode(key);
            n.value = value;
            insertNode(n, tail.left);
        }
    }
    
    //Helper Method to remove the node given a key
    Node removeNode(int key){
        Node n = map.get(key);
        Node temp = n.left;
        temp.right = n.right;
        n.right.left = temp;
        return n;
    }
    
    // Helper Method to remove the node given a Node 
    Node removeNode(Node n){
        Node temp = n.left;
        temp.right = n.right;
        n.right.left = temp;
        return n;
    }
      (()) 
    //Inserts a node right after the before pointer
    void insertNode(Node n, Node before){
        Node temp = before.right;
        before.right = n;
        n.left = before;
        n.right = temp;
        temp.left = n;
    }
}