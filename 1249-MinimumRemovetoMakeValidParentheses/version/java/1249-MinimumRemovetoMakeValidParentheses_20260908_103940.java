// Last updated: 9/8/2026, 10:39:40 AM
1class Solution {
2    public String minRemoveToMakeValid(String s) {
3
4        StringBuilder str = new StringBuilder(s);
5        Stack<Integer> stack = new Stack<>();
6
7        // Find invalid parentheses
8        for (int i = 0; i < str.length(); i++) {
9
10            char ch = str.charAt(i);
11
12            if (ch == '(') {
13                stack.push(i);
14            } 
15            else if (ch == ')') {
16
17                if (!stack.isEmpty()) {
18                    stack.pop();
19                } else {
20                    // Invalid ')'
21                    str.setCharAt(i, '#');
22                }
23            }
24        }
25
26        // Remaining '(' are invalid
27        while (!stack.isEmpty()) {
28            int index = stack.pop();
29            str.setCharAt(index, '#');
30        }
31
32        // Build final answer
33        StringBuilder result = new StringBuilder();
34
35        for (int i = 0; i < str.length(); i++) {
36            if (str.charAt(i) != '#') {
37                result.append(str.charAt(i));
38            }
39        }
40
41        return result.toString();
42    }
43}