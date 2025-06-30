package 力扣真题.动态规划.完全背包问题.零钱兑换;

import java.util.Arrays;

/**
 * @Description 采用二维数组的方式来做一下
 * 
 * dp[i][j]=Math.min(dp[i-1][j],dp[i][j-nums[i]]+1),i=0,1,2,...,
 * i=0时,dp[i-1][j]=MAX_VALUE;
 * @Author douzhenjun
 * @DATE 2024-03-07
 **/
public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        int maxValue = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i], maxValue);
        }
        //初始化
        dp[0][0] = 0;
        for(int j = coins[0]; j < amount+1; j++){
            if(dp[0][j-coins[0]] != maxValue){
                dp[0][j] = dp[0][j-coins[0]] + 1;
            }
        }
        //逐层遍历
        for(int i = 1; i < coins.length; i++){
            for(int j = 0; j < amount+1; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= coins[i] && dp[i][j-coins[i]] != maxValue){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i]]+1);
                }
            }
        }
        if(dp[coins.length-1][amount] == maxValue){
            return -1;
        }
        return dp[coins.length-1][amount];
    }
}
