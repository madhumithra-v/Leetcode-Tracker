// Last updated: 8/8/2026, 11:36:06 PM
1import java.util.*;
2
3class Graph {
4
5    private int n;
6    private List<int[]>[] graph;
7
8    public Graph(int n, int[][] edges) {
9        this.n = n;
10
11        graph = new ArrayList[n];
12
13        for (int i = 0; i < n; i++) {
14            graph[i] = new ArrayList<>();
15        }
16
17        for (int[] edge : edges) {
18            int from = edge[0];
19            int to = edge[1];
20            int cost = edge[2];
21
22            graph[from].add(new int[]{to, cost});
23        }
24    }
25
26    public void addEdge(int[] edge) {
27
28        int from = edge[0];
29        int to = edge[1];
30        int cost = edge[2];
31
32        graph[from].add(new int[]{to, cost});
33    }
34
35    public int shortestPath(int node1, int node2) {
36
37        int[] dist = new int[n];
38
39        Arrays.fill(dist, Integer.MAX_VALUE);
40
41        dist[node1] = 0;
42
43        // Min Heap: {distance, node}
44        PriorityQueue<int[]> pq =
45                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
46
47        pq.offer(new int[]{0, node1});
48
49        while (!pq.isEmpty()) {
50
51            int[] current = pq.poll();
52
53            int currentDist = current[0];
54            int currentNode = current[1];
55
56            // Ignore outdated distance
57            if (currentDist > dist[currentNode]) {
58                continue;
59            }
60
61            // Destination reached
62            if (currentNode == node2) {
63                return currentDist;
64            }
65
66            for (int[] edge : graph[currentNode]) {
67
68                int nextNode = edge[0];
69                int weight = edge[1];
70
71                int newDist = currentDist + weight;
72
73                if (newDist < dist[nextNode]) {
74
75                    dist[nextNode] = newDist;
76
77                    pq.offer(new int[]{
78                            newDist,
79                            nextNode
80                    });
81                }
82            }
83        }
84
85        return -1;
86    }
87}