// Last updated: 9/2/2026, 9:33:18 AM
1import java.util.*;
2
3class Solution {
4    public int leastInterval(char[] tasks, int n) {
5
6        int[] freq = new int[26];
7
8        for (char task : tasks) {
9            freq[task - 'A']++;
10        }
11
12        int maxFreq = 0;
13
14        for (int f : freq) {
15            maxFreq = Math.max(maxFreq, f);
16        }
17
18        int maxCount = 0;
19
20        for (int f : freq) {
21            if (f == maxFreq) {
22                maxCount++;
23            }
24        }
25
26    
27        int result = (maxFreq - 1) * (n + 1) + maxCount;
28
29        return Math.max(result, tasks.length);
30    }
31}