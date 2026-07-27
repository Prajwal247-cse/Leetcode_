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
        ListNode curr = head;

        while (curr != null) {

            // Save next node
            ListNode next = curr.next;

            // Reverse pointer
            curr.next = prev;

            // Move pointers
            prev = curr;
            curr = next;
        }

        return prev;
    }
}