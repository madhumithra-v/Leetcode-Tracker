// Last updated: 9/8/2026, 12:37:42 PM
1class Solution {
2    public ListNode removeNthFromEnd(ListNode head, int n) {
3        
4        ListNode dummy = new ListNode(0);
5        dummy.next = head;
6        
7        ListNode fast = dummy;
8        ListNode slow = dummy;
9        
10        // Move fast n steps
11        for (int i = 0; i < n; i++) {
12            fast = fast.next;
13        }
14        
15        // Move both pointers
16        while (fast.next != null) {
17            fast = fast.next;
18            slow = slow.next;
19        }
20        
21        // Remove the nth node
22        slow.next = slow.next.next;
23        
24        return dummy.next;
25    }
26}