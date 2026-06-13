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
       
        if(head == null) return null;
        ListNode temp = head;
        ListNode end = head;
        int n = 0;
        while(temp !=null){
            end = temp;
            temp = temp.next;
            n++;
        }
        k = k % n;
        if(k == 0) return head;
        temp = head;
        for(int i = 0 ; i < n-k-1 ; i++){
            temp = temp.next;
        }
        ListNode f = temp.next;

        temp.next = null;
        end.next = head;
        return f;
    }
}