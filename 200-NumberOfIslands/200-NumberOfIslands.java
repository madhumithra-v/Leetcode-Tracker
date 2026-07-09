// Last updated: 7/9/2026, 3:07:55 PM
class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1') {
                    islands++;
                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {

        if (row < 0 || col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }
}