/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    /**
     * @param {type} char[][] board I am argument char[][] board.
     * @param {type} int i I am argument int i.
     * @param {type} int j I am argument int j.
     * @param {type} TrieNode p I am argument TrieNode p.
     * @param {type} List<String> res I am argument List<String> res.
     */
    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null)
            return;
        p = p.next[c - 'a'];
        if (p.word != null) { // found one
            res.add(p.word);
            p.word = null; // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0)
            dfs(board, i - 1, j, p, res);
        if (j > 0)
            dfs(board, i, j - 1, p, res);
        if (i < board.length - 1)
            dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1)
            dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    /**
     * @param {type} String[] words I am argument String[] words.
     */
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
// @lc code=end
