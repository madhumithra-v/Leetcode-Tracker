// Last updated: 9/11/2026, 9:27:58 AM
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3
4        int previous = n & 1;
5        n = n >> 1;
6
7        while (n > 0) {
8
9            int current = n & 1;
10
11            if (current == previous) {
12                return false;
13            }
14
15            previous = current;
16            n = n >> 1;
17        }
18
19        return true;
20    }
21}