package 力扣真题.动态规划.买卖股票的最佳时机.III;

/**
 * @Description
 * 定义dp[i][j]表示股票在第i天买入或卖出产生的最大利润
 *  j=1,2,3,4, 分别表示第一次买入,第一次卖出,第二次买入,第二次卖出
 *  初始化dp[0][0]=0,dp[0][1]=-prices[0];
 *  dp[0][2]表示第一次卖出,因为没有买入过,所以初始化为0,相当于不操作
 *  dp[0][3]表示第二次买入,因为第二次买入依赖第一次卖出,相当于在第一次卖出的基础上减去prices[0],
 *  所以dp[0][3]=-prices[0]
 *  dp[0][4]=0
 *  递推公式:
 *  遍历顺序从前到后,dp[i][1]
 *  
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution {
    public int maxProfit(int[] prices){
        int len = prices.length;
        if(prices.length == 0){
            return 0;
        }
        //定义4种状态 0: 第一次买入, 1: 第一次卖出, 2: 第二次买入, 3: 第二次卖出
        int[][] dp = new int[len][4];
        //初始化第一次买入和第二次买入的dp
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);//第一次买入
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);//第一次卖出
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]-prices[i]);//第二次买入
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2]+prices[i]);
        }
        return dp[len-1][3];
    }
}
