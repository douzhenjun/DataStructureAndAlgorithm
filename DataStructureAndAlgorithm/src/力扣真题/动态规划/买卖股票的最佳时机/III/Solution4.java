package 力扣真题.动态规划.买卖股票的最佳时机.III;

/**
 * @Description 定义dp[i][j][k]表示第i天交易结束后, 最多进行k次交易(第k次卖出)所获得的最大的利润, k要么是0表示没有股票, 要么是1表示手里有股票
 * @Author douzhenjun
 * @DATE 2024-07-02
 **/
public class Solution4 {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][3][2];
        dp[0][0][0] = 0;            //第一天没有进行任何买卖
        dp[0][0][1] = -prices[0];   //第一天买入一只股票
        dp[0][1][0] = Integer.MIN_VALUE / 2;//下面四种情况不可能发生,所以定义一个初始值即可
        dp[0][1][1] = Integer.MIN_VALUE / 2;
        dp[0][2][0] = Integer.MIN_VALUE / 2;
        dp[0][2][1] = Integer.MIN_VALUE / 2;
        for (int i = 1; i < prices.length; i++) {
            dp[i][1][0] = Math.max(dp[i - 1][0][1] + prices[i], dp[i - 1][1][0]);//第i天不持有股票最多进行一次交易所获得的最大利润有两种情况,要么不买入新的股票,保持前一天的最大利润,要么卖出上一次的股票
            dp[i][0][1] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][0][1]);//第i天持有股票最多进行一次交易所获的最大利润:要么保持现状不卖出,要么上一次不持有股票的最好利润加上这一次的股票买入
            dp[i][2][0] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][2][0]);
            dp[i][1][1] = Math.max(dp[i - 1][1][0] - prices[i], dp[i - 1][1][1]);
        }
        //最多进行k次交易的最大利润一定是卖出的时候,因为买入一定不如不买入利润高,所以比较进行1次交易,2次交易,不交易的最大值.
        return Math.max(dp[prices.length - 1][0][0], Math.max(dp[prices.length - 1][1][0], dp[prices.length - 1][2][0]));
    }
}
