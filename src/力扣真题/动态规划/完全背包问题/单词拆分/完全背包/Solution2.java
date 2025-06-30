package 力扣真题.动态规划.完全背包问题.单词拆分.完全背包;

import java.util.List;

/**
 * @Description
 * 这个例子主要表明不可以随便给定初始值，这里要求初始值为true
 * 
 * @Author douzhenjun
 * @DATE 2024-03-19
 **/
public class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = (wordDict.contains(String.valueOf(s.charAt(0))));//
        for (int j = 1; j < dp.length; j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && wordDict.contains(s.substring(i+1, j+1))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
