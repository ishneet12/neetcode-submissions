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
    public ListNode mergeTwoLists(ListNode temp1, ListNode temp2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        ListNode list1 = temp1;
        ListNode list2 = temp2;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ans.next = list1;
                ans = ans.next;
                list1 = list1.next;
            }

            else {
                ans.next = list2;
                ans = ans.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            ans.next = list1;
        }

        else{
            ans.next = list2;
        }

        return dummy.next;

    }
}