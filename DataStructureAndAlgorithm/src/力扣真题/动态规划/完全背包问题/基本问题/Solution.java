package 力扣真题.动态规划.完全背包问题.基本问题;

/**
 * @Description 
 * 完全背包问题，物品可以被放入多次，和01背包只能放入一次不同，求容量为n的背包所能装下的物品的最大价值。
 * 定义二维数组dp[i][j]来表示前i+1个商品放入容量为j的背包所能装下的物品的最大价值。
 * 初始化，dp[0][j]=k*value[0],其中k*weight[0]<=j.
 * dp[i][0]=0
 * 递推公式：对于i>0,j=0,1,...,n
 * 考虑weight[i]>j是否成立，如果成立，那么dp[i][j]=dp[i-1][j]
 * 如果不成立，那么dp[i][j]=max(dp[i-1][j],dp[i-1][j-k*w[i]]+v[i])(k=1,2,...,j/w[i]).
 * 将dp[i][j]的k展开，并和dp[i][j-w[i]]的展开项做比较，可以得到如下的等式，k可以消除
 * dp[i][j]=max(dp[i-1][j],dp[i][j-w[i]]+v[i]).注意这里和01背包的等式很像，区别在于i和i-1
 * @Author douzhenjun
 * @DATE 2024-03-06
 **/
public class Solution {
    public static void completePack(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight+1];
        for(int i = 0; i < weight.length; i++){
            for(int j = weight[i]; j <= bagWeight; j++){
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }
    }
}
