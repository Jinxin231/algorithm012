import java.awt.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findPermute(nums, new ArrayList<Integer>(),res);
        return res;
    }


    private void findPermute(int[] nums,List<Integer> track,List<List<Integer>> res){
        // 终止条件
        if (track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        // 遍历选择列表
        for (int i = 0; i < nums.length; i++){
            if(track.contains(nums[i])) continue; // element already exists, skip
            // 做选择
            track.add(nums[i]);
            // drill down (注意未更改层数)
            findPermute(nums, track, res);
            // 撤回选择
            track.remove(track.size() - 1);
        }
    }
}
// @lc code=end

