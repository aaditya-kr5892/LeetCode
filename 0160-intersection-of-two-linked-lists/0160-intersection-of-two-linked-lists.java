/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        int lt1 = 0, lt2 = 0;
        while(t1!=null && t2 != null){
            t1 = t1.next;
            t2 = t2.next;
            lt1++;
            lt2++;
        }
        while(t1 != null){
            t1 = t1.next;
            lt1++;
        }
        while(t2 != null){
            t2 = t2.next;
            lt2++;
        }
        t1 = headA;
        t2 = headB;
        if(lt1 > lt2){
            while(lt1 != lt2){
                t1 = t1.next;
                lt1--;
            }
        }
        else{
            while(lt2 != lt1){
                t2 = t2.next;
                lt2--;
            }
        }

        while(t1 != null && t2 != null){
            if(t1 == t2){
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }
}