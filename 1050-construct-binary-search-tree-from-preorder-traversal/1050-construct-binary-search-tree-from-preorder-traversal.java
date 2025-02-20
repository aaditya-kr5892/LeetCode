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
    public TreeNode bstFromPreorder(int[] preorder) {
        return f(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    TreeNode f(int pre[],int upperBound,int[] index){
        if(index[0] == pre.length || pre[index[0]] > upperBound){
            return null;
        }
        TreeNode root = new TreeNode(pre[index[0]++]);
        root.left = f(pre,root.val,index);
        root.right = f(pre,upperBound, index);
        return root;
    }
}