package 力扣真题.动态规划.买卖股票的最佳时机.II;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];//买入
        dp[0][1] = 0;//卖出
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);//如果上一次持有的价格更低,那么就继续持有,否则,买入这一次的股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);//如果上一次卖出的价格更高,那么就继续持有,否则,卖出这一次的股票
        }
        return dp[len - 1][1];
    }
}
