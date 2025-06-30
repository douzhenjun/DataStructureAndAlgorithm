package 华为面试模拟题.最长公共子串;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class Solution {
    public int findMaxLength(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int res = 0;//结果
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                if(dp[i][j] > res){
                    res = dp[i][j];
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%2d", dp[i][j]);
            }
            System.out.println();
        }
        return res;
    }
}
