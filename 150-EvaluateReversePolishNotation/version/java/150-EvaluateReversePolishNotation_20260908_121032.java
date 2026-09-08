// Last updated: 9/8/2026, 12:10:32 PM
1class Solution {
2    public int evalRPN(String[] tokens) {
3
4        Stack<Integer> stack = new Stack<>();
5
6        for (String token : tokens) {
7
8            if (token.equals("+") ||
9                token.equals("-") ||
10                token.equals("*") ||
11                token.equals("/")) {
12
13                int b = stack.pop();
14                int a = stack.pop();
15
16                int result = 0;
17
18                if (token.equals("+")) {
19                    result = a + b;
20                } 
21                else if (token.equals("-")) {
22                    result = a - b;
23                } 
24                else if (token.equals("*")) {
25                    result = a * b;
26                } 
27                else {
28                    result = a / b;
29                }
30
31                stack.push(result);
32
33            } else {
34                stack.push(Integer.parseInt(token));
35            }
36        }
37
38        return stack.pop();
39    }
40}