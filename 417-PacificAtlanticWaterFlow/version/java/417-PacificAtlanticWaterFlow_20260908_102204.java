// Last updated: 9/8/2026, 10:22:04 AM
1class Solution {
2    public List<List<Integer>> pacificAtlantic(int[][] heights) {
3        int m = heights.length;
4        int n = heights[0].length;
5
6        boolean[][] pacific = new boolean[m][n];
7        boolean[][] atlantic = new boolean[m][n];
8
9        for (int i = 0; i < m; i++) {
10            dfs(heights, pacific, i, 0);
11            dfs(heights, atlantic, i, n - 1);
12        }
13
14        for (int j = 0; j < n; j++) {
15            dfs(heights, pacific, 0, j);
16            dfs(heights, atlantic, m - 1, j);
17        }
18
19        List<List<Integer>> result = new ArrayList<>();
20
21        for (int i = 0; i < m; i++) {
22            for (int j = 0; j < n; j++) {
23                if (pacific[i][j] && atlantic[i][j]) {
24                    result.add(Arrays.asList(i, j));
25                }
26            }
27        }
28
29        return result;
30    }
31
32    private void dfs(int[][] heights, boolean[][] ocean,
33                     int r, int c) {
34
35        if (ocean[r][c]) {
36            return;
37        }
38
39        ocean[r][c] = true;
40
41        int[][] directions = {
42            {1, 0},
43            {-1, 0},
44            {0, 1},
45            {0, -1}
46        };
47
48        for (int[] dir : directions) {
49            int nr = r + dir[0];
50            int nc = c + dir[1];
51
52            if (nr >= 0 && nr < heights.length &&
53                nc >= 0 && nc < heights[0].length &&
54                !ocean[nr][nc] &&
55                heights[nr][nc] >= heights[r][c]) {
56
57                dfs(heights, ocean, nr, nc);
58            }
59        }
60    }
61}