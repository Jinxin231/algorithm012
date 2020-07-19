/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) != i) {
                    return new int[] { map.get(nums[i]), i };
                }
            }
        }
        return new int[2];
    }
}
// @lc code=end

