// Last updated: 9/8/2026, 12:31:40 PM
1class Solution {
2    public int romanToInt(String s) {
3
4        int[] values = new int[256];
5
6        values['I'] = 1;
7        values['V'] = 5;
8        values['X'] = 10;
9        values['L'] = 50;
10        values['C'] = 100;
11        values['D'] = 500;
12        values['M'] = 1000;
13
14        int result = 0;
15
16        for (int i = 0; i < s.length(); i++) {
17
18            int current = values[s.charAt(i)];
19
20            if (i + 1 < s.length() &&
21                current < values[s.charAt(i + 1)]) {
22                result -= current;
23            } else {
24                result += current;
25            }
26        }
27
28        return result;
29    }
30}