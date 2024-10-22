package 力扣真题.动态规划.买卖股票的最佳时机.III;

/**
 * @Description 
 * 定义dp[i][j]为第j天结束后最多i次交易产生的最大的利润
 * 显然可以选择不交易,那么dp[i][j] = dp[i][j-1];
 * 也可以选择交易,那么dp[i][j] = dp[i-1][k-1] + prices[j] - prices[k](k < j);
 * 其中prices[j]-prices[k]表示在第k天买入一只股票,然后在第j天卖掉所得的利润.
 * dp[i-1][k-1]表示在前k-1天最多进行i-1次交易所获得的最大的利润.
 * 因此dp[i][j] = Math.max(dp[i][j-1], dp[i-1][k-1] + prices[j] - prices[k]);
 * @Author douzhenjun
 * @DATE 2024-07-02
 **/
public class Solution2 {
    public int maxProfit(int[] prices){
        int[][] dp = new int[3][prices.length];
        for(int i = 1; i <= 2; i++){
            for(int j = 1; j < prices.length; j++){
                for(int k = j - 1; k >= 0; k--){
                    int max = 0;
                    //k=0表示在第一天买入,第j天卖出,这种情况下我们只能进行一次股票交易,所以不需要dp[i-1][k-1]
                    if(k == 0){
                        max = Math.max(dp[i][j - 1], prices[j] - prices[k]);
                    }else{
                        //要么第j天不进行任何操作,要么第j天卖出一只股票.
                        max = Math.max(dp[i][j - 1], prices[j] - prices[k] + dp[i - 1][k - 1]);
                    }
                    dp[i][j] = Math.max(dp[i][j], max);
                }
            }
        }
        return dp[2][prices.length - 1];
    }
}
