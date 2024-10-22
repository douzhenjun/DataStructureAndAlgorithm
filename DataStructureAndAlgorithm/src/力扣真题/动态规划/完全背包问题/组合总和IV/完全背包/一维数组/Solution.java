package 力扣真题.动态规划.完全背包问题.组合总和IV.完全背包.一维数组;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-07
 **/
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j < target + 1; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= j) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
