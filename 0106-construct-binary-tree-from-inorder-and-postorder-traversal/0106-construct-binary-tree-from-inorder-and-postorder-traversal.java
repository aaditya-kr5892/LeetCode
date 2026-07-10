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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }
        return f(inorder, postorder, 0, inorder.length-1, postorder.length-1, 0, map);
    }
    TreeNode f(int in[], int []po, int in_s, int in_e, int po_s, int po_e, Map<Integer, Integer> map){
        if(in_s > in_e || po_s < po_e){
            return null;
        }
        TreeNode r = new TreeNode(po[po_s], null, null);
        int mid = map.get(po[po_s]);
        int len = in_e-mid;
        r.right = f(in, po, mid+1, in_e, po_s-1, po_s-len, map);
        r.left = f(in, po, in_s, mid-1, po_s-len-1, po_e, map);
        return r;
    }
}