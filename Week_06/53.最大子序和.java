/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {

        // dp[i]代表nums总第i个元素可以达到的最大之序和
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];

        // dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
// @lc code=end
