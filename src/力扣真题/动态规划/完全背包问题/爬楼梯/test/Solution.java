package 力扣真题.动态规划.完全背包问题.爬楼梯.test;

/**
 * @Description 验证一下我的思路
 * @Author douzhenjun
 * @DATE 2024-03-14
 **/
public class Solution {
    public int findStepWays(int m, int n){
        if(n == 0){
            return 1;
        }
        int count = 1;
        int sum = 0;
        while(count <= m){
            sum += findStepWays(m, n-count);
            count++;
        }
        return sum;
    }
}
