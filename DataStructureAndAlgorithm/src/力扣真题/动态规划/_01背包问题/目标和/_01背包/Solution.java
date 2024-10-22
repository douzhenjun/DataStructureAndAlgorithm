package 力扣真题.动态规划._01背包问题.目标和._01背包;

import java.util.Arrays;

/**
 * @Description
 * 设目标和为target,非负整数的和为sum. 一部分使用+,这一类的和记做x,一部分使用-,这一类的和记作sum-x
 * 故而有 x - (sum - x) = target成立.
 * 因此 x = (target+sum)/2成立.
 * 边界条件
 * 首先这个x一定得是非负整数才可以,所以要求target+sum % 2 == 0; 并且target+sum >= 0
 * 另外考虑如果abs(target)>sum,这说明即使全部取加号(或减号)得到的结果都不能够得到target,所以直接返回0即可.
 * 考虑容量为x的背包能够装满nums中的某些数(正数), 共有几种可能?
 * 定义二维数组dp[i][j]表示容量为j的背包恰好装满nums[0-i]中的某些数的最多方法数.
 * 对于dp[0][j],只有当j=nums[0]时为1,其他为0.
 * 因此dp[0][nums[0]]=1
 * 对于dp[i][0],因为x>=0成立,所以要看nums[0-i]中有多少0,假设有n个0,那么有C(n,1)+C(n,2)+...+C(n,n)+1种可能
 * 于是dp[i][0]=2^n.
 * 递推公式
 * dp[i][j],当nums[i]>j时,它等于dp[i-1][j]
 * 当nums[i]<=j时,假如放入nums[i]能恰好装满背包j,那么拿掉nums[i]则能恰好装满背包j-nums[i]一定成立
 * 假如不放入,那么就加上不放入i但能装满背包j的可能性也就是dp[i-1][j]
 * 所以dp[i][j]=dp[i-1][j](nums[i] > j)
 *    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i]](nums[i]<=j)
 * @Author douzhenjun
 * @DATE 2024-03-05
 **/
public class Solution {
    public int findTargetSumWays(int[] nums, int target){
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if((sum + target) % 2 == 1 || Math.abs(target) > sum){
            return 0;
        }
        int bagSize = (sum + target) / 2;//看上面的分析,这个bagSize不能是向下取整的
        int[][] dp = new int[nums.length][bagSize+1];
        //初始化,见上面分析
        for(int col = 0; col < bagSize+1; col++){
            if(col == nums[0]){
                dp[0][col] = 1;
            }
        }
        for(int row = 0; row < nums.length; row++){
            int zeroNum = 0;
            //获得nums[0~row]中0的个数
            for(int tmp = 0; tmp <= row; tmp++){
                if(nums[tmp] == 0){
                    zeroNum++;
                }
            }
            dp[row][0] = (int)Math.pow(2, zeroNum);
        }
        //根据地推公式完善dp
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < bagSize+1; j++){
                if(nums[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                }
            }
        }
        
        return dp[nums.length-1][bagSize];
    }
}
