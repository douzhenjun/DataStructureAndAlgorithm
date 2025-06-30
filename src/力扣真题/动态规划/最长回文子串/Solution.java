package 力扣真题.动态规划.最长回文子串;

/**
 * @Description 定义二维数组dp[i][j]表示字符串[i, j]是否是回文串
 * @Author douzhenjun
 * @DATE 2024-03-11
 **/
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int[] index = new int[2];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                    if (dp[i][j] && j - i > maxLen) {
                        maxLen = j - i;
                        index[0] = i;
                        index[1] = j;
                    }
                }
            }
        }
        return s.substring(index[0], index[1] + 1);
    }
}
