/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        // (p - 1) * (n + 1) + 1
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots = idle_slots - Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}
// @lc code=end
