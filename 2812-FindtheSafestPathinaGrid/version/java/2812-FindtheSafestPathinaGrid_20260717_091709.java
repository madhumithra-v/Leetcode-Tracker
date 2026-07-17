// Last updated: 7/17/2026, 9:17:09 AM
1import java.util.*;
2
3class Solution {
4
5    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
6
7    public int maximumSafenessFactor(List<List<Integer>> grid) {
8
9        int n = grid.size();
10
11        int[][] dist = new int[n][n];
12
13        for(int[] row : dist)
14            Arrays.fill(row, -1);
15
16        Queue<int[]> q = new LinkedList<>();
17
18        // Multi-source BFS
19        for(int i=0;i<n;i++){
20            for(int j=0;j<n;j++){
21                if(grid.get(i).get(j)==1){
22                    dist[i][j]=0;
23                    q.offer(new int[]{i,j});
24                }
25            }
26        }
27
28        while(!q.isEmpty()){
29
30            int[] cur=q.poll();
31
32            for(int[] d:dir){
33
34                int x=cur[0]+d[0];
35                int y=cur[1]+d[1];
36
37                if(x>=0 && y>=0 && x<n && y<n && dist[x][y]==-1){
38
39                    dist[x][y]=dist[cur[0]][cur[1]]+1;
40
41                    q.offer(new int[]{x,y});
42                }
43            }
44        }
45
46        int low=0;
47        int high=2*n;
48
49        while(low<high){
50
51            int mid=(low+high+1)/2;
52
53            if(canReach(dist,mid))
54                low=mid;
55            else
56                high=mid-1;
57        }
58
59        return low;
60    }
61
62    private boolean canReach(int[][] dist,int safe){
63
64        int n=dist.length;
65
66        if(dist[0][0]<safe)
67            return false;
68
69        Queue<int[]> q=new LinkedList<>();
70
71        boolean[][] vis=new boolean[n][n];
72
73        q.offer(new int[]{0,0});
74
75        vis[0][0]=true;
76
77        while(!q.isEmpty()){
78
79            int[] cur=q.poll();
80
81            if(cur[0]==n-1 && cur[1]==n-1)
82                return true;
83
84            for(int[] d:dir){
85
86                int x=cur[0]+d[0];
87                int y=cur[1]+d[1];
88
89                if(x>=0 && y>=0 && x<n && y<n &&
90                        !vis[x][y] &&
91                        dist[x][y]>=safe){
92
93                    vis[x][y]=true;
94
95                    q.offer(new int[]{x,y});
96                }
97            }
98        }
99
100        return false;
101    }
102}