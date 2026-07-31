// Last updated: 7/31/2026, 6:27:52 PM
1import java.util.*;
2
3class Solution {
4
5    static class Pair {
6        int node;
7        long dist;
8
9        Pair(int node, long dist) {
10            this.node = node;
11            this.dist = dist;
12        }
13    }
14
15    public int countPaths(int n, int[][] roads) {
16
17        int MOD = 1_000_000_007;
18
19        List<Pair>[] graph = new ArrayList[n];
20
21        for (int i = 0; i < n; i++)
22            graph[i] = new ArrayList<>();
23
24        for (int[] road : roads) {
25            graph[road[0]].add(new Pair(road[1], road[2]));
26            graph[road[1]].add(new Pair(road[0], road[2]));
27        }
28
29        long[] dist = new long[n];
30        Arrays.fill(dist, Long.MAX_VALUE);
31
32        long[] ways = new long[n];
33
34        PriorityQueue<Pair> pq =
35                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
36
37        dist[0] = 0;
38        ways[0] = 1;
39
40        pq.offer(new Pair(0, 0));
41
42        while (!pq.isEmpty()) {
43
44            Pair cur = pq.poll();
45
46            if (cur.dist > dist[cur.node])
47                continue;
48
49            for (Pair next : graph[cur.node]) {
50
51                long newDist = cur.dist + next.dist;
52
53                if (newDist < dist[next.node]) {
54
55                    dist[next.node] = newDist;
56                    ways[next.node] = ways[cur.node];
57
58                    pq.offer(new Pair(next.node, newDist));
59
60                } else if (newDist == dist[next.node]) {
61
62                    ways[next.node] =
63                            (ways[next.node] + ways[cur.node]) % MOD;
64                }
65            }
66        }
67
68        return (int) ways[n - 1];
69    }
70}