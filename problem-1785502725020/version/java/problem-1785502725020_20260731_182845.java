// Last updated: 7/31/2026, 6:28:45 PM
1import java.util.*;
2
3class Solution {
4
5    public int secondMinimum(int n, int[][] edges, int time, int change) {
6
7        List<Integer>[] graph = new ArrayList[n + 1];
8
9        for (int i = 1; i <= n; i++)
10            graph[i] = new ArrayList<>();
11
12        for (int[] edge : edges) {
13            graph[edge[0]].add(edge[1]);
14            graph[edge[1]].add(edge[0]);
15        }
16
17        int[] first = new int[n + 1];
18        int[] second = new int[n + 1];
19
20        Arrays.fill(first, Integer.MAX_VALUE);
21        Arrays.fill(second, Integer.MAX_VALUE);
22
23        Queue<int[]> queue = new LinkedList<>();
24        queue.offer(new int[]{1, 0});
25
26        first[1] = 0;
27
28        while (!queue.isEmpty()) {
29
30            int[] cur = queue.poll();
31
32            int node = cur[0];
33            int currTime = cur[1];
34
35            int depart = currTime;
36
37            if ((depart / change) % 2 == 1)
38                depart = (depart / change + 1) * change;
39
40            int arrival = depart + time;
41
42            for (int next : graph[node]) {
43
44                if (arrival < first[next]) {
45
46                    second[next] = first[next];
47                    first[next] = arrival;
48
49                    queue.offer(new int[]{next, arrival});
50
51                } else if (arrival > first[next] &&
52                           arrival < second[next]) {
53
54                    second[next] = arrival;
55
56                    queue.offer(new int[]{next, arrival});
57                }
58            }
59        }
60
61        return second[n];
62    }
63}