package 力扣真题.动态规划.打家劫舍;

/**
 * @Description
 * 定义dp[i]表示以前i个元素组成的数组可以获得的元素和的最大值
 * 对于数组的第i个元素来说,最大值要么是包含数组第i个元素的第i,i-2,i-4,...个元素的和,要么是
 * 不包含数组第i个元素的第i-1,i-3,i-5,...个元素的和
 * 也就是dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]).
 * 对于0,dp[0]=nums[0],dp[1]=Math.max(dp[0],nums[1]),
 * @Author douzhenjun
 * @DATE 2024-03-08
 **/
public class Solution {
    public int rob(int[] nums){
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i < nums.length+1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }
}
