// Last updated: 7/17/2026, 9:46:04 AM
1import java.util.*;
2
3class Solution {
4
5    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
6
7        int[] ans = new int[queries.length];
8
9        int len = nums[0].length();
10
11        for (int q = 0; q < queries.length; q++) {
12
13            int k = queries[q][0];
14            int trim = queries[q][1];
15
16            List<String[]> list = new ArrayList<>();
17
18            for (int i = 0; i < nums.length; i++) {
19
20                String trimmed = nums[i].substring(len - trim);
21
22                list.add(new String[]{trimmed, String.valueOf(i)});
23            }
24
25            Collections.sort(list, (a, b) -> {
26
27                int cmp = a[0].compareTo(b[0]);
28
29                if (cmp == 0)
30                    return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
31
32                return cmp;
33            });
34
35            ans[q] = Integer.parseInt(list.get(k - 1)[1]);
36        }
37
38        return ans;
39    }
40}
41