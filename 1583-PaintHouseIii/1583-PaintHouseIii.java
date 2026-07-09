// Last updated: 7/9/2026, 3:06:42 PM
class Solution {

    private static final int INF = 1000000000;

    public int minCost(int[] houses, int[][] cost,
                       int m, int n, int target) {

        int[][][] dp = new int[m][n + 1][target + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                java.util.Arrays.fill(dp[i][j], INF);
            }
        }

        if (houses[0] == 0) {
            for (int color = 1; color <= n; color++) {
                dp[0][color][1] = cost[0][color - 1];
            }
        } else {
            dp[0][houses[0]][1] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int color = 1; color <= n; color++) {

                if (houses[i] != 0 && houses[i] != color)
                    continue;

                int paintCost =
                        houses[i] == 0 ? cost[i][color - 1] : 0;

                for (int k = 1; k <= target; k++) {
                    for (int prevColor = 1;
                         prevColor <= n;
                         prevColor++) {

                        if (color == prevColor) {
                            dp[i][color][k] =
                                    Math.min(
                                            dp[i][color][k],
                                            dp[i - 1][prevColor][k]
                                                    + paintCost);
                        } else if (k > 1) {
                            dp[i][color][k] =
                                    Math.min(
                                            dp[i][color][k],
                                            dp[i - 1][prevColor][k - 1]
                                                    + paintCost);
                        }
                    }
                }
            }
        }

        int ans = INF;

        for (int color = 1; color <= n; color++) {
            ans = Math.min(ans,
                    dp[m - 1][color][target]);
        }

        return ans == INF ? -1 : ans;
    }
}