// Last updated: 7/31/2026, 6:26:20 PM
1import java.util.*;
2
3class Solution {
4
5    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
6
7        int n = passingFees.length;
8
9        List<int[]>[] graph = new ArrayList[n];
10
11        for (int i = 0; i < n; i++)
12            graph[i] = new ArrayList<>();
13
14        for (int[] e : edges) {
15            graph[e[0]].add(new int[]{e[1], e[2]});
16            graph[e[1]].add(new int[]{e[0], e[2]});
17        }
18
19        int[][] dist = new int[n][maxTime + 1];
20
21        for (int i = 0; i < n; i++)
22            Arrays.fill(dist[i], Integer.MAX_VALUE);
23
24        PriorityQueue<int[]> pq = new PriorityQueue<>(
25                (a, b) -> a[0] - b[0]);
26
27        dist[0][0] = passingFees[0];
28
29        pq.offer(new int[]{passingFees[0], 0, 0});
30        // {cost, city, time}
31
32        while (!pq.isEmpty()) {
33
34            int[] cur = pq.poll();
35
36            int cost = cur[0];
37            int city = cur[1];
38            int time = cur[2];
39
40            if (city == n - 1)
41                return cost;
42
43            if (cost > dist[city][time])
44                continue;
45
46            for (int[] next : graph[city]) {
47
48                int newCity = next[0];
49                int travelTime = next[1];
50
51                int newTime = time + travelTime;
52
53                if (newTime > maxTime)
54                    continue;
55
56                int newCost = cost + passingFees[newCity];
57
58                if (newCost < dist[newCity][newTime]) {
59
60                    dist[newCity][newTime] = newCost;
61
62                    pq.offer(new int[]{
63                            newCost,
64                            newCity,
65                            newTime
66                    });
67                }
68            }
69        }
70
71        return -1;
72    }
73}