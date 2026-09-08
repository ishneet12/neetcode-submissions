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
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode rev1 = l1;
        ListNode rev2 = l2;

        int carry = 0;


        while(rev1!=null || rev2!=null || carry!=0 ){
            int v1 = (rev1 != null) ? rev1.val : 0;
            int v2 = (rev2 != null) ? rev2.val : 0;

            int val = v1 + v2 + carry;
            carry = val/10;
            val = val%10;
            cur.next = new ListNode(val);
            cur = cur.next;
            rev1 = (rev1!=null)?rev1.next : null;
            rev2 = (rev2!=null)?rev2.next : null;
        }

        return dummy.next;
    }
}
