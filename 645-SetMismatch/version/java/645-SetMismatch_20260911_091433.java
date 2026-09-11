// Last updated: 9/11/2026, 9:14:33 AM
1class Solution {
2    public int[] findErrorNums(int[] nums) {
3
4        int n = nums.length;
5        int[] result = new int[2];
6
7        boolean[] seen = new boolean[n + 1];
8
9        for (int num : nums) {
10            if (seen[num]) {
11                result[0] = num;
12            }
13
14            seen[num] = true;
15        }
16
17        for (int i = 1; i <= n; i++) {
18            if (!seen[i]) {
19                result[1] = i;
20                break;
21            }
22        }
23
24        return result;
25    }
26}