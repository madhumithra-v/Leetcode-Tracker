// Last updated: 9/2/2026, 9:24:54 AM
1import java.util.*;
2
3class Solution {
4    public int[] intersect(int[] nums1, int[] nums2) {
5
6        HashMap<Integer, Integer> map = new HashMap<>();
7
8        // Store frequency of nums1
9        for (int num : nums1) {
10            map.put(num, map.getOrDefault(num, 0) + 1);
11        }
12
13        ArrayList<Integer> result = new ArrayList<>();
14
15        // Check nums2
16        for (int num : nums2) {
17            if (map.getOrDefault(num, 0) > 0) {
18                result.add(num);
19                map.put(num, map.get(num) - 1);
20            }
21        }
22
23        // Convert ArrayList to int[]
24        int[] answer = new int[result.size()];
25
26        for (int i = 0; i < result.size(); i++) {
27            answer[i] = result.get(i);
28        }
29
30        return answer;
31    }
32}