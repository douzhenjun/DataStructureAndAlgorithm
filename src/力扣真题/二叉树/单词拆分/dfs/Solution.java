package 力扣真题.二叉树.单词拆分.dfs;

import java.util.List;

/**
 * @Description 使用dfs来处理, 使用start作为深度的标记
 * 如果以第i位元素为最后的元素的s[0,i]能够被wordDict表示,并且s[i+1,j]包含于wordDict中,
 * 那么以第j为元素为最后的元素的s[0,j]能够被wordDict表示,类似于动态规划的递推公式
 * 但是这样会有大量重复的计算,会导致结果超时
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
