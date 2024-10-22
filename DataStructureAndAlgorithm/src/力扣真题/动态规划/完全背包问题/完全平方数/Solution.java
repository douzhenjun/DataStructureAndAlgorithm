package 力扣真题.动态规划.完全背包问题.完全平方数;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-07
 **/
public class Solution {
    public int numSquares(int n) {
        int index = 1;
        int m = 1;
        HashSet<Integer> set = new HashSet<>();//集合用来保存完全平方数
        while(m <= n){
            m = (int) Math.pow(index, 2);
            set.add(m);
            index++;
        }
        //m最终的值是距离n最近的完全平方数,m<=n
        m = (int) Math.pow(index-1, 2);
        //将整数1,2,...,m放入到容量为n的背包中,恰好装满
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;//跳过第一行,第一列,无意义, i = 1时,对于n>=1都有对应的1的组合数
        for(int j = 1; j < n+1; j++){
            dp[1][j] = dp[1][j-1]+1;//nums[i]=1
        }
        for(int i = 2; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= i && set.contains(i)){//只有是完全平方数才执行递推公式,否则该数不能够装入背包中,那么就沿用dp[i-1][j]即可
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-i]+1);
                }
            }
        }
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                System.out.printf("%5d", dp[i][j]);
            }
            System.out.println();
        }
        return dp[m][n];
    }
}
