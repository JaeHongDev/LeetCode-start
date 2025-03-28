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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; 
        ListNode node = head;

        while(node != null) {
            var next = node.next;

            node.next = prev;
            prev = node;
            node = next;
        }

        return prev; 
    }
}