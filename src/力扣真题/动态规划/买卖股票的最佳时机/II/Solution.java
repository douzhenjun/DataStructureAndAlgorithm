package 力扣真题.动态规划.买卖股票的最佳时机.II;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description dp[i]表示出售prices[i]所能收获的最大利润, 这时候可以多次买卖一只股票
 * 第i只股票要么不卖,要么卖,如果不卖,那么dp[i] = dp[i-1]
 * 如果卖,那么dp[i] = prices[i]-prices[j]+dp[j-1],j<i,且prices[i]>prices[j]
 * 初始值dp[0]=0, maxValue=0
 * 每次计算maxValue = Math.max(maxValue, prices[i]-prices[j]+dp[j-1])
 * 再将结果和dp[i-1]比较, dp[i] = Math.max(maxValue, dp[i-1]);
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        for (int i = 1; i < dp.length; i++) {
            int saleIMaxProfit = 0;
            for (int j = i - 1; j >= 0 && prices[i] > prices[j]; j--) {
                if (j >= 1) {
                    saleIMaxProfit = Math.max(saleIMaxProfit, prices[i] - prices[j] + dp[j - 1]);
                } else {
                    saleIMaxProfit = Math.max(saleIMaxProfit, prices[i] - prices[j]);
                }
            }
            dp[i] = Math.max(dp[i - 1], saleIMaxProfit);
        }
        return dp[prices.length - 1];
    }
}
