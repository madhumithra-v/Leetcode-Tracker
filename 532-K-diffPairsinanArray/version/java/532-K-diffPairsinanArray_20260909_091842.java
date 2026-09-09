// Last updated: 9/9/2026, 9:18:42 AM
1import java.util.*;
2
3class Solution {
4    public int findPairs(int[] nums, int k) {
5        if (k < 0) {
6            return 0;
7        }
8
9        Map<Integer, Integer> count = new HashMap<>();
10
11        for (int num : nums) {
12            count.put(num, count.getOrDefault(num, 0) + 1);
13        }
14
15        int ans = 0;
16
17        if (k == 0) {
18            for (int num : count.keySet()) {
19                if (count.get(num) > 1) {
20                    ans++;
21                }
22            }
23        } else {
24            for (int num : count.keySet()) {
25                if (count.containsKey(num + k)) {
26                    ans++;
27                }
28            }
29        }
30
31        return ans;
32    }
33}