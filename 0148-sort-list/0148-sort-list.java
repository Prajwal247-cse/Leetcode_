class Solution {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        // Find middle
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (a != null && b != null) {

            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }

            cur = cur.next;
        }

        if (a != null)
            cur.next = a;

        if (b != null)
            cur.next = b;

        return dummy.next;
    }
}