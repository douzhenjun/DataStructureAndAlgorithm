package 力扣真题.动态规划.买卖股票的最佳时机.有冷冻期;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-14
 **/
public class Solution2 {
    public int maxProfit(int[] prices){
        if(prices == null || prices.length < 2){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        //初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(dp[0][0], -prices[1]);//买入1的前一天不能有卖出,如果持有上一次的价格更低,那么就不买
        dp[1][1] = Math.max(dp[0][1], dp[0][0]+prices[1]);//卖出1要看是卖出1的价格更高还是上一次卖出0的价格更高
        
        for(int i = 2; i < dp.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-2][1]-prices[i]);//因为上一次卖出,冷冻期一天,所以只能多持有一天再买
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
