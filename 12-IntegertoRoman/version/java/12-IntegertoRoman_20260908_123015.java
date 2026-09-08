// Last updated: 9/8/2026, 12:30:15 PM
1class Solution {
2    public String intToRoman(int num) {
3
4        int[] values = {
5            1000, 900, 500, 400,
6            100, 90, 50, 40,
7            10, 9, 5, 4, 1
8        };
9
10        String[] symbols = {
11            "M", "CM", "D", "CD",
12            "C", "XC", "L", "XL",
13            "X", "IX", "V", "IV", "I"
14        };
15
16        StringBuilder result = new StringBuilder();
17
18        for (int i = 0; i < values.length; i++) {
19
20            while (num >= values[i]) {
21                result.append(symbols[i]);
22                num -= values[i];
23            }
24        }
25
26        return result.toString();
27    }
28}