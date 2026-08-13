// Last updated: 8/13/2026, 10:13:48 AM
1import java.util.*;
2
3class Solution {
4
5    public int shortestPathLength(int[][] graph) {
6
7        int n = graph.length;
8
9        // Queue stores: {node, mask, distance}
10        Queue<int[]> queue = new LinkedList<>();
11
12        // visited[node][mask]
13        boolean[][] visited = new boolean[n][1 << n];
14
15        // Start BFS from every node
16        for (int i = 0; i < n; i++) {
17
18            int mask = 1 << i;
19
20            queue.offer(new int[]{i, mask, 0});
21
22            visited[i][mask] = true;
23        }
24
25        int allVisited = (1 << n) - 1;
26
27        while (!queue.isEmpty()) {
28
29            int[] current = queue.poll();
30
31            int node = current[0];
32            int mask = current[1];
33            int distance = current[2];
34
35            // All nodes visited
36            if (mask == allVisited) {
37                return distance;
38            }
39
40            for (int next : graph[node]) {
41
42                int newMask = mask | (1 << next);
43
44                if (!visited[next][newMask]) {
45
46                    visited[next][newMask] = true;
47
48                    queue.offer(
49                        new int[]{
50                            next,
51                            newMask,
52                            distance + 1
53                        }
54                    );
55                }
56            }
57        }
58
59        return -1;
60    }
61}