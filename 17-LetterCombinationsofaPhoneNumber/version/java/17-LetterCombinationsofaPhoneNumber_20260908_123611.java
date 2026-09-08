// Last updated: 9/8/2026, 12:36:11 PM
1class Solution {
2
3    String[] letters = {
4        "", "", "abc", "def",
5        "ghi", "jkl", "mno",
6        "pqrs", "tuv", "wxyz"
7    };
8
9    List<String> result = new ArrayList<>();
10
11    public List<String> letterCombinations(String digits) {
12
13        if (digits.length() == 0) {
14            return result;
15        }
16
17        backtrack(digits, 0, new StringBuilder());
18
19        return result;
20    }
21
22    private void backtrack(String digits, int index,
23                            StringBuilder current) {
24
25        // All digits processed
26        if (index == digits.length()) {
27            result.add(current.toString());
28            return;
29        }
30
31        int digit = digits.charAt(index) - '0';
32        String chars = letters[digit];
33
34        for (char ch : chars.toCharArray()) {
35
36            // Choose
37            current.append(ch);
38
39            // Explore
40            backtrack(digits, index + 1, current);
41
42            // Undo choice (backtrack)
43            current.deleteCharAt(current.length() - 1);
44        }
45    }
46}