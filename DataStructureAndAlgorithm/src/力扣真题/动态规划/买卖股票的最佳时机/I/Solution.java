package 力扣真题.动态规划.买卖股票的最佳时机.I;

/**
 * @Description
 * 定义dp,dp[i]表示在prices[0~i]数组中卖出prices[i]所产生的最大利润
 * 相当于比较dp[i-1]和prices[i]-minValue, minValue为前面prices[0~i]数组中的最小值,初始值为prices[0].
 * 最后返回dp[prices.length-1]即可.
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution {
    public int maxProfit(int[] prices){
        int minValue = prices[0];
        int[] dp = new int[prices.length];
        for(int i = 1; i < dp.length; i++){
            minValue = Math.min(minValue, prices[i]);
            dp[i] = Math.max(dp[i-1], prices[i] - minValue);
        }
        return dp[prices.length-1];
    }
}
