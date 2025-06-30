package 力扣真题.动态规划.买卖股票的最佳时机.含手续费;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution {
    public int maxProfit(int[] prices, int fee){
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1 ;i < dp.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]-fee);
        }
        return dp[dp.length-1][1];
    }
}
