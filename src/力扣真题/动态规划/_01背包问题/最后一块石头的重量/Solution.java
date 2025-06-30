package 力扣真题.动态规划._01背包问题.最后一块石头的重量;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-05
 **/
public class Solution {

    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;//向下取整
        //定义一个二维数组,dp[i][j]表示向容量为j的背包装入stone[0]~stone[i]中的任意数,使得总重量最大
        //其中weight[i]=nums[i], value[i]=nums[i]
        int[][] dp = new int[stones.length][target + 1];
        //初始化dp
        for (int j = 0; j < target + 1; j++) {
            if (stones[0] <= j) {
                dp[0][j] = stones[0];
            }
        }
        //利用递推公式完善dp
        for (int i = 1; i < stones.length; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (stones[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }
        //获得动态规划的最优解:当前重量和的一半的背包所能装下的最大的石头重量
        int maxWeight = dp[stones.length - 1][target];
        //剩余重量,这个剩余重量一定大于等于最优解
        int remainWeight = sum - maxWeight;
        return remainWeight - maxWeight;
    }
}

