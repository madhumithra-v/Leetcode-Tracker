// Last updated: 9/11/2026, 9:12:16 AM
1class Solution {
2    public boolean judgeSquareSum(int c) {
3
4        long left = 0;
5        long right = (long) Math.sqrt(c);
6
7        while (left <= right) {
8
9            long sum = left * left + right * right;
10
11            if (sum == c) {
12                return true;
13            }
14
15            if (sum < c) {
16                left++;
17            } else {
18                right--;
19            }
20        }
21
22        return false;
23    }
24}