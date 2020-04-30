// Use a queue for bfs
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        int count = 1;
        boolean reversal = false;
        q.add(root);
        while(!q.isEmpty()){
            int newCount = 0;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < count; i++){
                TreeNode top = q.remove();
                if(top.left != null){
                    q.add(top.left);
                    newCount++;
                }
                if(top.right != null){
                    q.add(top.right);
                    newCount++;
                }
                list.add(top.val);
            }
            if(reversal) Collections.reverse(list);
            res.add(list);
            reversal = !reversal;
            count = newCount;
        }
        return res;
    }
}