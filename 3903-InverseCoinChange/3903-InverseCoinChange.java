// Last updated: 7/9/2026, 3:06:27 PM
import java.util.*;

class Solution {

    public List<Integer> findCoins(int[] numWays) {

        int n = numWays.length;
        long[] dp = new long[n + 1];
        dp[0] = 1;

        List<Integer> coins = new ArrayList<>();

        for (int coin = 1; coin <= n; coin++) {

            long[] temp = dp.clone();

            for (int i = coin; i <= n; i++) {
                temp[i] += temp[i - coin];
            }

            boolean valid = true;

            for (int i = 1; i <= n; i++) {
                if (temp[i] > numWays[i - 1]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                dp = temp;
                coins.add(coin);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] != numWays[i - 1]) {
                return new ArrayList<>();
            }
        }

        return coins;
    }
}