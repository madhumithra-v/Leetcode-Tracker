// Last updated: 7/31/2026, 6:31:09 PM
1import java.util.*;
2
3class Solution {
4
5    static class Pair {
6        int node;
7        long weight;
8
9        Pair(int node, long weight) {
10            this.node = node;
11            this.weight = weight;
12        }
13    }
14
15    public long minimumWeight(int n, int[][] edges,
16                              int src1, int src2, int dest) {
17
18        List<Pair>[] graph = new ArrayList[n];
19        List<Pair>[] reverse = new ArrayList[n];
20
21        for (int i = 0; i < n; i++) {
22            graph[i] = new ArrayList<>();
23            reverse[i] = new ArrayList<>();
24        }
25
26        for (int[] e : edges) {
27            graph[e[0]].add(new Pair(e[1], e[2]));
28            reverse[e[1]].add(new Pair(e[0], e[2]));
29        }
30
31        long[] d1 = dijkstra(graph, src1);
32        long[] d2 = dijkstra(graph, src2);
33        long[] d3 = dijkstra(reverse, dest);
34
35        long ans = Long.MAX_VALUE;
36
37        for (int i = 0; i < n; i++) {
38
39            if (d1[i] == Long.MAX_VALUE ||
40                d2[i] == Long.MAX_VALUE ||
41                d3[i] == Long.MAX_VALUE)
42                continue;
43
44            ans = Math.min(ans, d1[i] + d2[i] + d3[i]);
45        }
46
47        return ans == Long.MAX_VALUE ? -1 : ans;
48    }
49
50    private long[] dijkstra(List<Pair>[] graph, int start) {
51
52        int n = graph.length;
53
54        long[] dist = new long[n];
55        Arrays.fill(dist, Long.MAX_VALUE);
56
57        PriorityQueue<Pair> pq =
58                new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
59
60        dist[start] = 0;
61        pq.offer(new Pair(start, 0));
62
63        while (!pq.isEmpty()) {
64
65            Pair cur = pq.poll();
66
67            if (cur.weight > dist[cur.node])
68                continue;
69
70            for (Pair next : graph[cur.node]) {
71
72                long newDist = cur.weight + next.weight;
73
74                if (newDist < dist[next.node]) {
75                    dist[next.node] = newDist;
76                    pq.offer(new Pair(next.node, newDist));
77                }
78            }
79        }
80
81        return dist;
82    }
83}