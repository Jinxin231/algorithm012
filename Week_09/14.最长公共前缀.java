/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        int i = 0, len = Math.min(first.length, last.length);
        while (i < len && first[i] == last[i])
            i++;
        return strs[0].substring(0, i);
    }
}
// @lc code=end
