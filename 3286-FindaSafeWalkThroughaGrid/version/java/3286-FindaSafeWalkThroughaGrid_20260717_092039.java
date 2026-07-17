// Last updated: 7/17/2026, 9:20:39 AM
1import java.util.*;
2
3class Solution {
4
5    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
6
7        int m = grid.size();
8        int n = grid.get(0).size();
9
10        int[][] dist = new int[m][n];
11
12        for (int[] row : dist)
13            Arrays.fill(row, Integer.MAX_VALUE);
14
15        PriorityQueue<int[]> pq = new PriorityQueue<>(
16                (a, b) -> a[0] - b[0]
17        );
18
19        dist[0][0] = grid.get(0).get(0);
20        pq.offer(new int[]{dist[0][0], 0, 0});
21
22        int[][] dir = {
23                {1,0},
24                {-1,0},
25                {0,1},
26                {0,-1}
27        };
28
29        while (!pq.isEmpty()) {
30
31            int[] cur = pq.poll();
32
33            int cost = cur[0];
34            int x = cur[1];
35            int y = cur[2];
36
37            if (cost > dist[x][y])
38                continue;
39
40            if (x == m - 1 && y == n - 1)
41                return cost < health;
42
43            for (int[] d : dir) {
44
45                int nx = x + d[0];
46                int ny = y + d[1];
47
48                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
49
50                    int newCost = cost + grid.get(nx).get(ny);
51
52                    if (newCost < dist[nx][ny]) {
53
54                        dist[nx][ny] = newCost;
55
56                        pq.offer(new int[]{
57                                newCost,
58                                nx,
59                                ny
60                        });
61                    }
62                }
63            }
64        }
65
66        return false;
67    }
68}