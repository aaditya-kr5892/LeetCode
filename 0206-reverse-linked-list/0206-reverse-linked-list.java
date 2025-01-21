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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = recursion(head);
        return temp;
    }
    static ListNode recursion(ListNode temp){
        if(temp == null || temp.next == null){
            return temp;
        }
        ListNode newhead = recursion(temp.next);
        ListNode front = temp.next;
        front.next = temp;
        temp.next = null;
        return newhead;
    }
}