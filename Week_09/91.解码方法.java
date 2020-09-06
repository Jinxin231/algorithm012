/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */
// @lc code=start
class Solution {
    public int numDecodings(String s) {
        // The basic concept is to build up the number of ways to get to state i from
        // all the previous states less than i.
        // We can do this by initializing a cache with a size of s.length() + 1.
        // We always set waysToDecode[0] to 1 because there is only 1 way to decode an
        // empty string.
        // We can then build up the number of ways to decode starting from the first
        // value and work our way to the end.
        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;
        // r2: decode ways of s[i-2] , r1: decode ways of s[i-1]
        int r1 = 1, r2 = 1;

        for (int i = 1; i < s.length(); i++) {
            // zero voids ways of the last because zero cannot be used separately
            if (s.charAt(i) == '0')
                r1 = 0;

            // possible two-digit letter, so new r1 is sum of both while new r2 is the old
            // r1
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                r1 = r2 + r1;
                r2 = r1 - r2;
            }
            // one-digit letter, no new way added
            else {
                r2 = r1;
            }
        }

        return r1;
    }
}
// @lc code=end
