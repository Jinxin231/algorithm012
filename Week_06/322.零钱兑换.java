/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 * dp[11] = min (dp[10] + 1, dp[9] + 1, dp[6] + 1)
 */
// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int[] minNumber = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            minNumber[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE)
                    minNumber[i] = Math.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
        }
        return minNumber[amount] == Integer.MAX_VALUE ? -1 : minNumber[amount];
    }
}
// @lc code=end
