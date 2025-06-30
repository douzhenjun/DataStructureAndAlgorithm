package 力扣真题.动态规划.买卖股票的最佳时机.III;

/**
 * @Description
 * Solution2的算法时间复杂度为k*n^2,其中k表示做多交易k次,n表示prices数组的长度
 * 需要想办法降低这个时间复杂度,从上面得知做了三次循环,其中最内层循环是对所以天数小于j的dp[i-1][k]+prices[j]-prices[k]寻找其中最大的那一个,内层循环的结果再和dp[i][j-1]做比较
 * 这个可以优化,其实我们可以将第j天之前第i-1次交易后的最大利润保存在dp[i-1][j-1]中,也就是前一天,那么第二天的最大利润也就是Math.max(dp[i-1][j-1]+prices[j],dp[i][j-1])了.
 * @Author douzhenjun
 * @DATE 2024-07-02
 **/
public class Solution3 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[3][prices.length];
        //为什么i从1开始,因为没有交易的情况下利润最大为0,所以不用考虑
        for (int i = 1; i <= 2; i++) {
            int max = Integer.MIN_VALUE / 2;
            //为什么j从1开始,因为要考虑j-1的情况,防止越界,如果第j天卖出股票,第j天的最大利润等于第j-1天的最大利润加上prices[j]-prices[j-1].
            //如果第j天不卖出股票,第j天的最大利润就等于第j-1的最大利润.
            for (int j = 1; j < prices.length; j++) {
                //记录前j-1天买一只股票的最大利润
                max = Math.max(max, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
            }
        }
        return dp[2][prices.length - 1];
    }
}
