// Last updated: 9/2/2026, 9:23:09 AM
1public class Solution {
2    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
3
4        ListNode a = headA;
5        ListNode b = headB;
6
7        while (a != b) {
8            if (a == null)
9                a = headB;
10            else
11                a = a.next;
12
13            if (b == null)
14                b = headA;
15            else
16                b = b.next;
17        }
18
19        return a;
20    }
21}