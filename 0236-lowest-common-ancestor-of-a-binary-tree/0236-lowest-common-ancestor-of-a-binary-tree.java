/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        f(root, p, l1);
        f(root, q, l2);
        int ind = -1;
        for(int i = 0 ; i < Math.min(l1.size(), l2.size()) ; i++){
            if(l1.get(i).val == l2.get(i).val){
                ind = i;
            }
        }
        return l1.get(ind);

    }
    boolean f(TreeNode root, TreeNode p, List<TreeNode> list){
        if(root == null){
            return false;
        }
        if(root.val == p.val){
            list.add(root);
            return true;
        }
        boolean l = false, r = false;

        list.add(root);
        l = f(root.left, p, list);
        r = f(root.right , p, list);

        
        if(l == true || r == true){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}