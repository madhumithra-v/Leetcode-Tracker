// Last updated: 9/8/2026, 10:29:57 AM
1class Solution {
2    public int[][] merge(int[][] intervals) {
3
4        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
5
6        List<int[]> result = new ArrayList<>();
7
8        int start = intervals[0][0];
9        int end = intervals[0][1];
10
11        for (int i = 1; i < intervals.length; i++) {
12
13            if (intervals[i][0] <= end) {
14                // Overlapping
15                end = Math.max(end, intervals[i][1]);
16            } else {
17                // No overlap
18                result.add(new int[]{start, end});
19
20                start = intervals[i][0];
21                end = intervals[i][1];
22            }
23        }
24
25        result.add(new int[]{start, end});
26
27        return result.toArray(new int[result.size()][]);
28    }
29}