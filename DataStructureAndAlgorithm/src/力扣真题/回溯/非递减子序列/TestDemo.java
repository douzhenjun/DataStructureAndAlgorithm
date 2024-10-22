package 力扣真题.回溯.非递减子序列;

import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-02
 **/
public class TestDemo {
    public static void main(String[] args) {
        int [] nums = {4, 6, 7, 7};
        Solution solution = new Solution();
        List<List<Integer>> subsequences = solution.findSubsequences(nums);
        System.out.println(subsequences);
    }
}
