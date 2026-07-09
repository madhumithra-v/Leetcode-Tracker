// Last updated: 7/9/2026, 3:06:29 PM
import java.util.*;

class Solution {

    public long minCost(int n, int[][] cost) {

        Long[][][] dp = new Long[n / 2][4][4];

        return solve(cost, 0, 3, 3, dp);
    }

    private long solve(int[][] cost,
                       int i,
                       int prevLeft,
                       int prevRight,
                       Long[][][] dp) {

        if (i == cost.length / 2) {
            return 0;
        }

        if (dp[i][prevLeft][prevRight] != null) {
            return dp[i][prevLeft][prevRight];
        }

        long ans = Long.MAX_VALUE;

        for (int leftColor = 0; leftColor < 3; leftColor++) {

            if (leftColor == prevLeft) {
                continue;
            }

            for (int rightColor = 0; rightColor < 3; rightColor++) {

                if (rightColor == prevRight) {
                    continue;
                }

                // Mirror houses cannot have same color
                if (leftColor == rightColor) {
                    continue;
                }

                long currentCost =
                        cost[i][leftColor]
                      + cost[cost.length - 1 - i][rightColor];

                ans = Math.min(
                        ans,
                        currentCost + solve(
                                cost,
                                i + 1,
                                leftColor,
                                rightColor,
                                dp
                        )
                );
            }
        }

        return dp[i][prevLeft][prevRight] = ans;
    }
}