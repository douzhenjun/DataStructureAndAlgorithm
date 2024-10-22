package 力扣真题.双指针.盛最多水的容器;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class Solution {
    public int maxArea(int[] height){
        int maxArea = 0;
        for(int i = 0, j = height.length - 1; i < j;){
            if(height[i] > height[j]){
                int area = height[j] * (j - i);
                maxArea = Math.max(maxArea, area);
                j--;
            }else{
                int area = height[i] * (j - i);
                maxArea = Math.max(maxArea, area);
                i++;
            }
        }
        return maxArea;
    }
}
