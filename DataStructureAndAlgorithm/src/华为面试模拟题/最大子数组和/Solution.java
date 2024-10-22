package 华为面试模拟题.最大子数组和;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class Solution {
    public int maxSubArray(int[] nums){
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > result){
                result = sum;
            }
            if(sum <= 0){
                sum = 0;
            }
        }
        return result;
    }
}
