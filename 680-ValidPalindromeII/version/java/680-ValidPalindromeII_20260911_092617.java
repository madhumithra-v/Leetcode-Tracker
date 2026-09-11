// Last updated: 9/11/2026, 9:26:17 AM
1class Solution {
2    public boolean validPalindrome(String s) {
3
4        int left = 0;
5        int right = s.length() - 1;
6
7        while (left < right) {
8
9            if (s.charAt(left) != s.charAt(right)) {
10
11                return isPalindrome(s, left + 1, right) ||
12                       isPalindrome(s, left, right - 1);
13            }
14
15            left++;
16            right--;
17        }
18
19        return true;
20    }
21
22    private boolean isPalindrome(String s, int left, int right) {
23
24        while (left < right) {
25
26            if (s.charAt(left) != s.charAt(right)) {
27                return false;
28            }
29
30            left++;
31            right--;
32        }
33
34        return true;
35    }
36}