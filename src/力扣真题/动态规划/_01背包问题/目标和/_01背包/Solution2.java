package 力扣真题.动态规划._01背包问题.目标和._01背包;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-19
 **/
public class Solution2 {
    public int findTargetSumWays(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        int bagSize = (sum + target) / 2;//看上面的分析,这个bagSize不能是向下取整的
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;//这里一定要是1,因为对于i=0来说，如果nums[i]=j,那么dp[nums[i]]=1,否则dp[j]=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[bagSize];
    }
}
