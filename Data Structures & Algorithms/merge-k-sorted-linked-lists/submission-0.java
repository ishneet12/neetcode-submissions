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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node->node.val));

        for(ListNode le : lists){
            if(le!=null){
                pq.offer(le);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            ans.next = smallest;
            ans = ans.next;
            if(smallest.next!=null){
                pq.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}
