package 力扣真题.动态规划.完全背包问题.爬楼梯;

/**
 * @Description
 * 原题目是给定m,n,如果最多可以爬[1,2,...,m](m<n)个楼梯,问有多少种方法可以到达楼顶?
 * 该问题可以转化为完全背包问题,并且是完全背包的排列问题,因为物品放入的顺序不同,结果不同.
 * dp[j]表示向容量为j的背包存入1,2,...,m这些数,使得这些数的和为j的组合数.
 * dp[0]=1
 * dp[j]=dp[j]+dp[j-nums[i]]
 * 遍历顺序是先遍历背包容量,再遍历数1,2,...,m.
 * @Author douzhenjun
 * @DATE 2024-03-07
 **/
public class Solution {
    public int findStepWays(int m, int n){
        if(m >= n){
            return -1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int j = 1; j < n+1; j++){
            for(int i = 1; i < m+1; i++){
                if(j >= i){
                    dp[j] += dp[j-i];
                }
            }
        }
        return dp[n];
    }
}
