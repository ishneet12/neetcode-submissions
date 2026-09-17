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
    public ListNode rev(ListNode l1){
        ListNode prev = null;
        ListNode temp = l1;

        while(temp!=null){
            ListNode tempN = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tempN;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = rev(l1);
        ListNode r2 = rev(l2);

        int carry = 0;
        ListNode dummy = null;
        
        while(r1!=null || r2!=null || carry!=0){
            int sum = (r1!=null ? r1.val : 0) + (r2!=null ? r2.val : 0)+carry;
            carry = sum/10;
            sum=sum%10;

            ListNode temp = new ListNode(sum);
            temp.next = dummy;
            dummy = temp;
            r1 = r1!=null ? r1.next : null;
            r2 = r2!=null ? r2.next : null;
        }

        return dummy; 
    }
}