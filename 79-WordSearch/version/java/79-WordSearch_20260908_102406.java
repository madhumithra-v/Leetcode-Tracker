// Last updated: 9/8/2026, 10:24:06 AM
1class Solution {
2    public boolean exist(char[][] board, String word) {
3        int m = board.length;
4        int n = board[0].length;
5
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8
9                if (board[i][j] == word.charAt(0)) {
10                    if (dfs(board, word, i, j, 0)) {
11                        return true;
12                    }
13                }
14            }
15        }
16
17        return false;
18    }
19
20    private boolean dfs(char[][] board, String word,
21                        int row, int col, int index) {
22
23        // Entire word found
24        if (index == word.length()) {
25            return true;
26        }
27
28        // Out of bounds
29        if (row < 0 || row >= board.length ||
30            col < 0 || col >= board[0].length) {
31            return false;
32        }
33
34        // Character doesn't match
35        if (board[row][col] != word.charAt(index)) {
36            return false;
37        }
38
39        // Mark current cell as visited
40        char temp = board[row][col];
41        board[row][col] = '#';
42
43        // Explore four directions
44        boolean found =
45            dfs(board, word, row + 1, col, index + 1) ||
46            dfs(board, word, row - 1, col, index + 1) ||
47            dfs(board, word, row, col + 1, index + 1) ||
48            dfs(board, word, row, col - 1, index + 1);
49
50        // Backtrack
51        board[row][col] = temp;
52
53        return found;
54    }
55}