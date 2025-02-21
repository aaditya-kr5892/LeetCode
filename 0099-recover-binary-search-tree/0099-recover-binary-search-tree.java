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
    public void recoverTree(TreeNode root) {
        int c = 0 ;
        TreeNode t1= null ;
        TreeNode t2 = null;
        List<TreeNode> list = new ArrayList<>();
        f(root,list);
        for(int i = 0 ; i < list.size()-1 ; i++){
            if(list.get(i).val > list.get(i+1).val){
                if(c==0){
                    t1 = list.get(i);
                    c = 1;
                }
                t2 = list.get(i+1);
            }
            
        }
        int t = t1.val;
        t1.val = t2.val;
        t2.val = t;
    }
    void f(TreeNode root,List<TreeNode> list){
        if(root == null){
            return ;
        }
        f(root.left,list);
        list.add(root);
        f(root.right,list);

    }
}