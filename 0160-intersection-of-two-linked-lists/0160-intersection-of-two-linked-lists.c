/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    struct ListNode* tempA = headA;
    struct ListNode* tempB = headB;
    if(headA == headB){
        return headA;
    }
    while(tempA != tempB){
        tempA = (tempA == NULL) ? headA : tempA->next;
        tempB = (tempB == NULL) ? headB : tempB->next;
    }
    return tempA;
}