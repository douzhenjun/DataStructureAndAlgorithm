package 力扣真题.动态规划._01背包问题.分割等和子集;

import java.util.Arrays;

/**
 * @Description
 * 这个问题可以套用01背包问题,其目的在于找到数组中的一些数,使得这些数的和为sum/2, sum为数组中元素的总和.
 * 定义二维数组dp[i][j]用来表示前i个元素放入容量为j的背包中,是否恰好达到背包的最大容量j.
 * 所以可以令列j从0到sum/2,i从0到nums.length-1.
 * 初始化,对于第一行也就是nums[0]是否可以放入容量为j的背包中,很显然j=nums[0]时必为true,其他均为false;
 * 然后对行遍历,行内对列遍历.
 * 对于dp[i][j]来说, 如果存在nums[i]==j,这里dp[i][j]必为true,且可以跳过j的遍历了
 * 如果nums[i] > j, 这说明nums[i]是不能放入背包中的,那么只能从nums[i]之前的元素中判断是否存在dp[i-1][j]=true了
 * 所以dp[i][j] = dp[i-1][j];
 * 如果nums[i] < j, 这说明nums[i]是可以放入背包中的, 这就存在放入和不放入的问题, 如果不放入也就是看
 * dp[i-1][j]是否为true;如果放入,那么看nums[0~i-1]是否恰好能塞满容量为j-nums[i]的背包.
 * @Author douzhenjun
 * @DATE 2024-03-04
 **/
public class Solution {
    public boolean canPartition(int[] nums){
        Arrays.sort(nums);//做自然排序
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target+1];
        
        if(nums[0] <= target){
            dp[0][nums[0]] = true;//第一个数恰好被容量为nums[0]的背包所装满,其他都不行
        }
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 1; j <= target; j++){
                //先直接将上一行的结果抄下来
                dp[i][j] = dp[i-1][j];
                //如果某个物品的重量恰好等于背包的容量,那么直接放入nums[i]即可,结果为true
                if(nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }
                //如果物品i的重量小于背包的容量,考虑两种情况,放入和不放入
                //1.如果不放入nums[i],那么就看前i-1个元素是否能够装满背包也就是nums[i-1][j]
                //2.如果放入nums[i],那么放入之前应该存在前i-1个元素能够装满容量为j-nums[i]的背包
                if(nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[dp.length-1][target];
    }
}
