/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char c = s[l];
            s[l++] = s[r];
            s[r--] = c;
        }
    }
}
// @lc code=end
