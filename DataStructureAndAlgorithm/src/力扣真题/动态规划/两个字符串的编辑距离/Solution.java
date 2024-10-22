package 力扣真题.动态规划.两个字符串的编辑距离;

/**
 * @Description
 * 定义dp[i][j]表示以word1第i-1个元素为结尾的字符串和以word2第j-1个元素为结尾的字符串之间的编辑距离
 * 编辑距离指的是从s1变到s2所经过的最小的操作数
 * 操作有三种,新增一个字符,删除一个字符,替换一个字符
 * 考虑dp[i][j]的递推公式:
 * 考虑s1.charAt(i-1)和s2.charAt(j-1)是否相等?
 *  若相等, 则不需要操作,dp[i][j]=dp[i-1][j-1]
 *  若不相等, 则存在以下几种情况:
 *      a.字符串s1和s2相比少了一个字符,那就是s1到达s2-s2[-1]的编辑距离+1(s1新增s2[-1])
 *      b.字符串s1比s2多了一个字符,那就是s2到达s1-s1[-1]的编辑距离+1(s2新增s1[-1])
 *      c.字符串s1和s2长度相等,那么就看s1/-1,s2/-1之间的编辑距离,然后将s1[-1]替换成s2[-1]即可
 *    分别对应的操作数为dp[i][j-1]+1,dp[i-1][j]+1,dp[i-1][j-1]+1,取最小的那个
 *  所以递推公式总结如下:
 *      if(s1.charAt(i-1)==s2.charAt(j-1)){
 *          dp[i][j] = dp[i-1][j-1];
 *      }else{
 *          dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1])+1;
 *      }
 *  初始化dp[0][j]=j,dp[i][0]=i;
 *  遍历顺序从前到后,从上到下
 * @Author douzhenjun
 * @DATE 2024-03-11
 **/
public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i < len1+1; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j < len2+1; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i < len1+1; i++){
            for(int j = 1; j < len2+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
