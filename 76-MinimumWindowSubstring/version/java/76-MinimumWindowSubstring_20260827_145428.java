// Last updated: 8/27/2026, 2:54:28 PM
1import java.util.*;
2
3class Solution {
4    public String minWindow(String s, String t) {
5
6        if (s.length() < t.length()) {
7            return "";
8        }
9
10        int[] need = new int[128];
11
12        for (char c : t.toCharArray()) {
13            need[c]++;
14        }
15
16        int left = 0;
17        int right = 0;
18        int required = t.length();
19
20        int minLength = Integer.MAX_VALUE;
21        int start = 0;
22
23        while (right < s.length()) {
24
25            char c = s.charAt(right);
26
27            if (need[c] > 0) {
28                required--;
29            }
30
31            need[c]--;
32            right++;
33
34            // Window contains all characters of t
35            while (required == 0) {
36
37                if (right - left < minLength) {
38                    minLength = right - left;
39                    start = left;
40                }
41
42                char leftChar = s.charAt(left);
43                need[leftChar]++;
44
45                if (need[leftChar] > 0) {
46                    required++;
47                }
48
49                left++;
50            }
51        }
52
53        return minLength == Integer.MAX_VALUE
54                ? ""
55                : s.substring(start, start + minLength);
56    }
57}