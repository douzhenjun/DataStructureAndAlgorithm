package 力扣真题.二叉树.单词拆分.dp;

import java.util.List;

/**
 * @Description 
 * 定义dp[i]为字符串的以第i个字符为结尾(不包含)的字符子串可以由wordDict中的单词所表示
 * dp[0]=true
 * i=1到s.length();dp[i]=dp[j] && wordDict.contains(s.substring(j,i)),j=0,1,...,i-1
 * @Author douzhenjun
 * @DATE 2024-12-12
 **/
public class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    if (dict.contains(s.substring(0, i))) {
                        dp[i] = true;
                        continue;
                    }
                }
                //递推公式
                dp[i] = dp[i - j] && dict.contains(s.substring(i - j, i));
                //如果dp[i]为true，说明前i个字符串结果拆解可以让它的所有子串
                //都存在于字典wordDict中，直接终止内层循环，不用再计算dp[i]了
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
