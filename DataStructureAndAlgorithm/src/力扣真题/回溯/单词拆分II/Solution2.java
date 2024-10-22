package 力扣真题.回溯.单词拆分II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-08-19
 **/
public class Solution2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtrack(s, new HashSet<>(wordDict), 0);
    }

    public List<String> backtrack(String s, Set<String> wordDict, int start) {
        List<String> res = new ArrayList<>();
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (!wordDict.contains(str)) {
                continue;
            }
            if (i == s.length()) {
                res.add(str);
            } else {
                List<String> remainRes = backtrack(s, wordDict, i);
                for (String remainStr : remainRes) {
                    res.add(str + " " + remainStr);
                }
            }
        }
        return res;
    }
}
