/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int nonezero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonezero] = nums[i];

                if (nonezero < i) {
                    nums[i] = 0;
                }
                nonezero++;
            }
        }

    }
}
// @lc code=end
