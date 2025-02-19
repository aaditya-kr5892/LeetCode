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
    int c = 0 ; 
    int count = 0;
    int ar;
    public int kthSmallest(TreeNode root, int k) {
        f(root,k);
        return ar;
    }
    void f(TreeNode root,int k){
        if(root == null){
            return ;
        }
        f(root.left,k);
        if(count == k-1 && c ==0){
            ar = root.val;
            c = 1 ;
            return ;
        }
        else count++;
        f(root.right,k);
    }
}