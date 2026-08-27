// Last updated: 8/27/2026, 2:55:30 PM
1class Solution {
2    public int climbStairs(int n) {
3
4        if (n <= 2) {
5            return n;
6        }
7
8        int prev2 = 1;
9        int prev1 = 2;
10
11        for (int i = 3; i <= n; i++) {
12            int current = prev1 + prev2;
13
14            prev2 = prev1;
15            prev1 = current;
16        }
17
18        return prev1;
19    }
20}