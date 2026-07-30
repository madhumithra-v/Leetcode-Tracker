// Last updated: 7/30/2026, 10:51:10 PM
1import java.util.*;
2
3class Solution {
4
5    public boolean canFinish(int numCourses, int[][] prerequisites) {
6
7        List<Integer>[] graph = new ArrayList[numCourses];
8
9        for (int i = 0; i < numCourses; i++)
10            graph[i] = new ArrayList<>();
11
12        int[] indegree = new int[numCourses];
13
14        for (int[] pre : prerequisites) {
15            graph[pre[1]].add(pre[0]);
16            indegree[pre[0]]++;
17        }
18
19        Queue<Integer> queue = new LinkedList<>();
20
21        for (int i = 0; i < numCourses; i++)
22            if (indegree[i] == 0)
23                queue.offer(i);
24
25        int count = 0;
26
27        while (!queue.isEmpty()) {
28
29            int course = queue.poll();
30            count++;
31
32            for (int next : graph[course]) {
33
34                indegree[next]--;
35
36                if (indegree[next] == 0)
37                    queue.offer(next);
38            }
39        }
40
41        return count == numCourses;
42    }
43}