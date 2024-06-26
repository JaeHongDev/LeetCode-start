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
        if(l1 == null && l2 == null) return null;
        if(l1 == null) l1 = new ListNode(0);
        if(l2 == null) l2 = new ListNode(0);

        var value = l1.val + l2.val;
        if(value >= 10) {
            if(l1.next == null) l1.next = new ListNode(0);
            l1.next.val += 1;
            return new ListNode(value - 10, addTwoNumbers(
                l1.next,
                l2.next
            ));
        } 
        else return new ListNode(value, addTwoNumbers(l1.next, l2.next));
    }
}