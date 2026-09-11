// Last updated: 9/11/2026, 9:10:28 AM
1import java.util.*;
2
3class Solution {
4    public int maximumProduct(int[] nums) {
5
6        Arrays.sort(nums);
7
8        int n = nums.length;
9
10        return Math.max(
11            nums[0] * nums[1] * nums[n - 1],
12            nums[n - 3] * nums[n - 2] * nums[n - 1]
13        );
14    }
15}