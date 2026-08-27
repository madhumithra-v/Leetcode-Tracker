// Last updated: 8/27/2026, 2:48:07 PM
1class Solution {
2
3    public int splitArray(int[] nums, int k) {
4
5        long low = 0;
6        long high = 0;
7
8        for (int num : nums) {
9            low = Math.max(low, num);
10            high += num;
11        }
12
13        // Binary search for the minimum possible largest sum
14        while (low < high) {
15
16            long mid = low + (high - low) / 2;
17
18            if (canSplit(nums, k, mid)) {
19                high = mid;
20            } else {
21                low = mid + 1;
22            }
23        }
24
25        return (int) low;
26    }
27
28    private boolean canSplit(int[] nums, int k, long maxSum) {
29
30        int parts = 1;
31        long currentSum = 0;
32
33        for (int num : nums) {
34
35            if (currentSum + num > maxSum) {
36                parts++;
37                currentSum = num;
38
39                if (parts > k) {
40                    return false;
41                }
42            } else {
43                currentSum += num;
44            }
45        }
46
47        return true;
48    }
49}