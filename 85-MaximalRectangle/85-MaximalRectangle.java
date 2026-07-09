// Last updated: 7/9/2026, 3:08:23 PM
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        for (char[] row : matrix) {

            for (int j = 0; j < n; j++) {
                if (row[j] == '1') heights[j]++;
                else heights[j] = 0;
            }

            maxArea = Math.max(maxArea, largestRectangle(heights));
        }

        return maxArea;
    }

    private int largestRectangle(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && h < heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }
}