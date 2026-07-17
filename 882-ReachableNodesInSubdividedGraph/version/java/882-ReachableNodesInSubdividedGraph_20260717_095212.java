// Last updated: 7/17/2026, 9:52:12 AM
1import java.util.*;
2
3class Solution {
4
5    public int reachableNodes(int[][] edges, int maxMoves, int n) {
6
7        List<int[]>[] graph = new ArrayList[n];
8
9        for (int i = 0; i < n; i++)
10            graph[i] = new ArrayList<>();
11
12        for (int[] e : edges) {
13            graph[e[0]].add(new int[]{e[1], e[2] + 1});
14            graph[e[1]].add(new int[]{e[0], e[2] + 1});
15        }
16
17        int[] dist = new int[n];
18        Arrays.fill(dist, Integer.MAX_VALUE);
19
20        dist[0] = 0;
21
22        PriorityQueue<int[]> pq =
23                new PriorityQueue<>((a, b) -> a[1] - b[1]);
24
25        pq.offer(new int[]{0, 0});
26
27        while (!pq.isEmpty()) {
28
29            int[] cur = pq.poll();
30
31            int node = cur[0];
32            int d = cur[1];
33
34            if (d > dist[node])
35                continue;
36
37            for (int[] next : graph[node]) {
38
39                int nei = next[0];
40                int w = next[1];
41
42                if (d + w < dist[nei]) {
43
44                    dist[nei] = d + w;
45
46                    pq.offer(new int[]{nei, dist[nei]});
47                }
48            }
49        }
50
51        int ans = 0;
52
53        // Count original nodes
54        for (int d : dist)
55            if (d <= maxMoves)
56                ans++;
57
58        // Count subdivided nodes
59        for (int[] e : edges) {
60
61            int u = e[0];
62            int v = e[1];
63            int cnt = e[2];
64
65            int left = Math.max(0, maxMoves - dist[u]);
66            int right = Math.max(0, maxMoves - dist[v]);
67
68            ans += Math.min(cnt, left + right);
69        }
70
71        return ans;
72    }
73}