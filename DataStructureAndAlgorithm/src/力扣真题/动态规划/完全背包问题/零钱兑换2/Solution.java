package 力扣真题.动态规划.完全背包问题.零钱兑换2;

import java.util.Arrays;

/**
 * @Description
 * 定义dp[j]表示总金额为j,存在的硬币组合的最大数. i=0,1,2,...,coins.length-1
 * 初始化dp[j],i=0时,也就是coins[0]总金额为j的情况下能够产生的最大组合数,显然dp[[coins[0]]=1,其他置0.
 * 研究递推公式,
 * 假设对于总金额为j的最大硬币数组合为D(j),
 * 
 * 则D(j)=D(j-1)*D(1)+D(j-2)*D(2)+...+D(j/2)*D(j/2)
 * (如果j为奇数,则D(j)=D(j-1)*D(1)+D(j-2)*D(2)+...+D(j/2)*D(j/2+1)
 * 所以dp[j] += dp[j-i]*dp[i](0<i<=j/2)
 * @Author douzhenjun
 * @DATE 2024-03-06
 **/
public class Solution {
    
    public static int change(int amount, int[] coins){
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                dp[j] += dp[j-coins[i]];
            }
            //打印
            for(int k = 0; k <= amount; k++){
                System.out.printf("%2d", dp[k]);
            }
            System.out.println();
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        change(amount, coins);
//        System.out.println(change(amount, coins));
    }
}
