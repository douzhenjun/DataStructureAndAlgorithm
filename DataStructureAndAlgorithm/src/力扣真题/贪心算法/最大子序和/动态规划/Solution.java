package 力扣真题.贪心算法.最大子序和.动态规划;

/**
 * @Description
 * 定义dp[i]表示以nums[i]为末尾的最大连续子数组的和
 * 拓展,如果让你返回这个子数组应该怎么办呢?
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for(int i = 1; i < dp.length; i++){
            if(dp[i-1] <= 0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i-1]+nums[i];
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
