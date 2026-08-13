// Last updated: 8/13/2026, 10:09:52 AM
1import java.util.*;
2
3class Solution {
4
5    public int swimInWater(int[][] grid) {
6
7        int n = grid.length;
8
9        // {time, row, col}
10        PriorityQueue<int[]> pq = new PriorityQueue<>(
11            (a, b) -> Integer.compare(a[0], b[0])
12        );
13
14        boolean[][] visited = new boolean[n][n];
15
16        pq.offer(new int[]{grid[0][0], 0, 0});
17
18        int[] dr = {-1, 1, 0, 0};
19        int[] dc = {0, 0, -1, 1};
20
21        while (!pq.isEmpty()) {
22
23            int[] current = pq.poll();
24
25            int time = current[0];
26            int r = current[1];
27            int c = current[2];
28
29            if (visited[r][c])
30                continue;
31
32            visited[r][c] = true;
33
34            // Reached destination
35            if (r == n - 1 && c == n - 1) {
36                return time;
37            }
38
39            for (int k = 0; k < 4; k++) {
40
41                int nr = r + dr[k];
42                int nc = c + dc[k];
43
44                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
45                    continue;
46
47                if (visited[nr][nc])
48                    continue;
49
50                int newTime = Math.max(time, grid[nr][nc]);
51
52                pq.offer(new int[]{
53                    newTime,
54                    nr,
55                    nc
56                });
57            }
58        }
59
60        return -1;
61    }
62}