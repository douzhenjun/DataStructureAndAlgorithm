package 力扣真题.动态规划.完全背包问题.零钱兑换;

import java.util.Arrays;

/**
 * @Description
 * 定义一维数组dp[j]表示满足总金额为j的最少硬币个数,如果没有任何一种硬币组合能够组成总金额,返回-1
 * 定义i遍历coins数组,
 * 初始化,i=0时,dp[coins[0]]=1,dp[0]=1;
 * 对于任何i,dp[j]=Math.min(dp[j],dp[j-coins[i]]+1)
 * 是这样的,首先前i-1个硬币组合的dp[j]比较好理解
 * 当需要加入硬币i的时候,假设是最少的,那么在加入硬币i之前,它也一定是满足j-k*coins[i]中最少的
 * 所以dp[j]=Math.min(dp[j],dp[j-coins[i]]+1,dp[j-2coins[i]]+2,...,dp[0]+j/coins[i]),从第二项开始
 * 这些项对应的是未更新的i-1行的数据
 * 而因为dp[j-coins[i]]=Math.min(dp[j-coins[i]],dp[j-2coins[i]]+1,dp[j-3coins[i]]+2,...,dp[0]+j/coins[i]-1),
 * 所以Math.min(dp[j-coins[i]]+1,dp[j-2coins[i]]+2,...,dp[0]+j/coins[i])=dp[j-coins[i]]+1
 * 所以上式两边再加上dp[j],就变成了dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);并且dp[j-coins[i]]+1对应的是第i行的数据
 * @Author douzhenjun
 * @DATE 2024-03-07
 **/
public class Solution {
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j < amount+1; j++){
                if(dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}
