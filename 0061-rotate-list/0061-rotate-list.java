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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        int count = 1 ; 
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        k = k%count;
        if(k==0){
            return head;
        }
        temp = head;
        for(int i = 1 ; i < count - k ; i++){
            temp = temp.next;
        }
        ListNode front = temp.next;
        temp.next = null;
        head = reverse(head);
        front = reverse(front);
        temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = front;
        head = reverse(head);
        return head;
    }
    ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front ;
        }
        return prev;
    }
}