/*
 * Trick: Each node is a certain vertical offset from the root. When you move left pass in offset - 1, when you move right pass in offset + 1
 * Takeaway: How to use comparator class in java compare function
 * Using wrapper classes on each node can allow you to store values for that node
 */
class Solution {
    class nodeCompare implements Comparator<node>{
        public int compare(node n1, node n2){
            if(n1.level == n2.level){
                return n1.val.val - n2.val.val;
            }
            else{
                return n1.level - n2.level;
            }
        }
    }
    
    // Wrapper class that stores the level the node was found, and its offset from the root
    class node{
        TreeNode val;
        int offset;
        int level;
        public node(TreeNode x, int y, int z){
            this.val = x;
            this.offset = y;
            this.level = z;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int min = 0;
        int max = 0;
        int currLevel = 0;
        int numAdded = 1;
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        HashMap<Integer, PriorityQueue<node>> map = new HashMap<>();
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(root, 0, 0));
        while(!queue.isEmpty()){
            int newNumAdded = 0;
            for(int i = 0; i < numAdded; i++){
                node top = queue.remove();
                int offset = top.offset;
                map.putIfAbsent(offset, new PriorityQueue<node>(new nodeCompare()));
                map.get(offset).add(top);
                
                // Logic to check if the offset has changed
                if(offset < min) min = offset;
                if(offset > max) max = offset;
                                
                if(top.val.left != null){
                    queue.add(new node(top.val.left, offset -1, currLevel));
                    newNumAdded++;
                }
                if(top.val.right != null){
                    queue.add(new node(top.val.right, offset  + 1, currLevel));
                    newNumAdded++;
                }
            }
            numAdded = newNumAdded;
            currLevel++;
        }
        
        for(int i = min; i <= max; i++){
            List<Integer> sublist = new ArrayList<>();
            PriorityQueue<node> pq = map.get(i);
            while(!pq.isEmpty()){
                node top = pq.remove();
                sublist.add(top.val.val);
            }
            res.add(sublist);
        }
        
        return res;
    }
}