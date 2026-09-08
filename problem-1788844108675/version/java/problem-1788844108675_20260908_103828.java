// Last updated: 9/8/2026, 10:38:28 AM
1class Solution {
2    public String removeDuplicates(String s, int k) {
3
4        // stack[i][0] = character
5        // stack[i][1] = consecutive count
6        int[][] stack = new int[s.length()][2];
7
8        int top = -1;
9
10        for (char ch : s.toCharArray()) {
11
12            if (top >= 0 && stack[top][0] == ch) {
13                stack[top][1]++;
14            } else {
15                top++;
16                stack[top][0] = ch;
17                stack[top][1] = 1;
18            }
19
20            // Remove k consecutive characters
21            if (stack[top][1] == k) {
22                top--;
23            }
24        }
25
26        StringBuilder result = new StringBuilder();
27
28        for (int i = 0; i <= top; i++) {
29            for (int j = 0; j < stack[i][1]; j++) {
30                result.append((char) stack[i][0]);
31            }
32        }
33
34        return result.toString();
35    }
36}