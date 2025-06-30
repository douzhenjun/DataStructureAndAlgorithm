package 力扣真题.动态规划.打家劫舍2;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-10
 **/
public class Solution2 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robAction(nums, 0, nums.length - 1), robAction(nums, 1, nums.length));
    }

    public int robAction(int[] nums, int begin, int end) {
        int[] dp = new int[end - begin];
        dp[0] = nums[begin];
        for (int i = 1; i < end - begin; i++) {
            if (i >= 2) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[begin + i]);
            } else {
                dp[i] = Math.max(dp[i - 1], nums[begin + i]);
            }
        }
        return dp[end - begin - 1];
    }
}
