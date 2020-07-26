import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    /*
     * start -- 当前递归层级
     * nums  -- 目标集合
     * tempList -- 记录路径
     * list   -- 返回结果
     */
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        // 记录选择
        list.add(new ArrayList<>(tempList));
        // 遍历选择列表
        for(int i = start; i < nums.length; i++){
            // 做选择
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            // 取消选择
            tempList.remove(tempList.size() - 1);
        }
    }
}
// @lc code=end
