// Last updated: 9/11/2026, 9:21:32 AM
1class Solution {
2    public boolean checkPossibility(int[] nums) {
3
4        int changes = 0;
5
6        for (int i = 1; i < nums.length; i++) {
7
8            if (nums[i] < nums[i - 1]) {
9
10                changes++;
11
12                if (changes > 1) {
13                    return false;
14                }
15
16                if (i == 1 || nums[i] >= nums[i - 2]) {
17                    nums[i - 1] = nums[i];
18                } else {
19                    nums[i] = nums[i - 1];
20                }
21            }
22        }
23
24        return true;
25    }
26}