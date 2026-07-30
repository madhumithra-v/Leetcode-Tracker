// Last updated: 7/30/2026, 10:57:46 PM
1import java.util.*;
2
3class Solution {
4    public ListNode mergeKLists(ListNode[] lists) {
5
6        PriorityQueue<ListNode> pq =
7                new PriorityQueue<>((a, b) -> a.val - b.val);
8
9        for (ListNode node : lists)
10            if (node != null)
11                pq.offer(node);
12
13        ListNode dummy = new ListNode(0);
14        ListNode curr = dummy;
15
16        while (!pq.isEmpty()) {
17
18            ListNode node = pq.poll();
19
20            curr.next = node;
21            curr = curr.next;
22
23            if (node.next != null)
24                pq.offer(node.next);
25        }
26
27        return dummy.next;
28    }
29}