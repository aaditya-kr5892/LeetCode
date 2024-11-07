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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
        return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Solution list = new Solution();
        ListNode newhead = list.reverse(slow.next);
        ListNode temp = head;
        ListNode temp1 = newhead;
        while(temp1 != null){
            if(temp.val == temp1.val){
                temp = temp.next ;
                temp1 = temp1.next;
            }
            else
            return false;
        }
        list.reverse(newhead);
        return true;
    }
    public ListNode reverse(ListNode tead){
        ListNode temp = tead;
        ListNode front = temp.next;
        ListNode prev = null;
        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
            //front = temp.next;
        }
        return prev;
    }
}