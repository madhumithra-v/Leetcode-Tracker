// Last updated: 9/2/2026, 9:27:19 AM
1import java.util.*;
2
3class Solution {
4    public String decodeString(String s) {
5
6        Stack<Integer> countStack = new Stack<>();
7        Stack<String> stringStack = new Stack<>();
8
9        String current = "";
10        int number = 0;
11
12        for (char ch : s.toCharArray()) {
13
14            if (Character.isDigit(ch)) {
15                number = number * 10 + (ch - '0');
16            }
17
18            else if (ch == '[') {
19                countStack.push(number);
20                stringStack.push(current);
21
22                number = 0;
23                current = "";
24            }
25
26            else if (ch == ']') {
27                int count = countStack.pop();
28                String previous = stringStack.pop();
29
30                StringBuilder temp = new StringBuilder(previous);
31
32                for (int i = 0; i < count; i++) {
33                    temp.append(current);
34                }
35
36                current = temp.toString();
37            }
38
39            else {
40                current += ch;
41            }
42        }
43
44        return current;
45    }
46}