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
    int pathSum(TreeNode* root, int targetSum) {
        int count = 0;
        pre(root, targetSum, count);
        return count;
    }

    void pre(TreeNode* root, int target, int& count){
        if(root == nullptr){
            return;
        }
        count += sum(root, target);
        pre(root->left, target, count);
        pre(root->right, target, count);
    }

    int sum(TreeNode* root, long long target) {
        if(root == nullptr)
            return 0;

        int count = 0;

        if(target == root->val)
            count++;

        count += sum(root->left, target - root->val);
        count += sum(root->right, target - root->val);

        return count;
    }
};