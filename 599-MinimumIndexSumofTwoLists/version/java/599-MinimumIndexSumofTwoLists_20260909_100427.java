// Last updated: 9/9/2026, 10:04:27 AM
1import java.util.*;
2
3class Solution {
4    public String[] findRestaurant(String[] list1, String[] list2) {
5
6        Map<String, Integer> map = new HashMap<>();
7
8        for (int i = 0; i < list1.length; i++) {
9            map.put(list1[i], i);
10        }
11
12        List<String> result = new ArrayList<>();
13        int minSum = Integer.MAX_VALUE;
14
15        for (int i = 0; i < list2.length; i++) {
16
17            if (map.containsKey(list2[i])) {
18
19                int sum = i + map.get(list2[i]);
20
21                if (sum < minSum) {
22                    minSum = sum;
23                    result.clear();
24                    result.add(list2[i]);
25                } else if (sum == minSum) {
26                    result.add(list2[i]);
27                }
28            }
29        }
30
31        return result.toArray(new String[0]);
32    }
33}