// Last updated: 9/8/2026, 10:20:02 AM
1class Solution {
2    public int[][] updateMatrix(int[][] mat) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        int[][] dist = new int[m][n];
7        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
8
9        // Add all 0s to the queue
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                if (mat[i][j] == 0) {
13                    dist[i][j] = 0;
14                    queue.offer(new int[]{i, j});
15                } else {
16                    dist[i][j] = -1;
17                }
18            }
19        }
20
21        int[][] directions = {
22            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
23        };
24
25        // Multi-source BFS
26        while (!queue.isEmpty()) {
27            int[] current = queue.poll();
28            int r = current[0];
29            int c = current[1];
30
31            for (int[] dir : directions) {
32                int nr = r + dir[0];
33                int nc = c + dir[1];
34
35                if (nr >= 0 && nr < m &&
36                    nc >= 0 && nc < n &&
37                    dist[nr][nc] == -1) {
38
39                    dist[nr][nc] = dist[r][c] + 1;
40                    queue.offer(new int[]{nr, nc});
41                }
42            }
43        }
44
45        return dist;
46    }
47}