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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        f(root,list);
        //Collections.sort(list);
        int i = 0 ; int j = list.size()-1;
        while(i < j){
            if(list.get(i) + list.get(j) == k)
            return true;
            else if(list.get(i) + list.get(j) > k){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
    void f(TreeNode root, List<Integer>list){
        if(root == null){
            return;
        }
        f(root.left,list);
        list.add(root.val);
        f(root.right,list);
    }
}