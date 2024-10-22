package 力扣真题.动态规划.完全背包问题.完全平方数.参考答案;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-14
 **/
public class Solution2 {
    //先遍历背包,再遍历物品
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (dp[i - j * j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }
}
