// Last updated: 7/17/2026, 10:08:16 AM
1import java.util.*;
2
3class Solution {
4
5    public int minimumObstacles(int[][] grid) {
6
7        int m = grid.length;
8        int n = grid[0].length;
9
10        int[][] dist = new int[m][n];
11
12        for (int[] row : dist)
13            Arrays.fill(row, Integer.MAX_VALUE);
14
15        int[][] dir = {
16            {1,0},
17            {-1,0},
18            {0,1},
19            {0,-1}
20        };
21
22        Deque<int[]> dq = new ArrayDeque<>();
23
24        dq.offerFirst(new int[]{0,0});
25        dist[0][0] = 0;
26
27        while (!dq.isEmpty()) {
28
29            int[] cur = dq.pollFirst();
30
31            int x = cur[0];
32            int y = cur[1];
33
34            for (int[] d : dir) {
35
36                int nx = x + d[0];
37                int ny = y + d[1];
38
39                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
40                    continue;
41
42                int newCost = dist[x][y] + grid[nx][ny];
43
44                if (newCost < dist[nx][ny]) {
45
46                    dist[nx][ny] = newCost;
47
48                    if (grid[nx][ny] == 0)
49                        dq.offerFirst(new int[]{nx, ny});
50                    else
51                        dq.offerLast(new int[]{nx, ny});
52                }
53            }
54        }
55
56        return dist[m - 1][n - 1];
57    }
58}