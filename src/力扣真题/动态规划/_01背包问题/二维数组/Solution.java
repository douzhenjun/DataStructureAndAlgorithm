package 力扣真题.动态规划._01背包问题.二维数组;

import java.util.Arrays;

/**
 * @Description 
 * dp[i][j]表示物品0到i存入容量为j的背包,所产生的最大的价值
 * 它有两种方式可以推导, 第一种,物品i的重量大于背包的剩余容量,因此dp[i][j] = dp[i-1][j];
 * 第二种,物品i的重量小于等于背包的剩余容量,那么dp[i][j]的价值在放入物品i之前应该是dp[i-1][j-weight[i]]
 * 表示0~i这些物品放入到容量为j-weight[i]的背包所产生的最大价值
 * 在放入物品i之后,其价值为dp[i-1][j-weight[i]]+value[i].
 * 因此dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]).
 * @Author douzhenjun
 * @DATE 2024-03-04
 **/
public class Solution {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;//背包容量
        System.out.println(testWeightBagProblem(weight, value, bagSize));
    }

    public static int testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int goodSize = weight.length;
        //行表示把物品1到n中的任意物品放入背包
        //列表示背包的最大容量,由题目给出
        int[][] dp = new int[goodSize][bagSize + 1];
        //初始化dp
        //dp[i][0]=0,因为容量为0的背包不能装入任何物品,价值为0
        for (int i = 0; i < goodSize; i++) {
            dp[i][0] = 0;
        }
        //dp[0][j]要考虑j是否大于等于weight[0],如果是,则dp[0][j]=value[0],否则dp[0][j]=0;
        for (int j = 0; j < bagSize + 1; j++) {
            if (j < weight[0]) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = value[0];
            }
        }
        //递推公式dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]),weight[i]对应第i个物品的重量
        for (int i = 1; i < goodSize; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if(j < weight[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        
        //打印dp数组
        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        
        return dp[goodSize-1][bagSize];
    }
}
