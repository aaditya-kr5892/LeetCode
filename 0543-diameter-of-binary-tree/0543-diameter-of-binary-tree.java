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
 class data{
    int value;
    data(int value){
        this.value = value;
    }
 }
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        data d = new data(0);
        //int arr[] = new int[1];
        int max = f(root,d);
        return d.value;
    }
    int f(TreeNode root,data d){
        if(root == null){
            return 0;
        }
        int l = f(root.left,d);
        int r = f(root.right,d);
        if(l+r > d.value){
            d.value = l+r;
        }
        return 1 + Math.max(l,r);
    }
}