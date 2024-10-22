package 力扣真题.动态规划.回文子串;

/**
 * @Description 考虑dp[i][j]表示字符串s的第[i, j]位置的元素是否是回文串?
 * 如果s[i]==s[j],那么有几种情况
 * a.j-i<=1,这时候一定是回文子串,比如"a","aa"
 * b.j-i>1,那么这时候就看dp[i+1][j-1]是否是回文子串了
 * 如果s[i]!=s[j],那么一定不是回文子串,返回false
 * 遍历顺序
 * 从结果来看,dp[i][j]是否是回文串取决于dp[i+1][j-1]是否是回文串,所以遍历顺序是从下到上的,从前到后的
 * 初始化因为是从下到上,从前到后,并且j>=i一定成立,所以初始化dp[len-1][len-1]=true,因为单个字符串一定是回文
 * 当然这里也可以不用初始化,因为根据上面的判断,这也是包含在递推公式的情况之中的.
 * 最后定义一个result,每遇到一个回文子串,result++
 * @Author douzhenjun
 * @DATE 2024-03-11
 **/
public class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
}
