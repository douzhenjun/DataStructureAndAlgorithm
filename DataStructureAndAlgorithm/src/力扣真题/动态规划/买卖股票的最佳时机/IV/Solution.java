package 力扣真题.动态规划.买卖股票的最佳时机.IV;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution {
    public int maxProfit(int k, int[] prices){
        if(prices.length == 0){
            return 0;
        }
        
        int len = prices.length;
        int[][] dp = new int[len][k*2];//偶数表示持有,奇数表示不持有
        
        //初始化第1,2,...,k次持有股票的情况
        for(int i = 0; i < k*2; i += 2){
            dp[0][i] = -prices[0];
        }
        for(int i = 1; i < len; i++){
            for(int j = 0; j < k*2-1; j += 2){
                if(j == 0){
                    dp[i][j] = Math.max(dp[i-1][j], -prices[i]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]-prices[i]);//表示买入,要么是上一次买入的最大值,要么是这一次买入的利润(=上一次卖出的利润-这一次买入的价格)
                }
                dp[i][j+1] = Math.max(dp[i-1][j+1], dp[i-1][j]+prices[i]);//表示卖出,要么是上一次卖出的最大值,要么是这一次卖出的利润(=上一次买入的利润+这一次卖出的价格)
            }
        }
        return dp[len-1][k*2-1];
    }
}
