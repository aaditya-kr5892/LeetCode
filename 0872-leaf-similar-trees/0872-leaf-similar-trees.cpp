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
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> v1 ;
        vector<int> v2;
        f(root1, v1);
        f(root2, v2);
        if(v1 == v2) return true;
        return false;
    }
    void f(TreeNode* root, vector<int>& v1){
        if(root == nullptr) return;

        if(root->left == nullptr && root->right == nullptr){
            v1.push_back(root->val);
        }

        f(root->left, v1);
        f(root->right, v1);
    }
};