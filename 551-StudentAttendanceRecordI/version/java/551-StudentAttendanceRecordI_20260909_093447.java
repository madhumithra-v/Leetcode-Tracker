// Last updated: 9/9/2026, 9:34:47 AM
1class Solution {
2    public boolean checkRecord(String s) {
3        int absent = 0;
4        int late = 0;
5
6        for (char c : s.toCharArray()) {
7
8            if (c == 'A') {
9                absent++;
10                if (absent > 1) {
11                    return false;
12                }
13            }
14
15            if (c == 'L') {
16                late++;
17                if (late >= 3) {
18                    return false;
19                }
20            } else {
21                late = 0;
22            }
23        }
24
25        return true;
26    }
27}