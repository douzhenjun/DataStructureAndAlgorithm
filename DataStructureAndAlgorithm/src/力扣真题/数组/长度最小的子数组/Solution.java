package 力扣真题.数组.长度最小的子数组;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023-10-02
 **/
public class Solution {
    /*暴力解法*/
    public static int minSubArrayLen01(int s, int[] nums){
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        for(int i = 0; i < nums.length; i++){
            sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum >= s){
                    subLength = j - i + 1;
                    result = result < subLength ? result : subLength;
                    break;
                }
            }
        }
        //如果result没有被赋值的话, 就返回0, 说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /*滑动窗口解法*/
    public static int minSubArrayLen02(int s, int[] nums){
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;//记录结果数组的长度
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= s){
                result = Math.min(result, right-left+1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
