import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    // 返回结果
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        findCombinations(n, k, 1, new Stack<>());
        return res;
    }

    private void findCombinations(int n, int k, int begin, Stack<Integer> pre) {
        // 终止条件
        if (pre.size() == k) {
            // 够数了，就添加到结果集中
            res.add(new ArrayList<>(pre));
            return;
        }
        // 逐渐往下层探寻合适的项（选择列表）
        for (int i = begin; i <= n; i++) {
            // 做选择
            pre.add(i);
            // drill down
            findCombinations(n, k, i + 1, pre);
            // 撤销选择
            pre.pop();
        }
    }

}
// @lc code=end
