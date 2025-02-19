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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode temp = root;
        TreeNode p = null;
        while(temp != null && temp.val != key){
            p = temp;
            if(temp.val < key){
                temp = temp.right;
            }
            else
            temp = temp.left;
        }
        if(temp == null)
        return root;
        else if(temp.left == null || temp.right == null){
            TreeNode t;
            if(temp.left != null){
                t = temp.left;
                temp.left = null;
            }
            else{
                t = temp.right;
                temp.right = null;
            }
            if(p == null){
                root = t;
                return root;
            }
            if(p.val < key){
                p.right = t;
                return root;
            }
            else{
                p.left = t;
                return root;
            }
        }
        else{
            TreeNode t1 = maxn(temp.left);
            int k = t1.val;
                temp.val = k;
                temp.left = deleteNode(temp.left,k);
                return root;
        }
    }
    TreeNode maxn(TreeNode root){
        TreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }
}