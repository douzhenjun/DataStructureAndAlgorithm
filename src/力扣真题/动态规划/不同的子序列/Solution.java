package 力扣真题.动态规划.不同的子序列;

/**
 * @Description
 * 定义dp[i][j]表示以s的第i个元素为末尾的序列中出现t的第j个元素为末尾的序列的个数
 * 或者说s包含t的情况下,s有多少种删除元素的方法(不删除也是一种方法),可以变成t.
 * 因为删除元素以后不会改变s中元素的相对顺序,所以称删除后的s1为s的子序列
 * @Author douzhenjun
 * @DATE 2024-03-11
 **/
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //如果t为空字符串,那么它一定是s中元素的子串,做了一个初始化
        //如果s为空字符串,那么除非t也是空字符串,否则t不可能是s的子序列,所以是0
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                //如果s[i-1]==t[j-1],那么t[0~j-1]在s[0~i-1]中出现的次数
                //等于t[0~j-2]在s[0~i-2]中出现的次数加上t[0~j-1]在s[0~i-2]中出现的次数
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
