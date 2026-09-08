// Last updated: 9/8/2026, 10:31:43 AM
1class Solution {
2    public void rotate(int[][] matrix) {
3
4        int n = matrix.length;
5
6        // Step 1: Transpose
7        for (int i = 0; i < n; i++) {
8            for (int j = i; j < n; j++) {
9
10                int temp = matrix[i][j];
11                matrix[i][j] = matrix[j][i];
12                matrix[j][i] = temp;
13            }
14        }
15
16        // Step 2: Reverse each row
17        for (int i = 0; i < n; i++) {
18
19            int left = 0;
20            int right = n - 1;
21
22            while (left < right) {
23
24                int temp = matrix[i][left];
25                matrix[i][left] = matrix[i][right];
26                matrix[i][right] = temp;
27
28                left++;
29                right--;
30            }
31        }
32    }
33}