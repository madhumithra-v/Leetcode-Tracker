// Last updated: 9/11/2026, 9:30:14 AM
1import java.util.*;
2
3class Solution {
4    public int findShortestSubArray(int[] nums) {
5        Map<Integer, Integer> count = new HashMap<>();
6        Map<Integer, Integer> first = new HashMap<>();
7
8        int degree = 0;
9        int answer = nums.length;
10
11        for (int i = 0; i < nums.length; i++) {
12            int x = nums[i];
13
14            if (!first.containsKey(x)) {
15                first.put(x, i);
16            }
17
18            count.put(x, count.getOrDefault(x, 0) + 1);
19            degree = Math.max(degree, count.get(x));
20        }
21
22        for (int x : count.keySet()) {
23            if (count.get(x) == degree) {
24                int last = 0;
25
26                for (int i = nums.length - 1; i >= 0; i--) {
27                    if (nums[i] == x) {
28                        last = i;
29                        break;
30                    }
31                }
32
33                answer = Math.min(answer, last - first.get(x) + 1);
34            }
35        }
36
37        return answer;
38    }
39}