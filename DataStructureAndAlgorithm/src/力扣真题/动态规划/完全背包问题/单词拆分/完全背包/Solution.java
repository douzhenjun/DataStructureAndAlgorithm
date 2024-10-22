package 力扣真题.动态规划.完全背包问题.单词拆分.完全背包;

import java.util.List;

/**
 * @Description
 * dp[j] = true表示以字符串s的前j个元素的子串可以由wordDict中的元素表示。
 * 假设i<j: 如果dp[i]=true, 并且s[i,j-1]子串出现在字典里,那么dp[j]一定为true.
 * j的最大值应该是s.length(),所以背包的容量为s.length()+2
 * 初始化,dp[0]表示如果字符串为空的话,说明出现在字典里,完全是为了推导公式,
 * 下标非0的dp[i]初始化为false,只要没有被覆盖说明都是不可拆分成一个或多个字典中的单词
 * 递推公式
 * if(dp[i] && wordDicts.contains(s.substring(i,j))){(i<j)
 * dp[j] = true;
 * }
 * 确定遍历顺序,因为要求物品的组合要有一定的顺序才能够组成字符串arr,所以要先遍历背包再遍历物品
 * @Author douzhenjun
 * @DATE 2024-03-08
 **/
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;//字符串为空,没有意义,仅作为推导
        for (int j = 0; j < dp.length; j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
