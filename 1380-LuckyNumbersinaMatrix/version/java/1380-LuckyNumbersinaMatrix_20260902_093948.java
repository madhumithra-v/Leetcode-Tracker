// Last updated: 9/2/2026, 9:39:48 AM
1import java.util.*;
2
3class Solution {
4    public List<Integer> luckyNumbers(int[][] matrix) {
5
6        List<Integer> result = new ArrayList<>();
7
8        int rows = matrix.length;
9        int cols = matrix[0].length;
10
11        for (int i = 0; i < rows; i++) {
12
13            // Find minimum in current row
14            int min = matrix[i][0];
15            int minCol = 0;
16
17            for (int j = 1; j < cols; j++) {
18                if (matrix[i][j] < min) {
19                    min = matrix[i][j];
20                    minCol = j;
21                }
22            }
23
24            // Check if it is maximum in its column
25            boolean lucky = true;
26
27            for (int j = 0; j < rows; j++) {
28                if (matrix[j][minCol] > min) {
29                    lucky = false;
30                    break;
31                }
32            }
33
34            if (lucky) {
35                result.add(min);
36            }
37        }
38
39        return result;
40    }
41}