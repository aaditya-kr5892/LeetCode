/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int goodNodes(TreeNode* root) {
        return f(root, root->val);
    }
    int f(TreeNode* root, int max_val){
        if(root == nullptr) return 0;
        int res = 0;
        if(root->val >= max_val){
            res = 1;
        }
        int l = f(root->left, max(max_val, root->val));
        int r = f(root->right, max(max_val, root->val));
        
        return l+r+res;
    }
};