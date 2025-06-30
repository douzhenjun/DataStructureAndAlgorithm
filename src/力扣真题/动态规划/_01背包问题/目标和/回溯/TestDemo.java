package 力扣真题.动态规划._01背包问题.目标和.回溯;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-05
 **/
public class TestDemo {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        Solution solution = new Solution();
        int result = solution.findTargetSumWays(nums, 3);
        System.out.println(result);
    }
}
