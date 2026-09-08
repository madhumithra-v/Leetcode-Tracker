// Last updated: 9/8/2026, 10:17:06 AM
1import java.util.*;
2
3class Solution {
4    public boolean wordBreak(String s, List<String> wordDict) {
5
6        HashSet<String> set = new HashSet<>(wordDict);
7
8        boolean[] dp = new boolean[s.length() + 1];
9
10        // Empty string can always be formed
11        dp[0] = true;
12
13        for (int i = 1; i <= s.length(); i++) {
14
15            for (int j = 0; j < i; j++) {
16
17                if (dp[j] && set.contains(s.substring(j, i))) {
18                    dp[i] = true;
19                    break;
20                }
21            }
22        }
23
24        return dp[s.length()];
25    }
26}