// Last updated: 8/27/2026, 2:49:18 PM
1import java.util.*;
2
3class Solution {
4
5    public int trapRainWater(int[][] heightMap) {
6
7        int m = heightMap.length;
8        int n = heightMap[0].length;
9
10        if (m <= 2 || n <= 2) {
11            return 0;
12        }
13
14        // {height, row, column}
15        PriorityQueue<int[]> pq = new PriorityQueue<>(
16            (a, b) -> Integer.compare(a[0], b[0])
17        );
18
19        boolean[][] visited = new boolean[m][n];
20
21        // Add all boundary cells
22        for (int i = 0; i < m; i++) {
23            pq.offer(new int[]{heightMap[i][0], i, 0});
24            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
25
26            visited[i][0] = true;
27            visited[i][n - 1] = true;
28        }
29
30        for (int j = 1; j < n - 1; j++) {
31            pq.offer(new int[]{heightMap[0][j], 0, j});
32            pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});
33
34            visited[0][j] = true;
35            visited[m - 1][j] = true;
36        }
37
38        int[] dr = {-1, 1, 0, 0};
39        int[] dc = {0, 0, -1, 1};
40
41        int water = 0;
42
43        while (!pq.isEmpty()) {
44
45            int[] current = pq.poll();
46
47            int height = current[0];
48            int r = current[1];
49            int c = current[2];
50
51            for (int k = 0; k < 4; k++) {
52
53                int nr = r + dr[k];
54                int nc = c + dc[k];
55
56                if (nr < 0 || nr >= m ||
57                    nc < 0 || nc >= n ||
58                    visited[nr][nc]) {
59                    continue;
60                }
61
62                visited[nr][nc] = true;
63
64                int nextHeight = heightMap[nr][nc];
65
66                // Water trapped at this cell
67                if (nextHeight < height) {
68                    water += height - nextHeight;
69                }
70
71                // The effective boundary height
72                int newHeight = Math.max(height, nextHeight);
73
74                pq.offer(new int[]{
75                    newHeight,
76                    nr,
77                    nc
78                });
79            }
80        }
81
82        return water;
83    }
84}