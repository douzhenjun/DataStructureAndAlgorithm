package 力扣真题.二叉树.单词拆分.dfs;

import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-12-13
 **/
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    public boolean dfs(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (!wordDict.contains(s.substring(start, i))) {
                continue;
            }
            if (dfs(s, wordDict, i)) {
                return true;
            }
        }
        return false;
    }
}
