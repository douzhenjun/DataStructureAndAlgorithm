package 力扣真题.动态规划._01背包问题.分割等和子集;

/**
 * @Description 每种元素可以选择也可以不选择, 只需要判断它所有可能的组合中元素和是否有等于sum/2
 * @Author douzhenjun
 * @DATE 2024-07-05
 **/
public class Solution3 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        return dfs(nums, sum >> 1, 0);
    }

    private boolean dfs(int[] nums, int target, int index) {
        if (target == 0) {
            return true;
        }
        if (index == nums.length || target < 0) {
            return false;
        }
        return dfs(nums, target - nums[index], index + 1) || dfs(nums, target, index + 1);
    }
}
