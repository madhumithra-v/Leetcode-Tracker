// Last updated: 9/8/2026, 12:34:36 PM
1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3
4        Arrays.sort(nums);
5
6        int closest = nums[0] + nums[1] + nums[2];
7
8        for (int i = 0; i < nums.length - 2; i++) {
9
10            int left = i + 1;
11            int right = nums.length - 1;
12
13            while (left < right) {
14
15                int sum = nums[i] + nums[left] + nums[right];
16
17                // Exact answer
18                if (sum == target) {
19                    return sum;
20                }
21
22                // Update closest
23                if (Math.abs(sum - target) <
24                    Math.abs(closest - target)) {
25                    closest = sum;
26                }
27
28                // Move pointers
29                if (sum < target) {
30                    left++;
31                } else {
32                    right--;
33                }
34            }
35        }
36
37        return closest;
38    }
39}