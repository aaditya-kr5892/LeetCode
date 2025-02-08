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
 class custom{
    int level;
    TreeNode node;
    custom(TreeNode node,int level){
        this.level = level ;
        this.node = node;
    }
 }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<custom> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        que.add(new custom(root,0));
        while(!que.isEmpty()){
            if(que.peek().node.left != null){
                que.add(new custom(que.peek().node.left,que.peek().level+1));
            }
            if(que.peek().node.right != null){
                que.add(new custom(que.peek().node.right,que.peek().level+1));
            }
            map.put(que.peek().level,que.peek().node.val);
            que.poll();
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}