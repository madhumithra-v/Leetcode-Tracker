// Last updated: 9/11/2026, 9:28:49 AM
1class Solution {
2    public int countBinarySubstrings(String s) {
3
4        int previous = 0;
5        int current = 1;
6        int answer = 0;
7
8        for (int i = 1; i < s.length(); i++) {
9
10            if (s.charAt(i) == s.charAt(i - 1)) {
11                current++;
12            } else {
13                answer += Math.min(previous, current);
14                previous = current;
15                current = 1;
16            }
17        }
18
19        answer += Math.min(previous, current);
20
21        return answer;
22    }
23}