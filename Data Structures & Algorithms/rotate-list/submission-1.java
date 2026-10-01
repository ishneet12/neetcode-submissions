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
        if(head==null || head.next==null) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null){
            tail = tail.next;
            len++;
        }


        k = k%len;
        tail.next = head;
        ListNode cur = head;

        for(int i=0;i<len-k-1;i++){
            cur = cur.next;
        }

        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
        
    }
}