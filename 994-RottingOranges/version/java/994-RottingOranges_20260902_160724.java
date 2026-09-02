// Last updated: 9/2/2026, 4:07:24 PM
1import java.util.*;
2
3class Solution {
4    public int orangesRotting(int[][] grid) {
5
6        int rows = grid.length;
7        int cols = grid[0].length;
8
9        Queue<int[]> queue = new LinkedList<>();
10
11        int fresh = 0;
12
13        // Find rotten and fresh oranges
14        for (int i = 0; i < rows; i++) {
15            for (int j = 0; j < cols; j++) {
16
17                if (grid[i][j] == 2) {
18                    queue.offer(new int[]{i, j});
19                } else if (grid[i][j] == 1) {
20                    fresh++;
21                }
22            }
23        }
24
25        int minutes = 0;
26
27        int[][] directions = {
28            {1, 0},
29            {-1, 0},
30            {0, 1},
31            {0, -1}
32        };
33
34        // BFS
35        while (!queue.isEmpty() && fresh > 0) {
36
37            int size = queue.size();
38
39            for (int i = 0; i < size; i++) {
40
41                int[] current = queue.poll();
42
43                int r = current[0];
44                int c = current[1];
45
46                for (int[] dir : directions) {
47
48                    int nr = r + dir[0];
49                    int nc = c + dir[1];
50
51                    if (nr >= 0 && nr < rows &&
52                        nc >= 0 && nc < cols &&
53                        grid[nr][nc] == 1) {
54
55                        grid[nr][nc] = 2;
56                        fresh--;
57
58                        queue.offer(new int[]{nr, nc});
59                    }
60                }
61            }
62
63            minutes++;
64        }
65
66        return fresh == 0 ? minutes : -1;
67    }
68}