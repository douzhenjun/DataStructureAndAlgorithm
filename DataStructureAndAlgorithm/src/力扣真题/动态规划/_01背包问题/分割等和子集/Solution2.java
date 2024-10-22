package 力扣真题.动态规划._01背包问题.分割等和子集;

import java.util.Arrays;

/**
 * @Description 考虑dp[i][j]表示把nums前i个元素放到容量为j的背包中的最大重量.
 * @Author douzhenjun
 * @DATE 2024-07-05
 **/
public class Solution2 {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);//做自然排序
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target] == target;
    }
}
