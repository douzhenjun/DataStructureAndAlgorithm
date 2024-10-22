package 力扣真题.动态规划.完全背包问题.组合总和IV.暴力;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-07
 **/
public class TestDemo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        Solution solution = new Solution();
        int res = solution.combinationSum4(nums, target);
        System.out.println(res);
        System.out.println(solution.pathList);
        
        res = 0;
        solution.pathList.clear();
        
        int[] nums2 = {2, 1, 3};
        int target2 = 35;
        res = solution.combinationSum4(nums2, target2);
        System.out.println(res);
        System.out.println(solution.pathList);
    }
}
