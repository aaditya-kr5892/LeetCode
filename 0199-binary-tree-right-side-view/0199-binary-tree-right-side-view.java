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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0 ; i < size ; i++){
                if(que.peek().right != null){
                    que.add(que.peek().right);
                }
                if(que.peek().left != null){
                    que.add(que.peek().left);
                }
                if(i == 0)
                    list.add(que.poll().val);
                else que.poll();
            }
        }
        return list;
    }
}