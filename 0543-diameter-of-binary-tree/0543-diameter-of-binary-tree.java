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
        // int l = 0, r = 0;
        int max[] = new int[1];
        int l = f(root, max);
        return max[0];
    }
    int f(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }
        int l = 0, r = 0;
        l = f(root.left, max);
        r = f(root.right, max);
        // return 
        max[0] = Math.max(max[0], l + r);
        return 1+Math.max(l, r);
    }
}