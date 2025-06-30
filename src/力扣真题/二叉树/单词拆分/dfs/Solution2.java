package 力扣真题.二叉树.单词拆分.dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description 去掉重复的递归
 * @Author douzhenjun
 * @DATE 2025-02-05
 **/
public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashSet<>(),0);
    }

    public boolean dfs(String s, List<String> wordDict, Set<Integer> indexSet, int start) {
        //字符串都拆分完了,返回true
        if (start == s.length()) {
            return true;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            //如果已经判断过了,就直接跳过,防止重复的判断
            if(indexSet.contains(i)){
                continue;
            }
            if (wordDict.contains(s.substring(start, i))) {
                if (dfs(s, wordDict, indexSet, i)) {
                    return true;
                }
                //标记为已判断过
                indexSet.add(i);
            }
        }
        return false;
    }
}
