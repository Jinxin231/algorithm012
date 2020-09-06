/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
 * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
 * 3, If p.charAt(j) == '*': 
 *   here are two sub conditions:
 *               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
 *               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
 *                             dp[i][j] = dp[i-1][j]   // in this case, a* counts as multiple a 
 *                          or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
 *                          or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
 */

// @lc code=start
class Solution {
    /**
     * @param {type} String s I am argument String s.
     * @param {type} String p I am argument String p.
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // "."场景和普通字符场景
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = match(s, p, i, j) ? dp[i - 1][j - 1] : false;
                } else {
                    dp[i][j] = match(s, p, i, j - 1) ? (dp[i][j - 2] || dp[i - 1][j]) : dp[i][j - 2];
                }
            }
        }
        return dp[m][n];

    }

    /**
     * @param {type} 字符串S
     * @param {type} 匹配串P
     * @param {type} S当前匹配位置---i.
     * @param {type} P当前匹配位置---j.
     */
    public boolean match(String s, String p, int i, int j) {
        if (i == 0)
            return false;
        if (p.charAt(j - 1) == '.')
            return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
// @lc code=end
