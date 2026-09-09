// Last updated: 9/9/2026, 9:53:04 AM
1class Solution {
2    public int[][] matrixReshape(int[][] mat, int r, int c) {
3
4        int rows = mat.length;
5        int cols = mat[0].length;
6
7        if (rows * cols != r * c) {
8            return mat;
9        }
10
11        int[][] result = new int[r][c];
12
13        for (int i = 0; i < rows * cols; i++) {
14            result[i / c][i % c] = mat[i / cols][i % cols];
15        }
16
17        return result;
18    }
19}