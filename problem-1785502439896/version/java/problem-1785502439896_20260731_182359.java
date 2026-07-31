// Last updated: 7/31/2026, 6:23:59 PM
1import java.util.*;
2
3class Solution {
4    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
5
6        List<List<Pair>> graph = new ArrayList<>();
7
8        for (int i = 0; i < n; i++)
9            graph.add(new ArrayList<>());
10
11        for (int i = 0; i < edges.length; i++) {
12            int u = edges[i][0];
13            int v = edges[i][1];
14            double p = succProb[i];
15
16            graph.get(u).add(new Pair(v, p));
17            graph.get(v).add(new Pair(u, p));
18        }
19
20        double[] prob = new double[n];
21        prob[start] = 1.0;
22
23        PriorityQueue<State> pq = new PriorityQueue<>((a, b) ->
24                Double.compare(b.probability, a.probability));
25
26        pq.offer(new State(start, 1.0));
27
28        while (!pq.isEmpty()) {
29
30            State current = pq.poll();
31
32            int node = current.node;
33            double currentProb = current.probability;
34
35            if (node == end)
36                return currentProb;
37
38            if (currentProb < prob[node])
39                continue;
40
41            for (Pair next : graph.get(node)) {
42
43                double newProb = currentProb * next.probability;
44
45                if (newProb > prob[next.node]) {
46                    prob[next.node] = newProb;
47                    pq.offer(new State(next.node, newProb));
48                }
49            }
50        }
51
52        return 0.0;
53    }
54
55    class Pair {
56        int node;
57        double probability;
58
59        Pair(int node, double probability) {
60            this.node = node;
61            this.probability = probability;
62        }
63    }
64
65    class State {
66        int node;
67        double probability;
68
69        State(int node, double probability) {
70            this.node = node;
71            this.probability = probability;
72        }
73    }
74}