// Last updated: 9/9/2026, 9:24:04 AM
1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3
4        int left = 0;
5        int right = nums.length - 1;
6
7        while (left < right) {
8
9            int mid = left + (right - left) / 2;
10
11            // Make mid even
12            if (mid % 2 == 1) {
13                mid--;
14            }
15
16            if (nums[mid] == nums[mid + 1]) {
17                left = mid + 2;
18            } else {
19                right = mid;
20            }
21        }
22
23        return nums[left];
24    }
25}