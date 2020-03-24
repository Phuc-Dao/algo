/*
 * Serialize using preorder traversal. Then after trying to reconstruct the tree, notice how we 
 * always reconstructed using the first element in the list. 
 */ 
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    // Helper method to serialize the tree
    void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(Integer.toString(root.val));
        sb.append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }
    
    public TreeNode deserializeHelper(Queue<String> q){
        if(q.peek().equals("null")){
            q.remove();
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(q.remove()));
        head.left = deserializeHelper(q);
        head.right = deserializeHelper(q);
        return head;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(split));
        return deserializeHelper(q);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));