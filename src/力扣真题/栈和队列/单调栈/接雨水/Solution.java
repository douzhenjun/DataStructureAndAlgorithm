package 力扣真题.栈和队列.单调栈.接雨水;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-17
 **/
public class Solution {
    public int trap(int[] height){
        int len = height.length;
        if(len <= 2){
            return 0;
        }
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        
        //记录每个左边柱子的最大高度
        maxLeft[0] = height[0];
        for(int i = 1; i < len; i++){
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }
        //记录每个右边柱子的最大高度
        maxRight[len-1] = height[len-1];
        for(int i = len-2; i >= 0; i--){
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }
        //求和
        int sum = 0;
        for(int i = 0; i < len; i++){
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(count > 0){
                sum += count;
            }
        }
        return sum;
    }
}
