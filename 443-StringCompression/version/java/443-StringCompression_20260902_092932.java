// Last updated: 9/2/2026, 9:29:32 AM
1class Solution {
2    public int compress(char[] chars) {
3
4        int write = 0;
5        int i = 0;
6
7        while (i < chars.length) {
8
9            char current = chars[i];
10            int count = 0;
11
12            // Count consecutive characters
13            while (i < chars.length && chars[i] == current) {
14                i++;
15                count++;
16            }
17
18            // Write the character
19            chars[write++] = current;
20
21            // Write count if greater than 1
22            if (count > 1) {
23                String str = String.valueOf(count);
24
25                for (char c : str.toCharArray()) {
26                    chars[write++] = c;
27                }
28            }
29        }
30
31        return write;
32    }
33}