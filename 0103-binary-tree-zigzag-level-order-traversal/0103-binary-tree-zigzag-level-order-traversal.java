/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        que.add(root);
        int count = 0;
        while(!que.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int s = que.size();
            for(int i = 0; i < s ; i++){
                TreeNode r = que.poll();
                l.add(r.val);
                if(r.left != null){
                    que.add(r.left);
                }
                if(r.right != null){
                    que.add(r.right);
                }
            }
            if(count % 2 == 1) Collections.reverse(l);
            count++;
            list.add(l);
        }
        return list;
    }
}