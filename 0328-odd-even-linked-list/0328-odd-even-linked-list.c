/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* oddEvenList(struct ListNode* head) {
    if(head == NULL || head->next == NULL || head->next->next == NULL){
        return head;
    }
    int count = 0 ;
    struct ListNode* oddHead= head;
    struct ListNode* evenHead = head->next;
    struct ListNode* odd = oddHead;
    struct ListNode* even = evenHead;
    struct ListNode* temp = head->next->next;
    while(temp != NULL){
        count++;
        if(count%2 ==1){
            odd->next = temp;
            odd = odd->next;
        }
        else{
            even->next = temp;
            even = even->next;
        }
        temp = temp->next;
    }
    if(even != NULL)
    even->next = NULL;
    else
    even = NULL;
    if(odd != NULL)
    odd->next = evenHead;
    else
    odd= evenHead;
    return oddHead;
    
}