package 力扣真题.动态规划.最大子序和;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-11
 **/
public class Solution {
    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1; i < dp.length; i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1]+nums[i];
            }else{
                dp[i] = nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
