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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode prev = null;
        int sum = 0 ; 
        int count = 1;
        int carry = 0 ; 
        while(temp1 != null || temp2 != null){
            int val1 = (temp1 != null) ? temp1.val : 0;
            int val2 = (temp2 != null) ? temp2.val : 0;
            sum = val1 + val2 + carry;
            if(temp1 != null){
                temp1.val = sum%10;
                carry = sum/10;
                prev = temp1;
                temp1 = temp1.next;
            }
            else{
                if(count == 1){
                    prev.next = temp2;
                    count =0 ;
                }
                temp2.val = sum % 10;
                carry = sum/10;
                prev = temp2;
                //temp2 = temp2.next;
            }
            if(temp2 != null)
            temp2 = temp2.next;
        }
        if(carry > 0){
            prev.next = new ListNode(sum /10);
        }
        return l1;
    }
}