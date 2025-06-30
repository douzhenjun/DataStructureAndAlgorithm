package 力扣真题.二叉树.单词拆分.dp;

import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-12-13
 **/
public class Solution2 {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
