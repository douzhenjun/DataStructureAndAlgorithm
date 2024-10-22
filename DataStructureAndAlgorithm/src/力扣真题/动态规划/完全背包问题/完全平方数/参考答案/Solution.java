package 力扣真题.动态规划.完全背包问题.完全平方数.参考答案;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-07
 **/
public class Solution {
    // 版本一，先遍历物品, 再遍历背包
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                System.out.printf("%5d", dp[j]);
            }
            System.out.println();
        }
        
        return dp[n];
    }
}

