// Last updated: 9/11/2026, 9:20:22 AM
1class Solution {
2    public int[][] imageSmoother(int[][] img) {
3
4        int rows = img.length;
5        int cols = img[0].length;
6
7        int[][] result = new int[rows][cols];
8
9        for (int i = 0; i < rows; i++) {
10            for (int j = 0; j < cols; j++) {
11
12                int sum = 0;
13                int count = 0;
14
15                for (int x = i - 1; x <= i + 1; x++) {
16                    for (int y = j - 1; y <= j + 1; y++) {
17
18                        if (x >= 0 && x < rows &&
19                            y >= 0 && y < cols) {
20
21                            sum += img[x][y];
22                            count++;
23                        }
24                    }
25                }
26
27                result[i][j] = sum / count;
28            }
29        }
30
31        return result;
32    }
33}