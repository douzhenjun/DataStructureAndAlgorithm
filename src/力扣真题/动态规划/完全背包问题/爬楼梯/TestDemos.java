package 力扣真题.动态规划.完全背包问题.爬楼梯;

import java.io.IOException;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-07
 **/
public class TestDemos {
    public static void main(String[] args) {
        int m = 2;
        int n = 10;
        Solution solution = new Solution();
        int res = solution.findStepWays(m, n);
        System.out.println(res);
    }
}
