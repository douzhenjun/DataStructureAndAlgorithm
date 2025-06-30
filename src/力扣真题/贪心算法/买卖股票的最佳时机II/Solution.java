package 力扣真题.贪心算法.买卖股票的最佳时机II;

/**
 * @Description
 * 从第二天开始,每天都有利润,只收集正利润
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 1; i < prices.length; i++){
            result += Math.max(prices[i] - prices[i-1], 0);
        }
        return result;
    }
}
