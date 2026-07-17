// Last updated: 7/17/2026, 10:11:13 AM
1class Solution {
2    public int maxArea(int[] height) {
3
4        int left = 0;
5        int right = height.length - 1;
6        int maxArea = 0;
7
8        while (left < right) {
9
10            int h = Math.min(height[left], height[right]);
11            int width = right - left;
12            int area = h * width;
13
14            maxArea = Math.max(maxArea, area);
15
16            if (height[left] < height[right]) {
17                left++;
18            } else {
19                right--;
20            }
21        }
22
23        return maxArea;
24    }
25}