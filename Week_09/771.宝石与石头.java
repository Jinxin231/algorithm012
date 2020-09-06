import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */
// @lc code=start
class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null && J.length() == 0) {
            return 0;
        }

        int reuslt = 0;
        char[] chs = S.toCharArray();
        // 因为最大差值：'z' - 'A' = 57，所以长度为 58。又因为 S、J 最多含有 50 个字母，所以 byte 类型足矣存储 J 在 S
        // 中出现的最多次数，即 50
        byte[] b = new byte[58];

        for (char ch : chs) {
            b[ch - 'A']++;
        }

        chs = J.toCharArray();
        for (char ch : chs) {
            reuslt += b[ch - 'A'];
        }
        return reuslt;
    }
}
// @lc code=end
