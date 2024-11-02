/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int size = -1 ;
        if(head == null || head.next == null){
            return head;
        }
        while(temp.next != null){
            size++;
            temp = temp.next;
        }
        ListNode curr = head;
        if(size+1 % 2 == 0 ){
            for(int i = 0 ; i <=(size/2) + 1 ; i++){
                curr = curr.next;
            }
            return curr;
        }
        else{
            for(int i = 0 ; i <= size/2 ; i++){
                curr = curr.next;
            }
            return curr;
        }
    }
}