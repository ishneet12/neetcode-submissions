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
    public ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;

        while(temp!=null){
            ListNode tempN = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tempN; 
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        for(int i=0;i<left-1;i++){
            temp = temp.next;
        }

        ListNode start = temp.next;
        ListNode tail = start;
        for(int i=0;i<right-left;i++){
            tail = tail.next;
        }
        ListNode nodeNext = tail.next;
        tail.next=null;

        temp.next = reverse(start);
        start.next = nodeNext;

        return dummy.next;
    }
}