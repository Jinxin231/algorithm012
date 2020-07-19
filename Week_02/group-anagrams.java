import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();

        for (int i = 0;i < strs.length; i++){
            char[] sortChar = strs[i].toCharArray();
            Arrays.sort(sortChar);
            String tempkey = String.valueOf(sortChar);
            List<String> myList = hash.getOrDefault(tempkey, new ArrayList<String>());
            myList.add(strs[i]);
            hash.put(tempkey, myList);
        }
        return new ArrayList<List<String>>(hash.values());
    }
}
// @lc code=end

