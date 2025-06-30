package 力扣真题.动态规划.不同的二叉搜索树;

/**
 * @Description
 * 给定1到n这些结点,问可以构造出多少种二叉搜索树?(左子树节点小于根节点,右子树节点大于根节点的值)
 * 考虑dp[i]为节点个数为1~i时可以构造的二叉搜索树的最大个数.
 * dp[0]=1,dp[1]=1,dp[2]=2.
 * 对于n>=2,考虑其中一个节点作为根节点.那么另外n-1个结点有如下的分布:
 *      全分布在左子树,有n-1个结点,所以是dp[n-1]
 *      左子树有n-2个结点,右子树有1个结点,所以有dp[n-2]*dp[1],
 *      ... 
 *      左子树有n-k个结点,右子树有k-1个结点,所以有dp[n-k]*dp[k]
 *      ... 
 *      左子树有0个结点,右子树有n-1个结点,所以有dp[n-1]
 * 将这些情况相加,则得到dp[n] = dp[n-1]*dp[0]+dp[n-2]*dp[1]+...+dp[0]*dp[n-1].
 * @Author douzhenjun
 * @DATE 2024-03-04
 **/
public class Solution {
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
