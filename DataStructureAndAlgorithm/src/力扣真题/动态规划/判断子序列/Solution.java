package 力扣真题.动态规划.判断子序列;

/**
 * @Description dp[i][j]表示以下标i-1结尾的s的子串和以下标j-1结尾的t的子串,相同的子序列的长度
 * 只要判断在dp[s.length()][t.length()]是否等于s.length()就可以判断s是否是t的子串了
 * 以s.charAt(i-1)==t.charAt(j-1)是否成立为判断标准.
 * 如果成立,那就看s[0..i-2]与t[0..j-2]中的共同子序列长度,+1即可
 * 如果不成立,那就看s[0..i-1]与t[0..j-2]中的共同子序列长度
 * @Author douzhenjun
 * @DATE 2024-03-11
 **/
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                char c1 = s.charAt(i - 1);
                char c2 = t.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
