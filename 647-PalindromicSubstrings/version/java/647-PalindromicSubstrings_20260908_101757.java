// Last updated: 9/8/2026, 10:17:57 AM
1class Solution {
2    public int countSubstrings(String s) {
3
4        int count = 0;
5
6        for (int i = 0; i < s.length(); i++) {
7
8            // Odd length palindromes
9            count += expand(s, i, i);
10
11            // Even length palindromes
12            count += expand(s, i, i + 1);
13        }
14
15        return count;
16    }
17
18    private int expand(String s, int left, int right) {
19
20        int count = 0;
21
22        while (left >= 0 &&
23               right < s.length() &&
24               s.charAt(left) == s.charAt(right)) {
25
26            count++;
27
28            left--;
29            right++;
30        }
31
32        return count;
33    }
34}