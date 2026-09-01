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
    public ListNode getIntersectionNode(ListNode ls1, ListNode ls2) {
        ListNode slow = ls1;
        ListNode fast = ls2;

        while(slow!=fast){
            slow = slow==null ? slow = ls2 : slow.next;
            fast = fast==null ? fast = ls1 : fast.next;
        }

        return slow;
    }
}