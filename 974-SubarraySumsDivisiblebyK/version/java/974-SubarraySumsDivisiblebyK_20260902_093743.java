// Last updated: 9/2/2026, 9:37:43 AM
1import java.util.*;
2
3class Solution {
4    public int subarraysDivByK(int[] nums, int k) {
5
6        HashMap<Integer, Integer> map = new HashMap<>();
7
8        // Remainder 0 occurs once initially
9        map.put(0, 1);
10
11        int sum = 0;
12        int count = 0;
13
14        for (int num : nums) {
15
16            sum += num;
17
18            int remainder = sum % k;
19
20            // Handle negative remainder
21            if (remainder < 0) {
22                remainder += k;
23            }
24
25            if (map.containsKey(remainder)) {
26                count += map.get(remainder);
27            }
28
29            map.put(remainder,
30                    map.getOrDefault(remainder, 0) + 1);
31        }
32
33        return count;
34    }
35}