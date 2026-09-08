// Last updated: 9/8/2026, 10:36:32 AM
1class Solution {
2    public int longestOnes(int[] nums, int k) {
3
4        int left = 0;
5        int zeros = 0;
6        int maxLength = 0;
7
8        for (int right = 0; right < nums.length; right++) {
9
10            if (nums[right] == 0) {
11                zeros++;
12            }
13
14            // Too many zeros
15            while (zeros > k) {
16                if (nums[left] == 0) {
17                    zeros--;
18                }
19                left++;
20            }
21
22            maxLength = Math.max(maxLength, right - left + 1);
23        }
24
25        return maxLength;
26    }
27}