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
    public int diameterOfBinaryTree(TreeNode root) {
        int arr[] = new int[1];
        int max = f(root,arr);
        return arr[0];
    }
    int f(TreeNode root,int[] arr){
        if(root == null){
            return 0;
        }
        int l = f(root.left,arr);
        int r = f(root.right,arr);
        if(l+r > arr[0]){
            arr[0] = l+r;
        }
        return 1 + Math.max(l,r);
    }
}