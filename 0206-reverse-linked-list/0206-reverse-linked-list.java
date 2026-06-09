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
        if(head == null) return head;
        ListNode prev = head;
        ListNode last = null;
        while(prev != null){
            ListNode temp = prev.next;
            prev.next = last;
            last = prev;

            prev = temp;
        }
        return last;
    }
}