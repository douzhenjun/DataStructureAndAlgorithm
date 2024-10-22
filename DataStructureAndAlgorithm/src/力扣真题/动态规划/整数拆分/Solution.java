package 力扣真题.动态规划.整数拆分;

/**
 * @Description 
 * dp[i]表示元素为i时的最大乘积
 * 对于 j < i, dp[i] = Math.max((i-j)*j, j*dp[i-j]).
 * 这里得到的dp[i]也会随着j的增长而更新,所以应该是
 * dp[i] = Math.max(dp[i], Math.max((i-j)*j, j*dp[i-j])).
 * 为什么j不用拆分? 因为j从1开始遍历, i-j中覆盖了j的值
 *  j=1, 2, ..., i-1
 *  i-j=i-1, i-2, ..., 1
 * 又因为dp[1]无意义,它不能拆分成两个正因数的和,所以让i-j>1,所以j<i-1;
 * 初始化dp[2]=1.
 * @Author douzhenjun
 * @DATE 2024-03-04
 **/
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
