// Last updated: 9/8/2026, 10:33:35 AM
1class Solution {
2    public int findMaxLength(int[] nums) {
3
4        HashMap<Integer, Integer> map = new HashMap<>();
5
6        // Prefix sum 0 occurs before the array starts
7        map.put(0, -1);
8
9        int sum = 0;
10        int maxLength = 0;
11
12        for (int i = 0; i < nums.length; i++) {
13
14            if (nums[i] == 0) {
15                sum--;
16            } else {
17                sum++;
18            }
19
20            if (map.containsKey(sum)) {
21                int length = i - map.get(sum);
22                maxLength = Math.max(maxLength, length);
23            } else {
24                // Store only the first occurrence
25                map.put(sum, i);
26            }
27        }
28
29        return maxLength;
30    }
31}