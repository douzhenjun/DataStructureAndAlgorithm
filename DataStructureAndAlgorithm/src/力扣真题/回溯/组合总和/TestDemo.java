package 力扣真题.回溯.组合总和;


/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-28
 **/
public class TestDemo {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(candidates, target));
    }
}
