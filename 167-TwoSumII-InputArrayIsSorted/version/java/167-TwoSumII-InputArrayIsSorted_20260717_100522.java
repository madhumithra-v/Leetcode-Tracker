// Last updated: 7/17/2026, 10:05:22 AM
1class Solution {
2
3    public int[] twoSum(int[] numbers, int target) {
4
5        int left = 0;
6        int right = numbers.length - 1;
7
8        while (left < right) {
9
10            int sum = numbers[left] + numbers[right];
11
12            if (sum == target) {
13                return new int[]{left + 1, right + 1};
14            } else if (sum < target) {
15                left++;
16            } else {
17                right--;
18            }
19        }
20
21        return new int[]{-1, -1};
22    }
23}