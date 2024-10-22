package 力扣真题.动态规划._01背包问题.分割等和子集;

/**
 * @Description 针对3的优化, 减少重复计算
 * @Author douzhenjun
 * @DATE 2024-07-05
 **/
public class Solution4 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum >> 1;
        Boolean[][] map = new Boolean[nums.length][target + 1];
        return dfs(nums, target, 0, map);
    }

    private boolean dfs(int[] nums, int target, int index, Boolean[][] map) {
        if (target == 0) {
            return true;
        }
        if (index == nums.length || target < 0) {
            return false;
        }
        if (map[index][target] != null) {
            return map[index][target];
        }
        boolean select = dfs(nums, target - nums[index], index + 1, map);
        boolean unSelect = dfs(nums, target, index + 1, map);
        if (select || unSelect) {
            map[index][target] = true;
            return true;
        }
        map[index][target] = false;
        return false;
    }
}
