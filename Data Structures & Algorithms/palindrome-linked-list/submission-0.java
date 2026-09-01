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

    public ListNode rev(ListNode head){
        ListNode prev = null;

        ListNode temp = head;

        while(temp!=null){
            ListNode tempN = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tempN;
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revNode = rev(slow);

        ListNode temp = head;

        while(revNode!=null){
            if(temp.val != revNode.val){
                return false;
            }

            temp = temp.next;
            revNode = revNode.next;
        }

        return true;


    }
}