package 力扣真题.回溯.单词拆分II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-08-11
 **/
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        traceback(s, set, 0, res, new ArrayList<>());
        return res;
    }

    private void traceback(String s, Set<String> wordDict, int start, List<String> res, List<String> path) {
        if (start == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (!wordDict.contains(str)) {
                continue;
            }
            path.add(str);
            traceback(s, wordDict, i, res, path);
            path.remove(path.size() - 1);
        }
    }
}
