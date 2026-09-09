// Last updated: 9/9/2026, 10:01:39 AM
1import java.util.*;
2
3class Solution {
4    public int findLHS(int[] nums) {
5
6        Map<Integer, Integer> map = new HashMap<>();
7
8        for (int num : nums) {
9            map.put(num, map.getOrDefault(num, 0) + 1);
10        }
11
12        int answer = 0;
13
14        for (int num : map.keySet()) {
15
16            if (map.containsKey(num + 1)) {
17                answer = Math.max(
18                    answer,
19                    map.get(num) + map.get(num + 1)
20                );
21            }
22        }
23
24        return answer;
25    }
26}