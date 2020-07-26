import java.awt.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        findUnique(nums,new ArrayList<Integer>(),res,new boolean[nums.length]);
        return res;
    }

    private void findUnique(int[] nums,List<Integer> track, List<List<Integer>> res, boolean [] visited){
        // 终止条件
        if (track.size() == nums.length){
            res.add(new ArrayList<Integer>(track));
            return;
        }
        // 遍历选择列表
        for (int i = 0; i < nums.length; i++){
            // 做选择前准备
            // if(visited[i]) continue;
            // if(i > 0 && nums[i] == nums[i-1] && visited[i - 1]) break;
            if(visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i - 1]) continue;
            // 做选择
            track.add(nums[i]);
            visited[i] = true;
            // drill down
            findUnique(nums, track, res, visited);
            // 撤销选择
            visited[i] = false; 
            track.remove(track.size() -1);
        }
    }
}
// @lc code=end

