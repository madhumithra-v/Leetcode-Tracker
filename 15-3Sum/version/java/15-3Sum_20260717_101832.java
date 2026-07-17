// Last updated: 7/17/2026, 10:18:32 AM
1import java.util.*;
2
3class Solution {
4
5    public List<List<Integer>> threeSum(int[] nums) {
6
7        Arrays.sort(nums);
8
9        List<List<Integer>> result = new ArrayList<>();
10
11        int n = nums.length;
12
13        for (int i = 0; i < n - 2; i++) {
14
15            // Skip duplicate first elements
16            if (i > 0 && nums[i] == nums[i - 1])
17                continue;
18
19            int left = i + 1;
20            int right = n - 1;
21
22            while (left < right) {
23
24                int sum = nums[i] + nums[left] + nums[right];
25
26                if (sum == 0) {
27
28                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
29
30                    // Skip duplicate left values
31                    while (left < right && nums[left] == nums[left + 1])
32                        left++;
33
34                    // Skip duplicate right values
35                    while (left < right && nums[right] == nums[right - 1])
36                        right--;
37
38                    left++;
39                    right--;
40
41                } else if (sum < 0) {
42                    left++;
43                } else {
44                    right--;
45                }
46            }
47        }
48
49        return result;
50    }
51}