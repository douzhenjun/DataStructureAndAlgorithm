package 力扣真题.动态规划.买卖股票的最佳时机.有冷冻期;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution {
    public int maxProfit(int[] prices){
        if(prices == null || prices.length < 2){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1]+prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        
        for(int i = 2; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
        }
        
        return dp[prices.length-1][0];
    }
    
}
