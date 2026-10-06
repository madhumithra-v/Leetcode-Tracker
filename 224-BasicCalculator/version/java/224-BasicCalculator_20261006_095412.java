// Last updated: 10/6/2026, 9:54:12 AM
1class Solution {
2    public int calculate(String s) {
3        int result = 0;
4        int number = 0;
5        int sign = 1;
6
7        java.util.Stack<Integer> stack = new java.util.Stack<>();
8
9        for (char ch : s.toCharArray()) {
10
11            if (Character.isDigit(ch)) {
12                number = number * 10 + (ch - '0');
13            }
14
15            else if (ch == '+') {
16                result += sign * number;
17                number = 0;
18                sign = 1;
19            }
20
21            else if (ch == '-') {
22                result += sign * number;
23                number = 0;
24                sign = -1;
25            }
26
27            else if (ch == '(') {
28                stack.push(result);
29                stack.push(sign);
30
31                result = 0;
32                sign = 1;
33            }
34
35            else if (ch == ')') {
36                result += sign * number;
37                number = 0;
38
39                sign = stack.pop();
40                int previousResult = stack.pop();
41
42                result = previousResult + sign * result;
43            }
44        }
45
46        return result + sign * number;
47    }
48}