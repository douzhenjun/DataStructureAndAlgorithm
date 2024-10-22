package 华为面试模拟题.接雨水;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution3 {
    public int trap(int[] height){
        int len = height.length;
        int sum = 0;
        for(int i = 1; i < len-1; i++){
            int maxLeft = 0;
            for(int j = 0; j < i; j++){
                if(height[j] > maxLeft){
                    maxLeft = height[j];
                }
            }
            int maxRight = 0;
            for(int k = i+1; k < len; k++){
                if(height[k] > maxRight){
                    maxRight = height[k];
                }
            }
            int count = Math.min(maxLeft, maxRight) - height[i];
            if(count > 0){
                sum += count;
            }
        }
        return sum;
    }
}
