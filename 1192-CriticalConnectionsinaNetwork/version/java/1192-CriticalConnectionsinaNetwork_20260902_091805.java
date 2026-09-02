// Last updated: 9/2/2026, 9:18:05 AM
1import java.util.*;
2
3class Solution {
4
5    private int time = 0;
6    private List<List<Integer>> graph;
7    private int[] discovery;
8    private int[] low;
9    private List<List<Integer>> bridges;
10
11    public List<List<Integer>> criticalConnections(
12            int n, List<List<Integer>> connections) {
13
14        graph = new ArrayList<>();
15        bridges = new ArrayList<>();
16
17        for (int i = 0; i < n; i++) {
18            graph.add(new ArrayList<>());
19        }
20
21        for (List<Integer> edge : connections) {
22            int u = edge.get(0);
23            int v = edge.get(1);
24
25            graph.get(u).add(v);
26            graph.get(v).add(u);
27        }
28
29        discovery = new int[n];
30        low = new int[n];
31
32        Arrays.fill(discovery, -1);
33
34        dfs(0, -1);
35
36        return bridges;
37    }
38
39    private void dfs(int node, int parent) {
40
41        discovery[node] = low[node] = time++;
42
43        for (int neighbor : graph.get(node)) {
44
45            // Ignore the edge back to parent
46            if (neighbor == parent) {
47                continue;
48            }
49
50            // Already visited
51            if (discovery[neighbor] != -1) {
52                low[node] = Math.min(
53                    low[node],
54                    discovery[neighbor]
55                );
56            }
57
58            // Not visited
59            else {
60                dfs(neighbor, node);
61
62                low[node] = Math.min(
63                    low[node],
64                    low[neighbor]
65                );
66
67                // Critical connection / bridge
68                if (low[neighbor] > discovery[node]) {
69                    bridges.add(
70                        Arrays.asList(node, neighbor)
71                    );
72                }
73            }
74        }
75    }
76}