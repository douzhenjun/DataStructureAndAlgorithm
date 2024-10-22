package od真题.总览._42字符串序列判定;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-25
 **/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String l = scanner.nextLine();
        System.out.println(getResult(s, l));
    }
    
    @Test
    public void test01(){
        String s= "ace";
        String l = "abcde";
        System.out.println(getResult(s, l));
        s = "fgh";
        l = "abcde";
        System.out.println(getResult(s, l));
    }

    private static int getResult(String s, String l) {
        if (l.length() == 0 || s.length() == 0) {
            return -1;
        }
        if (s.length() > l.length()) {
            return -1;
        }
        //以s[i]为末尾的子串与l[j]为末尾的子串所具有的最长公共子序列长度
        //如果dp[m][n] == m+1, 说明s是l的子序列
        int m = s.length();
        int n = l.length();
        int[][] dp = new int[m + 1][n + 1];

        int lastIndex = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == l.charAt(j-1)) {
                    if (i == m) {
                        lastIndex = j - 1;
                    }
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        //如果这个最大的子序列长度恰好等于s的长度,说明s是l的子序列
        if (dp[m][n] == m) {
            return lastIndex;
        }
        return -1;
    }
}
