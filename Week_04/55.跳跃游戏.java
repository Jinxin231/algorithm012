/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i != nums.length - 1) {
                if (passZore(i, nums)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean passZore(int index, int[] nums) {
        for (int i = index; i >= 1; i--) {
            if (nums[i - 1] - (index - i + 1) > 0)
                return true;
        }
        return false;
    }
}
// @lc code=end
