// Last updated: 9/11/2026, 9:24:27 AM
1class Solution {
2    public int findLengthOfLCIS(int[] nums) {
3
4        if (nums.length == 0) {
5            return 0;
6        }
7
8        int current = 1;
9        int longest = 1;
10
11        for (int i = 1; i < nums.length; i++) {
12
13            if (nums[i] > nums[i - 1]) {
14                current++;
15            } else {
16                current = 1;
17            }
18
19            longest = Math.max(longest, current);
20        }
21
22        return longest;
23    }
24}