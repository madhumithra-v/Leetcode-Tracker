// Last updated: 9/9/2026, 9:22:42 AM
1import java.util.*;
2
3class Solution {
4    public int findMinDifference(List<String> timePoints) {
5
6        int[] minutes = new int[timePoints.size()];
7
8        for (int i = 0; i < timePoints.size(); i++) {
9            String time = timePoints.get(i);
10
11            int hour = Integer.parseInt(time.substring(0, 2));
12            int minute = Integer.parseInt(time.substring(3, 5));
13
14            minutes[i] = hour * 60 + minute;
15        }
16
17        Arrays.sort(minutes);
18
19        int minDiff = Integer.MAX_VALUE;
20
21        for (int i = 1; i < minutes.length; i++) {
22            minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
23        }
24
25        // Difference between last time and first time across midnight
26        int circularDiff = 1440 - minutes[minutes.length - 1] + minutes[0];
27
28        return Math.min(minDiff, circularDiff);
29    }
30}