/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return head; 
        ListNode* curr = head;
        ListNode* n = head->next;
        ListNode* h = head;
        while(curr != nullptr){
            ListNode* ne = curr->next;
            if(curr->next != nullptr){
                curr->next = curr->next->next;
            }
            curr = ne;
        }
        while(h->next != nullptr){
            h = h->next;
        }

        h->next = n;
        return head;
    }
};