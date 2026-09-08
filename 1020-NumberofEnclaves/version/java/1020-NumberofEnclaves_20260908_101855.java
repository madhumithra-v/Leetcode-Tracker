// Last updated: 9/8/2026, 10:18:55 AM
1class Solution {
2
3    public int numEnclaves(int[][] grid) {
4
5        int rows = grid.length;
6        int cols = grid[0].length;
7
8        // Remove all land connected to the boundary
9        for (int i = 0; i < rows; i++) {
10            if (grid[i][0] == 1) {
11                dfs(grid, i, 0);
12            }
13
14            if (grid[i][cols - 1] == 1) {
15                dfs(grid, i, cols - 1);
16            }
17        }
18
19        for (int j = 0; j < cols; j++) {
20            if (grid[0][j] == 1) {
21                dfs(grid, 0, j);
22            }
23
24            if (grid[rows - 1][j] == 1) {
25                dfs(grid, rows - 1, j);
26            }
27        }
28
29        // Count remaining land
30        int count = 0;
31
32        for (int i = 0; i < rows; i++) {
33            for (int j = 0; j < cols; j++) {
34                if (grid[i][j] == 1) {
35                    count++;
36                }
37            }
38        }
39
40        return count;
41    }
42
43    private void dfs(int[][] grid, int r, int c) {
44
45        int rows = grid.length;
46        int cols = grid[0].length;
47
48        if (r < 0 || r >= rows ||
49            c < 0 || c >= cols ||
50            grid[r][c] != 1) {
51            return;
52        }
53
54        // Mark as visited
55        grid[r][c] = 0;
56
57        dfs(grid, r + 1, c);
58        dfs(grid, r - 1, c);
59        dfs(grid, r, c + 1);
60        dfs(grid, r, c - 1);
61    }
62}