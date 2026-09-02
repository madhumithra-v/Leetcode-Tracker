// Last updated: 9/2/2026, 9:31:13 AM
1import java.util.*;
2
3class Solution {
4    public int subarraySum(int[] nums, int k) {
5
6        HashMap<Integer, Integer> map = new HashMap<>();
7
8        // Prefix sum 0 occurs once
9        map.put(0, 1);
10
11        int sum = 0;
12        int count = 0;
13
14        for (int num : nums) {
15
16            sum += num;
17
18            // Check if previous prefix sum = sum - k exists
19            if (map.containsKey(sum - k)) {
20                count += map.get(sum - k);
21            }
22
23            // Store current prefix sum
24            map.put(sum, map.getOrDefault(sum, 0) + 1);
25        }
26
27        return count;
28    }
29}