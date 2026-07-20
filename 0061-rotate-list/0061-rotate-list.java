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

        // Edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and tail
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Reduce unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Step 3: Make the list circular
        tail.next = head;

        // Step 4: Find the new tail
        ListNode current = head;
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }

        // Step 5: Set the new head
        ListNode newHead = current.next;

        // Step 6: Break the circle
        current.next = null;

        return newHead;
    }
}