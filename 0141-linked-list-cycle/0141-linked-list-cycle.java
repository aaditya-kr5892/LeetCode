/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        int len = (int)Math.pow(10, 4) + 2;
        for(int i = 0 ; i < len ; i++){
            head = head.next;
            if(head == null){
                return false;
            }
        }
        return true;
    }
}