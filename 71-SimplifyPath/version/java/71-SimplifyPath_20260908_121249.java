// Last updated: 9/8/2026, 12:12:49 PM
1class Solution {
2    public String simplifyPath(String path) {
3
4        Stack<String> stack = new Stack<>();
5
6        String[] parts = path.split("/");
7
8        for (String part : parts) {
9
10            if (part.equals("") || part.equals(".")) {
11                continue;
12            }
13
14            if (part.equals("..")) {
15                if (!stack.isEmpty()) {
16                    stack.pop();
17                }
18            } else {
19                stack.push(part);
20            }
21        }
22
23        StringBuilder result = new StringBuilder();
24
25        for (String dir : stack) {
26            result.append("/").append(dir);
27        }
28
29        return result.length() == 0 ? "/" : result.toString();
30    }
31}