package 力扣真题.动态规划.最长回文子序列;

/**
 * @Description
 * 定义dp[i][j]表示字符串s[i..j]的子串中的最长回文子序列的长度.
 * 考虑s[i]==s[j]时,它等于dp[i+1][j-1]+2.
 * 如果s[i]!=s[j],那么也就是加上这两个元素并不能增加回文串的长度2,这里存在三种情况:
 *      a.s[i]增加了s[i+1..j]的回文串长度
 *      b.s[j]增加了s[i..j-1]的回文串长度
 *      c.s[i]或s[j]增加了s[i+1,j-1]的回文串长度
 *     所以最终结果是这三个之间的最大值+1
 * 总结:
 * if(s[i]==s[j]){
 *     dp[i][j] = dp[i+1][j-1]+2;
 * }else{
 *     dp[i][j] = Math.max(dp[i-1][j+1], Math.max(dp[i+1,j],dp[i,j-1]))+1;
 * }
 * 需要注意因为从上面来看i和j是不可以相等的,否则dp[i+1][j-1]就没有意义了,这样一来就需要对i==j的情况初始化
 * @Author douzhenjun
 * @DATE 2024-03-11
 **/
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) { // 从后往前遍历 保证情况不漏
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }
}
